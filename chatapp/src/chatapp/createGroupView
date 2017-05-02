package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class createGroupView {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblChooseMembers;
	private JTextField textField_1;
	private JButton btnAdd;
	Random rand = new Random();
	GroupMgmtController gm;
	String gname;

	public createGroupView() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		gm=new GroupMgmtController();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterNameOf = new JLabel("Enter Name of Group:");
		lblEnterNameOf.setBounds(12, 34, 154, 16);
		frame.getContentPane().add(lblEnterNameOf);
		
		textField = new JTextField();
		textField.setBounds(178, 34, 214, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblChooseMembers = new JLabel("Choose Members:");
		lblChooseMembers.setBounds(44, 128, 157, 16);
		frame.getContentPane().add(lblChooseMembers);
		
		textField_1 = new JTextField();
		textField_1.setBounds(36, 168, 216, 22);
		frame.getContentPane().add(textField_1);
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
		btnAdd.setBounds(295, 166, 97, 25);
		frame.getContentPane().add(btnAdd);
		
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
		btnSubmit.setBounds(158, 65, 117, 25);
		frame.getContentPane().add(btnSubmit);
		frame.setVisible(true);
	}
}
