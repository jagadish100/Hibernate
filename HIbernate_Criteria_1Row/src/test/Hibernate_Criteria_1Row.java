package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Student;

public class Hibernate_Criteria_1Row {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/oracle.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Criteria cr=s.createCriteria(Student.class);
		List<Student> list=cr.list();
		for(Student st : list)
		{
			System.out.println(st.getId());
			System.out.println(st.getName());
			System.out.println(st.getEmail());
			System.out.println(st.getMarks());
		}

	}

}
