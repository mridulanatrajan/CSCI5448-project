package chatapp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ProfileView {

	private JFrame frmLetschat;
	InputStream in;
	Image image;
	PrflMgmtController pmc;

	/**
	 * Create the application.
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public ProfileView() throws IOException, ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws IOException, ClassNotFoundException, SQLException {
		pmc=new PrflMgmtController();
		frmLetschat = new JFrame();
		frmLetschat.setTitle("LetsChat");
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(132, 12, 257, 113);
		in=pmc.getPicture();
	    image = ImageIO.read(in);
	    lblNewLabel.setIcon(new ImageIcon(image));
		frmLetschat.getContentPane().add(lblNewLabel,BorderLayout.CENTER);

		JLabel lblNewLabel_1 = new JLabel(User.getUsername());
		lblNewLabel_1.setBounds(162, 137, 137, 28);
		frmLetschat.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Status:");
		lblNewLabel_2.setBounds(99, 220, 70, 15);
		frmLetschat.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel(pmc.getStatus());
		lblNewLabel_3.setBounds(176, 218, 234, 31);
		frmLetschat.getContentPane().add(lblNewLabel_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				try {
					ProfileManagagementView pmv=new ProfileManagagementView();
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnBack.setBounds(176, 284, 122, 54);
		frmLetschat.getContentPane().add(btnBack);
		frmLetschat.setVisible(true);
	}

	
}
