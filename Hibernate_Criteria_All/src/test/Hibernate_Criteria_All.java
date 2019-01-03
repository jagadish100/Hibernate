package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import bean.Student;

public class Hibernate_Criteria_All {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/oracle.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(Student.class);
		Criterion cr=Restrictions.eq("id", 101);
		c.add(cr);
		Student st=(Student)c.uniqueResult();
		
		System.out.println(st.getId());
		System.out.println(st.getName());
		System.out.println(st.getEmail());
		System.out.println(st.getMarks());

	}

}
