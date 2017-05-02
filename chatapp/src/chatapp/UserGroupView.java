package chatapp;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingWorker;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class UserGroupView {

	private JFrame frame;
	GroupMgmtController gm;
	ResultSet rs;
	HashSet<String> hs=new HashSet<String>();

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		DefaultListModel<String> listModel = new DefaultListModel<>();
		@SuppressWarnings("unchecked")
		JList<String> list = new JList<String>(listModel);
		
		list.setBounds(25, 40, 260, 174);
		rs=gm.getGroups();
		while(rs.next())
		{
			listModel.addElement(rs.getString("groupname"));
		}
		frame.getContentPane().add(list);
		
		
		JButton btnStart = new JButton("Start Chat");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String grp=(String) list.getSelectedValue();
				Group.setGroupname(grp);
				try {
					rs=gm.retreiveGroupMembers();
					while(rs.next())
					{
						hs.add(rs.getString("username"));
						System.out.println(rs.getString("username"));
					}
					Group.setGroupmembers(hs);
					frame.dispose();
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
		btnStart.setBounds(297, 56, 114, 55);
		frame.getContentPane().add(btnStart);
		
		JButton btnDeleteGroup = new JButton("Delete Group");
		btnDeleteGroup.setBounds(297, 147, 128, 55);
		frame.getContentPane().add(btnDeleteGroup);
		frame.setVisible(true);
	}

}
