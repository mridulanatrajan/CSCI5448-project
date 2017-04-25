package chatapp;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class registerController {
	
	public void addRecord(String username,String password) throws ClassNotFoundException, SQLException
	{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatDB","root","root");
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(" insert into users values('"+username+"','"+password+"','"+123+"')");
		statement.execute();
		
	}
	
	public registerController(String username, String password) throws ClassNotFoundException, SQLException
	{
		addRecord(username,password);
	}
	
	
	
}
