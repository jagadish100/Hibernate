package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Admin;
import bean.HEmployee;
import bean.SEmployee;

public class Client {
public static void main(String[] args) {
	
	
	

	Configuration cfg=new Configuration();
	cfg.configure("resources/oracle.cfg.xml");
	SessionFactory sf=cfg.buildSessionFactory();
	Session s=sf.openSession();
	Transaction t=s.beginTransaction();
	
	SEmployee se=new SEmployee(1, "a", "a@", 100, "java");
	HEmployee he=new HEmployee(2, "b", "b@", 200, 9);
	Admin a=new Admin(3, "c", "c@", 300, "chennai");
	
	s.save(se);
	s.save(he);
	s.save(a);
	t.commit();
	s.close();
	sf.close();
	System.out.println("insert complete");
	
	
}
	
	
	
}
