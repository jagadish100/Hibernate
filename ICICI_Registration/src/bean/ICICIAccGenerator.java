package bean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;

public class ICICIAccGenerator extends IdentityGenerator {

	
	String name="ICICI";
	@Override
	public Serializable generate(SharedSessionContractImplementor s, Object obj) {
		
		try {
		Connection con=s.connection();
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("select icici.nextval from dual");
				if(rs.next())
				{
					name=name+rs.getInt(1);
				}
		
		}
		catch(Exception e)
		{
			
		}
		return name;
	}
}
