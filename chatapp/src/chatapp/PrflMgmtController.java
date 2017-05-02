package chatapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.PreparedStatement;

public class PrflMgmtController {
	
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	ChatappModel c=new ChatappModel();
	InputStream binaryStream;
	Blob image;
	String status;

	public PrflMgmtController() throws ClassNotFoundException, SQLException
	{
		c.setCon();
		con=c.getCon();
	}
	public String getStatus() throws SQLException
	{
		stmt=(PreparedStatement) con.prepareStatement("select * from profileinfo where username='"+User.getUsername()+"'");
		rs=stmt.executeQuery();
		if (rs.next())
		{
			return rs.getString("status");
		}
		else
		{
			stmt=(PreparedStatement) con.prepareStatement("insert into profileinfo (username) values ('"+User.getUsername()+"')");
			return "";	
		}
	}
	
	public void updateStatus(String newstatus) throws SQLException
	{
		stmt=(PreparedStatement) con.prepareStatement(" update profileinfo set status='"+newstatus+"'where username='"+User.getUsername()+"'");
		stmt.execute();
	}
	
	public void updatePicture(File f) throws SQLException, FileNotFoundException{
		
		stmt=(PreparedStatement) con.prepareStatement(" update profileinfo set image=? where username='"+User.getUsername()+"'");
		FileInputStream in = new FileInputStream(f);
		stmt.setBinaryStream(1, in, f.length()); 
		stmt.execute();
		
	}
	
	public InputStream getPicture() throws SQLException{
		
		stmt=(PreparedStatement) con.prepareStatement("select * from profileinfo where username='"+User.getUsername()+"'");
		rs=stmt.executeQuery();
		while(rs.next())
		{
			image = (Blob) rs.getBlob("image");
			binaryStream = image.getBinaryStream(1, image.length());
		}
		
		return binaryStream;	
	}
	
}
