package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class ProfileManagement {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileManagement window = new ProfileManagement();
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
	public ProfileManagement() {
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(169, 36, -593, 105);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnChangePicture = new JButton("Change Picture");
		btnChangePicture.setBounds(122, 46, 189, 25);
		frame.getContentPane().add(btnChangePicture);
		
		JButton btnUpdatePicture = new JButton("Update Picture");
		btnUpdatePicture.setBounds(122, 103, 189, 25);
		frame.getContentPane().add(btnUpdatePicture);
		
		JButton btnViewProfile = new JButton("View Profile");
		btnViewProfile.setBounds(122, 162, 189, 25);
		frame.getContentPane().add(btnViewProfile);
	}

}
