package chatapp;

import java.sql.ResultSet;
import java.sql.SQLException;

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
