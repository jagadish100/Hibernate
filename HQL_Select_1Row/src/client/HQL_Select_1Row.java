package client;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import bean.Student;

public class HQL_Select_1Row {

	public static void main(String[] args) {
		
		Configuration cfg=new Configuration();
		cfg.configure("resources/oracle.cfg.xml");
		SessionFactory sf=cfg.buildSessionFactory();
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		
		String sql="from student where id=101";
		Query query=s.createQuery(sql);
		 Object o =query.executeUpdate();
		 Student st=(Student)o;
		 System.out.println(st.getId());
		 System.out.println(st.getName());
		 System.out.println(st.getEmail());
		 s.close();
		 sf.close();

	}

}
