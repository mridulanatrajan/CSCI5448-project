package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.UIManager;

public class RegisterView {

	private JFrame frmLetschat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView window = new RegisterView();
					window.frmLetschat.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RegisterView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * provides two options to the user-Sign in and Sign Up
	 */
	private void initialize() {
		frmLetschat = new JFrame();
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setForeground(Color.BLACK);
		frmLetschat.setTitle("LetsChat");
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setLayout(null);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.setVisible(false);
				SignInView si=new SignInView();
			}
		});
		btnSignIn.setBounds(166, 83, 143, 55);
		frmLetschat.getContentPane().add(btnSignIn);
		
		JButton btnS = new JButton("Sign Up");
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLetschat.setVisible(false);
				SignUpView sv=new SignUpView();
			}
		});
		btnS.setBounds(166, 170, 143, 55);
		frmLetschat.getContentPane().add(btnS);
		frmLetschat.setVisible(true);
	}

}
