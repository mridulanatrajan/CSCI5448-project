package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class manageContactView {

	private JFrame frame;
	private JTextField textField;
	User per;

	/**
	 * Create the application.
	 */
	public manageContactView(User u) {
		per=u;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddAContact = new JLabel("Add a contact");
		lblAddAContact.setBounds(12, 12, 123, 15);
		frame.getContentPane().add(lblAddAContact);
		
		textField = new JTextField();
		textField.setBounds(22, 39, 172, 39);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		DefaultListModel<String> listModel = new DefaultListModel<>();
		JList list = new JList(listModel);
		list.setBounds(32, 134, 138, 75);
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					contactValidate cv=new contactValidate(textField.getText(),per);
					if(cv.valid)
					{
						
						listModel.addElement(textField.getText());
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setBounds(230, 46, 117, 25);
		frame.getContentPane().add(btnAdd);
		list.setBounds(32, 134, 138, 75);
		frame.getContentPane().add(list);
		
		JLabel lblSelectAContact = new JLabel("Select a contact");
		lblSelectAContact.setBounds(22, 107, 138, 15);
		frame.getContentPane().add(lblSelectAContact);
		
		JButton btnStartChat = new JButton("start chat");
		btnStartChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				String friend=(String) list.getSelectedValue();
				
				//Client c=new Client();

				Client client = new Client(per,friend);
    	        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	        client.frame.setVisible(true);
    	        
    	        SwingWorker<String, Object> worker = new SwingWorker<String, Object>() {
    	            @Override
    	            protected String doInBackground() throws Exception {                
    	            	try {
    						client.run();
    					} catch (IOException e1) {
    						// TODO Auto-generated catch block
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
		btnStartChat.setBounds(230, 130, 117, 25);
		frame.getContentPane().add(btnStartChat);
		frame.setVisible(true);
	}
}
