package chatapp;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class Client {

	 BufferedReader in;
	    PrintWriter out;
	    JFrame frame = new JFrame("Chatter");
	    JTextField textField = new JTextField();
	    JTextArea messageArea = new JTextArea();
		JButton btnNewButton = new JButton("Send");
	    User per;
	    String fr;
	
    public Client(User u,String fri) {
    	
    	per=u;
    	fr=fri;
    	frame.setBounds(100, 100, 450, 300);
		textField.setBounds(12, 201, 296, 50);
        messageArea.setBounds(12, 12, 425, 163);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
        		out.println(textField.getText());
                textField.setText("");
        	}
        });
        btnNewButton.setBounds(320, 201, 117, 38);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(textField);
        frame.getContentPane().add(messageArea);
        frame.getContentPane().add(btnNewButton);
		
        textField.addActionListener(new ActionListener() {
          
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });
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
            	out.println("p2p");
            }
            else if (line.startsWith("name")) {
                out.println(per.getUsername());
            }
            else if(line.startsWith("friend"))
            {
            	out.println(fr);
            }
            else if (line.startsWith("msg ")) {
                messageArea.append(line.substring(4) + "\n");
            }
        }

		
	}
}
