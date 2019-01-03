package test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import bean.Student;

public class Hibernate_Criteria_1Column {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/oracle.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Criteria c=s.createCriteria(Student.class);
		
		Projection p=Projections.property("name");
		c.setProjection(p);
		List<String> list=c.list();
		
		for(String name:list)
		{
			System.out.println(name);
		}
	}

}
