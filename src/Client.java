import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client {
	
	 BufferedReader in;
	    PrintWriter out;
	    JFrame frame = new JFrame("LetsChat");
	    JTextField textField = new JTextField(40);
	    JTextArea messageArea = new JTextArea(40, 40);
	    JButton newUser=new JButton("New User");
	    JButton existingUser=new JButton("Existing User");
	    
	    
	 public Client() {

	        
	        frame.getContentPane().add(newUser);
	        frame.getContentPane().add(existingUser);
	        frame.pack();
	        textField.addActionListener(new ActionListener() {
	            
	            public void actionPerformed(ActionEvent e) {
	                out.println(textField.getText());
	                textField.setText("");
	            }
	        });
	    }
	
	 private void run() throws IOException {

	        
	        Socket socket = new Socket("127.0.0.1", 9001);
	        in = new BufferedReader(new InputStreamReader(
	            socket.getInputStream()));
	        out = new PrintWriter(socket.getOutputStream(), true);
	        
	 }
	public static void main(String args[]) throws IOException{
		
		
		Client client = new Client();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.run();
		
		
	}

}
