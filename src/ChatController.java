import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.DriverManager;
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





public class ChatController {
	
	   	JFrame frame = new JFrame("LetsChat");
	    JButton newUser=new JButton("Sign up");
	    JButton existingUser=new JButton("Sign in");
	    JButton submit=new JButton("Submit");
	    JLabel username=new JLabel("Enter Username");
	    JLabel password=new JLabel("Enter Password");
	    JTextField uname=new JTextField();
	    JTextField pass=new JTextField();
	    String name;
	    String upass;
	    
	    public void addRecord() throws ClassNotFoundException, SQLException
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ChatDB","root","root");
			PreparedStatement statement=(PreparedStatement) con.prepareStatement(" insert into users values('"+name+"','"+upass+"','"+123+"')");
			statement.execute();
			
		}
		public void setUserName(String u)
		{
			name=u;
		}
		public void setPassword(String p)
		{
			upass=p;
		}
		public void renderstart()
		{
			frame.setSize(700, 700);
			newUser.setPreferredSize(new Dimension(200,40));
			newUser.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e)
			      {
					frame.getContentPane().removeAll();
					JPanel panel=new JPanel();
					panel.setBorder(new EmptyBorder(200,200,200,200));
					frame.setContentPane(panel);
					frame.repaint();
					frame.setLayout(new GridLayout(3,2));
					frame.getContentPane().add(username);
					frame.getContentPane().add(uname);
					frame.getContentPane().add(password);
					frame.getContentPane().add(pass);
					frame.getContentPane().add(submit);
					submit.addActionListener(new ActionListener(){
							public void actionPerformed(ActionEvent e)
							{
								setUserName(uname.getText());
								setPassword(pass.getText());
								try {
									addRecord();
								} catch (ClassNotFoundException | SQLException e1) {
									e1.printStackTrace();
								}
							}
						});
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      }
			});
			existingUser.setPreferredSize(new Dimension(200,40));
	        frame.getContentPane().setLayout(new FlowLayout());
	        frame.getContentPane().setBackground(new Color(111,209,237));
	        frame.getContentPane().add(newUser);
			frame.getContentPane().add(existingUser);
			frame.setVisible(true);
			
			
		}
	
		public static void main(String args[]) throws Exception
		{
			ChatController cc=new ChatController();
			cc.renderstart();
		}
}
