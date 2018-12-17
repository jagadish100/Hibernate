package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Student;

/**
 * Servlet implementation class StudentRegServlet
 */
@WebServlet("/reg")
public class StudentRegServlet extends HttpServlet {
	
	SessionFactory sf;
	@Override
	public void init() throws ServletException {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/oracle.cfg.xml");
		sf=cfg.buildSessionFactory();
		System.out.println("SessionFactory init");
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		int marks=Integer.parseInt(req.getParameter("marks"));
		
		Student st= new Student(0,name,email,marks);
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		int pk=(Integer)session.save(st);
		t.commit();
		resp.getWriter().println("Registration Successfull ID:"+pk);	
	}
	@Override
	public void destroy() {
		sf.close();
		super.destroy();
	}
}
