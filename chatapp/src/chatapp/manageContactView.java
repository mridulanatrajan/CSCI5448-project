package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class manageContactView {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Create the application.
	 */
	public manageContactView() {
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
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdd.setBounds(230, 46, 117, 25);
		frame.getContentPane().add(btnAdd);
		
		JList list = new JList();
		list.setBounds(32, 134, 138, 75);
		frame.getContentPane().add(list);
		
		JLabel lblSelectAContact = new JLabel("Select a contact");
		lblSelectAContact.setBounds(22, 107, 138, 15);
		frame.getContentPane().add(lblSelectAContact);
		
		JButton btnStartChat = new JButton("start chat");
		btnStartChat.setBounds(230, 130, 117, 25);
		frame.getContentPane().add(btnStartChat);
	}
}
