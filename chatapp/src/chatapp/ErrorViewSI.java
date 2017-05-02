package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ErrorViewSI {

	private JFrame frmLetschat;

	
	public ErrorViewSI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * This is triggered when the when the username and password do not exist in the user databse
	 */
	private void initialize() {
		frmLetschat = new JFrame();
		frmLetschat.setTitle("LetsChat");
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ERROR: Invalid Credentials");
		lblNewLabel.setBounds(126, 72, 236, 74);
		frmLetschat.getContentPane().add(lblNewLabel);
		
		JButton btnStartOver = new JButton("start over");
		btnStartOver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmLetschat.dispose();
				RegisterView rv=new RegisterView();
			}
		});
		btnStartOver.setBounds(159, 158, 117, 44);
		frmLetschat.getContentPane().add(btnStartOver);
		frmLetschat.setVisible(true);
	}

}
