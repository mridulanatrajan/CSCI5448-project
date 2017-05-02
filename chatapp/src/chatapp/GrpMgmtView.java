package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.UIManager;

public class GrpMgmtView {

	private JFrame frmLetschat;
	
	public GrpMgmtView() {
		initialize();
	}

	private void initialize() {
		frmLetschat = new JFrame();
		frmLetschat.setTitle("LetsChat");
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Create a New Group");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				try {
					CreateGroupView cgv=new CreateGroupView();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			}
		});
		btnNewButton.setBounds(123, 76, 219, 44);
		frmLetschat.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Groups");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLetschat.dispose();
				try {
					UserGroupView ugv=new UserGroupView();
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(139, 158, 178, 53);
		frmLetschat.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProfileManagagementView pmv=new ProfileManagagementView();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(177, 250, 117, 53);
		frmLetschat.getContentPane().add(btnNewButton_2);
		frmLetschat.setVisible(true);
	}

}