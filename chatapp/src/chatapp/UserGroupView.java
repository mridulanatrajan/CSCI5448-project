package chatapp;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingWorker;
import javax.swing.UIManager;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class UserGroupView {

	private JFrame frmLetschat;
	GroupMgmtController gm;
	ResultSet rs;
	HashSet<String> hs=new HashSet<String>();
	String grp;
	int index;
	boolean candelete;
	public UserGroupView() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		gm=new GroupMgmtController();
		frmLetschat = new JFrame();
		frmLetschat.setTitle("LetsChat");
		frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
		frmLetschat.setBackground(UIManager.getColor("Button.background"));
		frmLetschat.setBounds(100, 100, 483, 415);
		frmLetschat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLetschat.getContentPane().setLayout(null);
		DefaultListModel<String> listModel = new DefaultListModel<>();
		@SuppressWarnings("unchecked")
		JList<String> list = new JList<String>(listModel);
		
		list.setBounds(25, 40, 260, 174);
		rs=gm.getGroups();
		while(rs.next())
		{
			listModel.addElement(rs.getString("groupname"));
		}
		frmLetschat.getContentPane().add(list);
		
		
		JButton btnStart = new JButton("Start Chat");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				grp=(String) list.getSelectedValue();
				Group.setGroupname(grp);
				try {
					rs=gm.retreiveGroupMembers();
					while(rs.next())
					{
						hs.add(rs.getString("username"));
						System.out.println(rs.getString("username"));
					}
					Group.setGroupmembers(hs);
					frmLetschat.dispose();
					GroupClient gc=new GroupClient();
					
					 SwingWorker<String, Object> worker = new SwingWorker<String, Object>() {
		    	            @Override
		    	            protected String doInBackground() throws Exception {                
		    	            	try {
		    						gc.run();
		    					} catch (IOException e1) {
		    						e1.printStackTrace();
		    					} 
		    	            	return "hi";
		    	            }
		    	            @Override
		    	            protected void done() {  
		    	            }
		    	        };      
		    	        worker.execute();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		JLabel lblNewLabel = new JLabel("");
		btnStart.setBounds(297, 52, 128, 55);
		frmLetschat.getContentPane().add(btnStart);
		
		JButton btnDeleteGroup = new JButton("Delete Group");
		btnDeleteGroup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = list.getSelectedIndex();
				grp=(String) list.getSelectedValue();
				try {
					candelete=gm.deleteGroup(grp);
					if(!candelete)
						lblNewLabel.setText("ERROR:You are not the admin");
					else
					    listModel.removeElementAt(index);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnDeleteGroup.setBounds(297, 147, 128, 55);
		frmLetschat.getContentPane().add(btnDeleteGroup);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				GrpMgmtView gv=new GrpMgmtView();
			}
		});
		btnBack.setBounds(178, 274, 117, 44);
		frmLetschat.getContentPane().add(btnBack);
		
		lblNewLabel.setBounds(79, 226, 269, 24);
		frmLetschat.getContentPane().add(lblNewLabel);
		frmLetschat.setVisible(true);
	}

}
