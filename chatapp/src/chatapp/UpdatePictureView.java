package chatapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class UpdatePictureView {

	private JFrame frmLetschat;
	private JFileChooser choose;
    ImageIcon icon;
    PrflMgmtController pmv;
    String path;
    File file;

	public UpdatePictureView() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		pmv=new PrflMgmtController();
		frmLetschat = new JFrame();
		frmLetschat.setTitle("LetsChat");
		JLabel lblBrowsePicture = new JLabel("Browse Picture to update your Picture...");
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.getContentPane().setLayout(null);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				choose=new JFileChooser();
				choose.showOpenDialog(null);
				file = choose.getSelectedFile();
				path=file.getAbsolutePath();
				icon = new ImageIcon(path);
				lblBrowsePicture.setHorizontalAlignment(JLabel.CENTER);
				lblBrowsePicture.setVerticalAlignment(JLabel.CENTER);
				lblBrowsePicture.setIcon(icon);
				lblBrowsePicture.setText("");
			}
		});
		btnBrowse.setBounds(151, 187, 172, 51);
		frmLetschat.getContentPane().add(btnBrowse);
		
		lblBrowsePicture.setBounds(93, 12, 294, 149);
		frmLetschat.getContentPane().add(lblBrowsePicture);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pmv.updatePicture(file);
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
			}
			
		});
		btnSubmit.setBounds(69, 263, 143, 51);
		frmLetschat.getContentPane().add(btnSubmit);
		
		JButton btnBack = new JButton("back");
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
		btnBack.setBounds(261, 263, 143, 51);
		frmLetschat.getContentPane().add(btnBack);
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.setVisible(true);
	}

}
