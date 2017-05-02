package chatapp;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class GroupClient implements ChatObserver{

	 BufferedReader in;
	    PrintWriter out;
	    JFrame frmLetschat = new JFrame("Chatter");
	    JTextField textField = new JTextField();
	    JTextArea messageArea = new JTextArea();
		JButton btnNewButton = new JButton("Send");
	    private final JButton btnBack = new JButton("Back");

	
    public GroupClient(){
    	frmLetschat.setTitle("LetsChat");
    	frmLetschat.getContentPane().setBackground(UIManager.getColor("OptionPane.questionDialog.titlePane.background"));
    	frmLetschat.setBackground(UIManager.getColor("Button.background"));
    	frmLetschat.setBounds(100, 100, 483, 415);
		textField.setBounds(12, 264, 296, 90);
        messageArea.setBounds(12, 12, 425, 240);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		out.println(textField.getText());
                textField.setText("");
        	}
        });
        frmLetschat.getContentPane().setLayout(null);
        frmLetschat.getContentPane().add(textField);
        frmLetschat.getContentPane().add(messageArea);
        frmLetschat.getContentPane().add(btnNewButton);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLetschat.dispose();
				GrpMgmtView gv=new GrpMgmtView();
			}
		});
		frmLetschat.getContentPane().add(btnBack);
        textField.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });
        btnNewButton.setBounds(320, 264, 117, 38);
        btnBack.setBounds(320, 310, 117, 44);
        frmLetschat.setTitle("LetsChat");
        frmLetschat.setVisible(true);
    }
    
    public void update(String msg)
    {
    	messageArea.append(msg.substring(4)+"\n");
    }

    public void run() throws IOException {

        Socket socket = new Socket("127.0.0.1", 1991);
        in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        while (true) {
            String line = in.readLine();
            if(line.startsWith("mode"))
            {
            	out.println("group");
            }
            else if (line.startsWith("name")) {
                out.println(User.getUsername());
            }
            else if (line.startsWith("group"))
            {
            	out.println(Group.getGroupname());
            }
            else if (line.startsWith("msg ")) {
            	update(line);
                //messageArea.append(line.substring(4) + "\n");
            }
        }

		
	}
}


/*
*This code was referenced from http://cs.lmu.edu/~ray/notes/javanetexamples/
*
*The methods were modifed in order to implement the observer design pattern and incorporate broadcast/group messaging.
*
*Methods incorporated and modified:
*1) run
*
*Methods added:
*1) update
*
*/

