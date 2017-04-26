package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class signUpView {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	User u=new User();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signUpView window = new signUpView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public signUpView() {
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
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		lblEnterUsername.setBounds(77, 60, 132, 15);
		frame.getContentPane().add(lblEnterUsername);
		
		textField = new JTextField();
		textField.setBounds(227, 58, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setBounds(77, 106, 122, 15);
		frame.getContentPane().add(lblEnterPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(227, 104, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnRegisterMe = new JButton("Register Me");
		btnRegisterMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				try {
					registerController rc=new registerController(textField.getText(),textField_1.getText());
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				homeView hv=new homeView(u);
			}
		});
		btnRegisterMe.setBounds(151, 157, 153, 25);
		frame.getContentPane().add(btnRegisterMe);
		frame.setVisible(true);
	}

}
