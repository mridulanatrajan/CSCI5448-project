package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GroupCreation {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblChooseMembers;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnAdd;
	private JButton button;
	private JButton button_1;
	private JButton button_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GroupCreation window = new GroupCreation();
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
	public GroupCreation() {
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
		
		JLabel lblEnterNameOf = new JLabel("Enter Name of Group:");
		lblEnterNameOf.setBounds(41, 34, 125, 16);
		frame.getContentPane().add(lblEnterNameOf);
		
		textField = new JTextField();
		textField.setBounds(178, 34, 214, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblChooseMembers = new JLabel("Choose Members:");
		lblChooseMembers.setBounds(100, 76, 104, 16);
		frame.getContentPane().add(lblChooseMembers);
		
		textField_1 = new JTextField();
		textField_1.setBounds(41, 99, 216, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(41, 134, 216, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(41, 169, 216, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(41, 204, 216, 22);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		btnAdd = new JButton("Add");
		btnAdd.setBounds(295, 96, 97, 25);
		frame.getContentPane().add(btnAdd);
		
		button = new JButton("Add");
		button.setBounds(295, 133, 97, 25);
		frame.getContentPane().add(button);
		
		button_1 = new JButton("Add");
		button_1.setBounds(295, 168, 97, 25);
		frame.getContentPane().add(button_1);
		
		button_2 = new JButton("Add");
		button_2.setBounds(295, 203, 97, 25);
		frame.getContentPane().add(button_2);
	}

}
