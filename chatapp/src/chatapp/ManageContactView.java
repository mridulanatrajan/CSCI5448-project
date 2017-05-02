package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class ManageContactView {

	private JFrame frmLetschat;
	private JTextField textField;
	User per;
	Connection con;
	PreparedStatement stmt;
	ResultSet st;
	ChatappModel c=new ChatappModel();
	int index;
	String contact;

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ManageContactView(User u) throws ClassNotFoundException, SQLException {
		per=u;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frmLetschat = new JFrame();
		frmLetschat.setTitle("LetsChat");
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setLayout(null);
		
		JLabel lblAddAContact = new JLabel("Add a contact");
		lblAddAContact.setBounds(12, 12, 123, 15);
		frmLetschat.getContentPane().add(lblAddAContact);
		
		textField = new JTextField();
		textField.setBounds(22, 39, 172, 39);
		frmLetschat.getContentPane().add(textField);
		textField.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		DefaultListModel<String> listModel = new DefaultListModel<>();
		JList list = new JList(listModel);
		//scrollPane.setViewportView(list);
		frmLetschat.getContentPane().add(scrollPane);
		c.setCon();
		con=c.getCon();
		stmt=(PreparedStatement) con.prepareStatement("select *  from contacts where userid='"+User.userID+"'");
		st=stmt.executeQuery();
		while(st.next())
		{
			listModel.addElement(st.getString("contact"));
		}
		
		list.setBounds(32, 134, 138, 141);
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ContactValidate cv=new ContactValidate(textField.getText(),per);
					if(cv.valid)
					{
						
						listModel.addElement(textField.getText());
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(280, 39, 117, 39);
		frmLetschat.getContentPane().add(btnAdd);
		list.setBounds(32, 134, 138, 75);
		frmLetschat.getContentPane().add(list);
		
		JLabel lblSelectAContact = new JLabel("Select a contact");
		lblSelectAContact.setBounds(22, 107, 138, 15);
		frmLetschat.getContentPane().add(lblSelectAContact);
		
		JButton btnStartChat = new JButton("start chat");
		btnStartChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLetschat.dispose();
				String friend=(String) list.getSelectedValue();
				Client client = new Client(per,friend);
    	        client.frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	        client.frmLetschat.setVisible(true);
    	        
    	        SwingWorker<String, Object> worker = new SwingWorker<String, Object>() {
    	            @Override
    	            protected String doInBackground() throws Exception {                
    	            	try {
    						client.run();
    					} catch (IOException e1) {
    						e1.printStackTrace();
    					} 
    	            	return "hi";
    	            }
    	            @Override
    	            protected void done() {
    	               
    	            }
    	        };      
    	        worker.execute();
			}
		});
		btnStartChat.setBounds(280, 117, 117, 51);
		frmLetschat.getContentPane().add(btnStartChat);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmLetschat.dispose();
					ProfileManagagementView pmv=new ProfileManagagementView();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBack.setBounds(183, 270, 117, 51);
		frmLetschat.getContentPane().add(btnBack);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(153, 148, 17, 61);
		frmLetschat.getContentPane().add(scrollBar);
		
		JButton btnDeleteContact = new JButton("Delete Contact");
		btnDeleteContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = list.getSelectedIndex();
				contact=(String) list.getSelectedValue();
				listModel.removeElementAt(index);
				try {
					stmt=(PreparedStatement) con.prepareStatement("delete from contacts where contact='"+contact+"'");
					stmt.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
			
		});
		btnDeleteContact.setBounds(265, 195, 147, 39);
		frmLetschat.getContentPane().add(btnDeleteContact);
		frmLetschat.setVisible(true);
	}
}
