package chatapp;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ChatappModel {
	
	
	Connection con;
	PreparedStatement statement;

	

	public Connection getCon() {	
		return con;
	}

	public void setCon() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		this.con =(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatDB","root","root");
	}

	public void setStatement(String query) throws SQLException {
		this.statement =(PreparedStatement) con.prepareStatement(query);
	}
	
	public PreparedStatement getStatement()
	{
		return statement;
	}

}
