package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class SignUpView {

	private JFrame frmLetschat;
	private JTextField textField;
	User u=new User();
	private JPasswordField passwordField;

	/**
	 * Create the application.
	 */
	public SignUpView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * prompts for username and password from the user
	 * passes the values to the controller.
	 * if the credentials are valid then redirect the user to their homepage
	 */
	private void initialize() {
		frmLetschat = new JFrame();
		frmLetschat.setTitle("LetsChat");
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		lblEnterUsername.setBounds(77, 60, 132, 15);
		frmLetschat.getContentPane().add(lblEnterUsername);
		
		textField = new JTextField();
		textField.setBounds(227, 58, 138, 34);
		frmLetschat.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setBounds(77, 106, 122, 15);
		frmLetschat.getContentPane().add(lblEnterPassword);
		
		JButton btnRegisterMe = new JButton("Register Me");
		btnRegisterMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.setVisible(false);
				try {
					@SuppressWarnings("deprecation")
					RegisterController rc=new RegisterController();
					if(rc.checkIfUnique(textField.getText()))
					{
						rc.addRecord(textField.getText(),passwordField.getText());
						HomeView hv=new HomeView(u);
					}
					else
					{	
						ErrorViewSI ev=new ErrorViewSI();
					}
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRegisterMe.setBounds(151, 185, 153, 44);
		frmLetschat.getContentPane().add(btnRegisterMe);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				RegisterView r=new RegisterView();
			}
		});
		btnBack.setBounds(151, 254, 153, 44);
		frmLetschat.getContentPane().add(btnBack);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 104, 138, 34);
		frmLetschat.getContentPane().add(passwordField);
		frmLetschat.setVisible(true);
	}

}
