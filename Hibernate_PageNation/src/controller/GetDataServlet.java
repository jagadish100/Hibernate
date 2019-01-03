package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Student;

/**
 * Servlet implementation class GetDataServlet
 */
@WebServlet("/select")
public class GetDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		PrintWriter out=resp.getWriter();
		Session s=sf.openSession();
		
		int fr=Integer.parseInt(req.getParameter("fr"));
		int mr=Integer.parseInt(req.getParameter("mr"));
		
		Criteria cr=s.createCriteria(Student.class);
		cr.setFirstResult(fr);
		cr.setMaxResults(mr);
		
		List<Student> list=cr.list();
		for(Student st: list)
		{
			out.println("id="+st.getId()+"\t name="+st.getName()+"\t email="+st.getEmail());
		}
		
		
		
	}
	@Override
	public void destroy() {
		sf.close();
		super.destroy();
	}
}
