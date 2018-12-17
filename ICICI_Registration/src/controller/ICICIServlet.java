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

import bean.ICICIBean;

@WebServlet("/create")
public class ICICIServlet extends HttpServlet {

	SessionFactory sf;
	@Override
	public void init() throws ServletException {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/oracle.cfg.xml");
		sf=cfg.buildSessionFactory();
			}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long phone=Long.parseLong(req.getParameter("phone"));
		int balance=Integer.parseInt(req.getParameter("balance"));
		
		ICICIBean icici=new ICICIBean(null, name, email, phone, balance);
		Session session=sf.openSession();
		Transaction t=session.beginTransaction();
		String ac=(String)session.save(icici);
		t.commit();
		session.close();
		resp.getWriter().println("account"+ac);
	}
	@Override
	public void destroy() {
		
	sf.close();
	}

}
