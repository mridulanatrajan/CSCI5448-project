package chatapp;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ContactValidate extends UserValidateController{

	public ContactValidate(String u,User uu) throws ClassNotFoundException, SQLException {
		super(u,uu);
	}
	
	
	boolean validate(ResultSet r) throws SQLException, ClassNotFoundException{
		
		while(r.next())
		{
			if(uname.equals(r.getString("username")))
			{
				String contact=r.getString("username");
				int uid=per.getUserID();
				System.out.println(uid);
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatDB","root","root");
				PreparedStatement statement=(PreparedStatement) con.prepareStatement(" insert into contacts values('"+uid+"','"+contact+"')");
				statement.execute();
				return true;
			}
		}
		return false;
		
	}
	
	

}
