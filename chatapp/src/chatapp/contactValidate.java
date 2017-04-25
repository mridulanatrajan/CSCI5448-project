package chatapp;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class contactValidate extends userValidateController{

	public contactValidate(String u) throws ClassNotFoundException, SQLException {
		super(u);
	}
	
	
	boolean validate(ResultSet r) throws SQLException{
		
		while(r.next())
		{
			if(uname.equals(r.getString("username")))
			{
				return true;
			}
		}
		return false;
		
	}

}
