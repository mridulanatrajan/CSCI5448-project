package chatapp;
import java.net.*;

import java.awt.Dimension;

import java.awt.GridLayout;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class group {
	JFrame frame = new JFrame("Group Management");
	JButton existingUser=new JButton("Sign in");
    JButton newGroup = new JButton("Create");
    JButton addMember = new JButton("Add Member");
    JButton removeMember = new JButton("Remove Member");
    JButton exitGroup = new JButton("Exit Group");
    JButton memberAdmin = new JButton("Make Members Admin");
    JButton deleteGroup = new JButton("Delete Group");
    JLabel contactName = new JLabel("Enter Contact Name");
    JLabel groupName = new JLabel("Enter Group Name");
    JLabel groupId = new JLabel("Enter Group Id");
    JTextField cName1 = new JTextField();
    JTextField gName1 = new JTextField();
    JTextField grp_Id1 = new JTextField();
    String gName,cName,grp_Id;
    static int id = 0;
    
    public void setGroupName(String u)
	{
		gName = u;
	}
	public void setContactName(String p)
	{
		cName = p;
	}
	public void setGroupId(String q)
	{
		grp_Id = q;
	}
	public static void Connection()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Connection Successful");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void createGroup() throws ClassNotFoundException, SQLException
	{
		Connection();
		String host = "jdbc:mysql://localhost:3306/ChatDB";
		String username = "root";
		String password = "sqlhari64";
			Connection connect = (com.mysql.jdbc.Connection) DriverManager.getConnection(host, username, password);
			System.out.println("Success!");
			java.sql.Statement myStmt = connect.createStatement();
			myStmt.execute("INSERT INTO newgroup (id,group_id,group_name,contact_name) VALUES"+"('004','100','gName','cName')");
	    	//ResultSet myRs = myStmt.executeQuery("Select * from group");
	    	//while (myRs.next())
	    	 // {
	    	  //  System.out.println(myRs.getString("id") + "," + myRs.getString("groupName"));
	    		  
	    	 // }
	    	 // System.out.println("");
	    	//ResultSet myRs = myStmt.executeQuery("Select * from NewUser1");
		
		/*Class.forName("com.mysql.jdbc.Driver");
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/chatdb","root","sqlhari64");
		System.out.println("Connection established");
		java.sql.Statement statement = con.createStatement();
		//PreparedStatement statement=(PreparedStatement) con.prepareStatement("insert into group values('"+cName+"','"+gName+"','"+123+"');");
		statement.execute("insert into group(id, groupName, contactName) values("+id+", '"+this.gName+"', '"+this.cName+"');");
		//statement.setInt(1, id);
		//statement.setString(2, this.gName);
		//statement.setString(3, this.cName);
		//System.out.println(statement);
		//statement.execute();
		id = id + 1;
		con.close();*/
	}

	
public static void main(String[] args){
	    group g = new group();
    	
    	g.frame.setSize(700, 700);
    	g.frame.setLayout(new GridLayout(3,2));
    	
    	System.out.println("hello");
    	g.existingUser.setPreferredSize(new Dimension(200,40));
    	g.frame.add(g.existingUser);
    	g.existingUser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent a) {
				System.out.println("helloooooo");
				g.frame.getContentPane().removeAll();
				JPanel panel=new JPanel();
				panel.setBorder(new EmptyBorder(200,200,200,200));
				g.frame.setContentPane(panel);
				g.frame.repaint();
				g.frame.setLayout(new GridLayout(3,2));
				g.frame.getContentPane().add(g.newGroup);
				g.newGroup.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                	g.frame.getContentPane().removeAll();
    				JPanel panel=new JPanel();
    				panel.setBorder(new EmptyBorder(200,200,200,200));
    				g.frame.setContentPane(panel);
    				g.frame.repaint();
    				g.frame.setLayout(new GridLayout(3,2));
    				g.frame.getContentPane().add(g.cName1);
    				g.frame.getContentPane().add(g.gName1);
    				g.frame.getContentPane().add(g.addMember);
    				g.addMember.addActionListener(new ActionListener(){
    					public void actionPerformed(ActionEvent e){
    					g.setContactName(g.cName1.getText());
						g.setGroupName(g.gName1.getText());
						try {
							g.createGroup();
							multicast m1 = new multicast();
							m1.Group();
						    
						     
						}
						catch(ClassNotFoundException | SQLException e1){
							e1.printStackTrace();
						} catch (UnknownHostException e1) {
							
							e1.printStackTrace();
						}
    					}
    					});
    				g.frame.setVisible(true);
                }
				});
			g.frame.setVisible(true);
			}
    	});
    	g.frame.setVisible(true);
}
}
