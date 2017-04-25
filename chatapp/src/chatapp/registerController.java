package chatapp;

import java.sql.DriverManager;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.util.Random;


public class registerController {
	
	public void addRecord(String username,String password) throws ClassNotFoundException, SQLException
	{
		Random rand = new Random();
		int  n = rand.nextInt(1000) + 1;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatDB","root","root");
		PreparedStatement statement=(PreparedStatement) con.prepareStatement(" insert into users values('"+username+"','"+password+"','"+n+"')");
		statement.execute();
		
	}
	
	public registerController(String username, String password) throws ClassNotFoundException, SQLException
	{
		addRecord(username,password);
	}
	
	
	
}
