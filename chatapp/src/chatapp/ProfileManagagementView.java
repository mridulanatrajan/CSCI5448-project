package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ProfileManagagementView {
	
		PrflMgmtController pmc;

	private JFrame frmLetschat;

	public ProfileManagagementView() throws ClassNotFoundException, SQLException {
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
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.getContentPane().setLayout(null);
		pmc=new PrflMgmtController();

		JButton btnEditProfile = new JButton("Delete Account");
		btnEditProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure ?", null, dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
					frmLetschat.dispose();
					RegisterView rv=new RegisterView(); 
				}

			}
		});
		btnEditProfile.setBounds(162, 188, 147, 45);
		frmLetschat.getContentPane().add(btnEditProfile);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					frmLetschat.dispose();
					ProfileView pv=new ProfileView();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnViewProfile.setBounds(162, 254, 147, 45);
		frmLetschat.getContentPane().add(btnViewProfile);
		
		JLabel lblManageYourProfile = new JLabel("Manage your Profile");
		lblManageYourProfile.setBounds(162, 43, 202, 15);
		frmLetschat.getContentPane().add(lblManageYourProfile);
		
		JButton btnUpdatePicture = new JButton("Update Picture");
		btnUpdatePicture.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				try {
					UpdatePictureView upv=new UpdatePictureView();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdatePicture.setBounds(162, 131, 147, 45);
		frmLetschat.getContentPane().add(btnUpdatePicture);
		
		JButton btnChangeStatus = new JButton("Update Status");
		btnChangeStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				try {
					UpdateStatusView us= new UpdateStatusView();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnChangeStatus.setBounds(162, 70, 147, 45);
		frmLetschat.getContentPane().add(btnChangeStatus);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				HomeView hv=new HomeView();
				
			}
		});
		btnBack.setBounds(162, 311, 147, 33);
		frmLetschat.getContentPane().add(btnBack);
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setVisible(true);

	}
}
