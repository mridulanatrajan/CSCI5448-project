package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class CreateGroupView {

	private JFrame frmLetschat;
	private JTextField textField;
	private JLabel lblChooseMembers;
	private JTextField textField_1;
	private JButton btnAdd;
	Random rand = new Random();
	GroupMgmtController gm;
	String gname;
	private JButton btnBack;

	public CreateGroupView() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		gm=new GroupMgmtController();
		frmLetschat = new JFrame();
		frmLetschat.setTitle("LetsChat");
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setLayout(null);
		
		JLabel lblEnterNameOf = new JLabel("Enter Name of Group:");
		lblEnterNameOf.setBounds(12, 34, 154, 16);
		frmLetschat.getContentPane().add(lblEnterNameOf);
		
		textField = new JTextField();
		textField.setBounds(178, 24, 214, 44);
		frmLetschat.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblChooseMembers = new JLabel("Choose Members:");
		lblChooseMembers.setBounds(53, 161, 157, 16);
		frmLetschat.getContentPane().add(lblChooseMembers);
		
		textField_1 = new JTextField();
		textField_1.setBounds(44, 203, 216, 49);
		frmLetschat.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField_1.getText();
				textField_1.setText("");
				try {
					gm.addMemberToNewGroup(name, gname);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnAdd.setBounds(295, 201, 97, 25);
		frmLetschat.getContentPane().add(btnAdd);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gname=textField.getText();
				textField.setText("");
				int  n = rand.nextInt(10000) + 1;
				try {	
					gm.addnewGroup(gname,n);
				} catch (SQLException e1) {
					e1.printStackTrace();
			}
			}
		});
		btnSubmit.setBounds(155, 80, 131, 38);
		frmLetschat.getContentPane().add(btnSubmit);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				GrpMgmtView gv=new GrpMgmtView();
			}
		});
		btnBack.setBounds(169, 303, 117, 38);
		frmLetschat.getContentPane().add(btnBack);
		frmLetschat.setVisible(true);
	}
}
