package chatapp;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.util.Random;


public class RegisterController {
	
	Connection con;
	PreparedStatement stmt;
	ChatappModel c=new ChatappModel();
	
	public RegisterController() throws ClassNotFoundException, SQLException
	{
		c.setCon();
		con=c.getCon();
		
	}
	public void addRecord(String username,String password) throws ClassNotFoundException, SQLException
	{
		Random rand = new Random();
		int  n = rand.nextInt(1000) + 1;
		stmt=(PreparedStatement) con.prepareStatement(" insert into users values('"+username+"','"+password+"','"+n+"')");
		stmt.execute();
	}
	
	public boolean checkIfUnique(String username) throws SQLException
	{
		stmt=(PreparedStatement) con.prepareStatement(" select * from users ");
		ResultSet rs=stmt.executeQuery();
		while (rs.next())
		{
			if(username.equals(rs.getString("username"))){
				return false;
			}
		}
		return true;
	}
	
}
