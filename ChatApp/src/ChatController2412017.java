import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class ChatController2412017 {
	JFrame newframe = new JFrame("Contacts");
	JButton addnewcontact = new JButton("Add a Contact");
	JButton removecontact = new JButton("Remove an Existing Contact");
	JButton acceptrequest = new JButton("Accept a Request");
	JButton viewcontactlist = new JButton("View Contact List");
	JButton searchcontact = new JButton("Search Contacts");
	JButton goback1 = new JButton("Go Back");
	
	JLabel newcontname = new JLabel("Username of New Contact?");
	JTextField contname = new JTextField();
	JButton add1 = new JButton("Add");
	JButton goback2 = new JButton("Go Back");
	
	
	public void start() {
		newframe.setSize(800, 800);
		addnewcontact.setPreferredSize(new Dimension(150, 50));
		addnewcontact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1 ) {
				newframe.getContentPane().removeAll();
				JPanel newpanel1 = new JPanel();
				newpanel1.setBorder(new EmptyBorder(200, 200, 200, 200));
				newframe.setContentPane(newpanel);
				newframe.repaint();
				newframe.setLayout(new GridLayout(2,2));
				newframe.getContentPane().add(newcontname);
				newframe.getContentPane().add(contname);
				newframe.getContentPane().add(add1);
				newframe.getContentPane().add(goback2);
				add1.addActionListener(new ActionListenener() {
					public void actionPerformed(ActionEvent e2) {
						
					}
				}
						)
				
			}
		           }
				);
		
		removecontact.setPreferredSize(new Dimension(200, 50));
		
		
		acceptrequest.setPreferredSize(new Dimension(200, 50));
		
		
		viewcontactlist.setPreferredSize(new Dimension(200, 50));
		
		
		searchcontact.setPreferredSize(new Dimension(200, 50));
		
		
		newframe.getContentPane().add(addnewcontact);
		newframe.getContentPane().add(removecontact);
		newframe.getContentPane().add(acceptrequest);
		newframe.getContentPane().add(viewcontactlist);
		newframe.getContentPane().add(searchcontact);
		newframe.getContentPane().setLayout(new FlowLayout());
		newframe.setVisible(true);
	}
	
	public static void main(String args[]) throws Exception
	{
		ChatController2412017 obj1 = new ChatController2412017();
		obj1.start();
	}
	
}