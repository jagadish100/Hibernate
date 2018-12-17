package client;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Student;

public class HQL_Update {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/oracle.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		String sql="update Student set name='venkat' where id=102";
		Query query=s.createQuery(sql);
		 int i=query.executeUpdate();
		 t.commit();
		 System.out.println(i);
		 s.close();
		 sf.close();

	}

}
