package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdateStatusView {

	private JFrame frmLetschat;
	private JTextField textField;
	String oldstatus;
	String newstatus;
	PrflMgmtController pmc;
	private JButton btnBack;
	
	public UpdateStatusView() throws SQLException, ClassNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws SQLException, ClassNotFoundException {
		pmc=new PrflMgmtController();
		frmLetschat = new JFrame();
		frmLetschat.setTitle("LetsChat");
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(53, 73, 364, 65);
		frmLetschat.getContentPane().add(textField);
		textField.setColumns(10);
		
		oldstatus=pmc.getStatus();
		textField.setText(oldstatus);
		
		JButton btnUpdate = new JButton("Update Status");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				newstatus=textField.getText();
				try {
					pmc.updateStatus(newstatus);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnUpdate.setBounds(153, 179, 157, 46);
		frmLetschat.getContentPane().add(btnUpdate);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				try {
					ProfileManagagementView pmv=new ProfileManagagementView();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBack.setBounds(178, 254, 117, 40);
		frmLetschat.getContentPane().add(btnBack);
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.setVisible(true);
	}
}
