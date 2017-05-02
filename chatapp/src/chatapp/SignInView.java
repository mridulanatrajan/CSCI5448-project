package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

public class SignInView {

	private JFrame frmLetschat;
	private JTextField textField;
	User u=new User();
	private JPasswordField passwordField;

	
	public SignInView() {
		initialize();
	}

	/*
	 * initializes the chat sign in window and prompts the user to enter username and password
	 * User also has the option to go back to the previous window
	 */
	private void initialize() {
		frmLetschat = new JFrame();
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setTitle("LetsChat");
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setLayout(null);
		
		JLabel lblEnterUsername = new JLabel("Enter Username");
		lblEnterUsername.setBounds(89, 62, 139, 29);
		frmLetschat.getContentPane().add(lblEnterUsername);
		
		JLabel lblEnterPassword = new JLabel("Enter Password");
		lblEnterPassword.setBounds(89, 115, 112, 15);
		frmLetschat.getContentPane().add(lblEnterPassword);
		
		textField = new JTextField();
		textField.setBounds(227, 62, 169, 29);
		frmLetschat.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnSignIn = new JButton("sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					@SuppressWarnings("deprecation")
					SignInValidate uvc=new SignInValidate(textField.getText(),passwordField.getText(),u);
					if(!uvc.valid){
						frmLetschat.dispose();
						ErrorViewSI ev=new ErrorViewSI();
					}
					else
					{
						frmLetschat.dispose();
						HomeView hv=new HomeView(u);
					}
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
			}
		});
		frmLetschat.setVisible(true);
		btnSignIn.setBounds(167, 192, 117, 47);
		frmLetschat.getContentPane().add(btnSignIn);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				RegisterView rv=new RegisterView();
			}
		});
		btnBack.setBounds(167, 265, 117, 47);
		frmLetschat.getContentPane().add(btnBack);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(227, 113, 169, 29);
		frmLetschat.getContentPane().add(passwordField);
	}
}
