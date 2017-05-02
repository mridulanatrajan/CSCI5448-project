package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class HomeView {

	private JFrame frmLetschat;
	User per;
	
	public HomeView()
	{
		initialize();
	}
	public HomeView(User u) {
		per=u;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * displays the available options to the user.
	 */
	private void initialize() {
		frmLetschat = new JFrame();
		frmLetschat.setTitle("LetsChat");
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setResizable(false);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setLayout(null);
		
		JLabel lblMyDasboard = new JLabel("My Dashboard");
		lblMyDasboard.setBounds(167, 12, 130, 15);
		frmLetschat.getContentPane().add(lblMyDasboard);
		
		JButton btnManageContacts = new JButton("Manage Contacts");
		btnManageContacts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				try {
					ManageContactView mc=new ManageContactView(per);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnManageContacts.setBounds(129, 119, 190, 41);
		frmLetschat.getContentPane().add(btnManageContacts);
		
		JButton btnManageGroups = new JButton("Manage Groups");
		btnManageGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				GrpMgmtView gmv= new GrpMgmtView();
			}
		});
		btnManageGroups.setBounds(129, 172, 190, 41);
		frmLetschat.getContentPane().add(btnManageGroups);
		
		JButton btnNewButton = new JButton("Manage Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				try {
					ProfileManagagementView pmv=new ProfileManagagementView();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(129, 66, 190, 41);
		frmLetschat.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign Out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				RegisterView rv=new RegisterView();
			}
		});
		btnNewButton_1.setBounds(129, 225, 190, 43);
		frmLetschat.getContentPane().add(btnNewButton_1);
		frmLetschat.setVisible(true);
	}

}
