package chatapp;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public abstract class userValidateController {
	
	boolean valid;
	String uname;
	String upass;
	User per;
	
	public userValidateController(String u,User uu) throws ClassNotFoundException, SQLException
	{
	 uname=u;
	 per=uu;
	 valid=connecttoDB();	
	}
	public userValidateController(String u, String p,User uu) throws ClassNotFoundException, SQLException
	{
	 uname=u;
	 upass=p;
	 per=uu;
	 valid=connecttoDB();	
	}
	
	boolean connecttoDB() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatDB","root","root");
		PreparedStatement statement=(PreparedStatement) con.prepareStatement("select * from users");
		ResultSet rs=statement.executeQuery();
		return validate(rs);
		
		
	}
	
	abstract boolean validate(ResultSet r)throws SQLException,ClassNotFoundException;

}
