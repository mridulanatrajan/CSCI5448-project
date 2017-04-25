package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class registerView {

	private JFrame frmLetschat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registerView window = new registerView();
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
	public registerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLetschat = new JFrame();
		frmLetschat.setForeground(Color.BLACK);
		frmLetschat.setTitle("LetsChat");
		frmLetschat.setBounds(100, 100, 450, 300);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setLayout(null);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.setVisible(false);
				homeView hv=new homeView();
			}
		});
		btnSignIn.setBounds(152, 83, 117, 25);
		frmLetschat.getContentPane().add(btnSignIn);
		
		JButton btnS = new JButton("Sign Up");
		btnS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLetschat.setVisible(false);
				signUpView sv=new signUpView();
			}
		});
		btnS.setBounds(152, 120, 117, 25);
		frmLetschat.getContentPane().add(btnS);
		frmLetschat.setVisible(true);
	}

}
