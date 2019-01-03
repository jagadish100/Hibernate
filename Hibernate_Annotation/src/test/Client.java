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
		
		Student st=new Student();
		st.setId(101);
		st.setName("jaga");
		st.setEmail("abc@gmail.com");
		st.setAddress("guntur");
		
		int i=(Integer)s.save(st);
		System.out.println(i);
		//s.persist(st);
		//s.saveOrUpdate(st);
		t.commit();
		s.close();sf.close();
		System.out.println("insert complete");
	}
}
