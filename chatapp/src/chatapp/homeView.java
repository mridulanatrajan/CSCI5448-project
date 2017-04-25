package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class homeView {

	private JFrame frmLetschat;
	/**
	 * Create the application.
	 */
	public homeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLetschat = new JFrame();
		frmLetschat.setTitle("LetsChat");
		frmLetschat.setResizable(false);
		frmLetschat.setBounds(100, 100, 450, 300);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setLayout(null);
		
		JLabel lblMyDasboard = new JLabel("My Dashboard");
		lblMyDasboard.setBounds(177, 12, 130, 15);
		frmLetschat.getContentPane().add(lblMyDasboard);
		
		JButton btnManageContacts = new JButton("Manage Contacts");
		btnManageContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				manageContactView mc=new manageContactView();
			}
		});
		btnManageContacts.setBounds(129, 39, 190, 37);
		frmLetschat.getContentPane().add(btnManageContacts);
		
		JButton btnManageGroups = new JButton("Manage Groups");
		btnManageGroups.setBounds(129, 88, 190, 41);
		frmLetschat.getContentPane().add(btnManageGroups);
		
		JButton btnStartAChat = new JButton("Start a Chat");
		btnStartAChat.setBounds(129, 141, 190, 37);
		frmLetschat.getContentPane().add(btnStartAChat);
		frmLetschat.setVisible(true);
	}

}
