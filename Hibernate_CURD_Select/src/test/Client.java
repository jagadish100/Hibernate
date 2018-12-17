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
		
		Object o=s.get(Student.class, 101);
	Student st=(Student)o;
		System.out.println(st.getId());
		System.out.println(st.getName());
		System.out.println(st.getEmail());
		System.out.println(st.getMarks());
				
		s.close();sf.close();
		System.out.println("select complete");
	}
}
