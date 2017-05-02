package chatapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class GroupMgmtController {
	
	
	ChatappModel c;
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	boolean candelete;
	
	GroupMgmtController() throws ClassNotFoundException, SQLException
	{
		ChatappModel c=new ChatappModel();
		c.setCon();
		con=c.getCon();
	}
	public void addnewGroup(String gname, int id) throws SQLException
	{
		System.out.println("hello");
		
		st=(PreparedStatement) con.prepareStatement(" insert into groups values('"+id+"','"+gname+"')");
		st.execute();
		st=(PreparedStatement) con.prepareStatement(" insert into groupmembers values('"+gname+"','"+User.username+"','"+"Admin"+"')");
		st.execute();
	}
	public void addMemberToNewGroup(String member,String gname) throws SQLException
	{
		st=(PreparedStatement) con.prepareStatement("select * from users");
		rs=st.executeQuery();
		while(rs.next())
		{
			if(member.equals(rs.getString("username")))
			{
				st=(PreparedStatement) con.prepareStatement(" insert into groupmembers values('"+gname+"','"+member+"','"+"Member"+"')");
				st.execute();
				break;
			}
		}
		
	}
	
	public ResultSet getGroups() throws SQLException
	{
		st=(PreparedStatement) con.prepareStatement("select groupname from groupmembers where username='"+User.username+"'");
		rs=st.executeQuery();
		return rs;
	}
	
	public ResultSet retreiveGroupMembers() throws SQLException
	{
		st=(PreparedStatement) con.prepareStatement("select * from groupmembers where groupname='"+Group.getGroupname()+"'");
		rs=st.executeQuery();
		return rs;
		
	}
	
	public boolean deleteGroup(String grp) throws SQLException
	{
		st=(PreparedStatement) con.prepareStatement("select * from groupmembers where groupname='"+grp+"'");
		rs=st.executeQuery();
		while(rs.next())
		{
			if(rs.getString("username").equals(User.getUsername()) && "Admin".equals(rs.getString("role")))
			{
			  st=(PreparedStatement) con.prepareStatement("delete from groupmembers where groupname='"+grp+"'");
			  st.executeUpdate();
			  st=(PreparedStatement) con.prepareStatement("delete from groups where groupname='"+grp+"'");
			  st.executeUpdate();
			  return true;
			}
		}
		return false;
	
		
	}

}
