package client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Student;

public class Test {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/oracle.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		Student st=new Student(100, "praveen", "praveen@");
		Student st1=new Student(101, "sai", "sai@");
		Student st2=new Student(102, "jaga", "jaga@");
		
		s.save(st);
		s.save(st1);
		s.save(st2);
		t.commit();
		s.close();
		sf.close();
		System.out.println("save success");

	}

}
