package chatapp;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SignInValidate extends UserValidateController {

	
	
	public SignInValidate(String u, String p,User uu) throws ClassNotFoundException, SQLException {
		super(u, p, uu);
		// TODO Auto-generated constructor stub
	}

	boolean validate(ResultSet r) throws SQLException,ClassNotFoundException{
		
		while(r.next())
		{
			if(uname.equals(r.getString("username"))&& upass.equals(r.getString("pass")))
			{
				per.setPassword(upass);
				per.setUsername(uname);
				per.setUserID(r.getInt("userid"));
				return true;
			}
		}
		return false;
		
	}
	

}
