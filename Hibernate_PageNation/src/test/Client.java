package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import bean.Student;

public class Client {

	public static void main(String[] args) {
		
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/oracle.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		Student os1=new Student(1, "abc", "abc@gmail.com", 10);
		Student os2=new Student(2, "def", "def@gmail.com", 20);
		Student os3=new Student(3, "ghi", "ghi@gmail.com", 30);
		Student os4=new Student(4, "jkl", "jkl@gmail.com", 40);
		
		s.save(os1);
		s.save(os2);
		s.save(os3);
		s.save(os4);
		
		t.commit();
		s.close();sf.close();
		System.out.println("insert complete");

	}

}
