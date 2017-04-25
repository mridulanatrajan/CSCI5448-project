package chatapp;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class userValidateController {
	
	boolean valid;
	public userValidateController(String u, String p) throws ClassNotFoundException, SQLException
	{
	 valid=checkRecord(u,p);	
	}
	
	boolean checkRecord(String username, String password) throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatDB","root","root");
		PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from users");
		ResultSet rs=statement.executeQuery();
		
		while(rs.next())
		{
			System.out.println(rs.getString("first")+ " "+ rs.getString("last"));
			
			if(username.equals(rs.getString("first"))&& password.equals(rs.getString("last")))
			{
				return true;
			}
		}
		return false;
	}

}
