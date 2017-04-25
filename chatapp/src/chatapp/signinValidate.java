package chatapp;
import java.sql.ResultSet;
import java.sql.SQLException;


public class signinValidate extends userValidateController {

	
	
	public signinValidate(String u, String p) throws ClassNotFoundException, SQLException {
		super(u, p);
		// TODO Auto-generated constructor stub
	}

	boolean validate(ResultSet r) throws SQLException{
		
		while(r.next())
		{
			if(uname.equals(r.getString("username"))&& upass.equals(r.getString("pass")))
			{
				User u=new User();
				u.setPassword(upass);
				u.setUsername(uname);
				u.setUserID(r.getInt("userid"));
				return true;
			}
		}
		return false;
		
	}
	

}
