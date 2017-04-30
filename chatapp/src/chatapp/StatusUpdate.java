package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class StatusUpdate {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusUpdate window = new StatusUpdate();
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
	public StatusUpdate() {
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
		
		textField = new JTextField();
		textField.setBounds(45, 63, 343, 99);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnUpdateStatus = new JButton("Update Status");
		btnUpdateStatus.setBounds(153, 187, 122, 25);
		frame.getContentPane().add(btnUpdateStatus);
		
		JLabel lblEnterStatusBelow = new JLabel("Enter Status Below");
		lblEnterStatusBelow.setBounds(160, 25, 135, 25);
		frame.getContentPane().add(lblEnterStatusBelow);
	}
}