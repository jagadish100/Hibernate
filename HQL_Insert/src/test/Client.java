package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.OldStudent;


public class Client {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/oracle.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		OldStudent os1=new OldStudent(1, "abc", "abc@gmail.com", "xyz");
		OldStudent os2=new OldStudent(2, "def", "def@gmail.com", "xyz");
		OldStudent os3=new OldStudent(3, "ghi", "ghi@gmail.com", "xyz");
		OldStudent os4=new OldStudent(4, "jkl", "jkl@gmail.com", "xyz");
		
		s.save(os1);
		s.save(os2);
		s.save(os3);
		s.save(os4);
		
		t.commit();
		s.close();sf.close();
		System.out.println("insert complete");
	}
}
