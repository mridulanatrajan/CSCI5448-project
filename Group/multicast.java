package chatapp;
import java.io.IOException;


import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class multicast extends group
						{
	                        JFrame frame = new JFrame("Group Message");
	                        JButton SendMessage = new JButton("Send");
	                        JLabel message = new JLabel("Enter Message to be sent");
	                        JTextField msg = new JTextField();
	                        DatagramPacket msgin;
	                        
	                        public static Object m1;
							final static String INET_ADDR = "224.0.0.1";
						    final static int PORT = 8081;
                            public void SetMessage(String i){
                              String  msgin = i;	
                            }
                            
						    public void Group() throws UnknownHostException {
						    	InetAddress address = InetAddress.getByName(INET_ADDR);
                                byte[] buf = new byte[1024];
                                try{
                                   MulticastSocket clientSocket = new MulticastSocket(PORT);
						           clientSocket.joinGroup(address);
                                   while (true) {
                                	    frame.setSize(700, 700);
                                	    SendMessage.addActionListener(new ActionListener(){
                                            public void actionPerformed(ActionEvent e) {
                                            	
                                        SetMessage(msg.getText());
                                        
                                	    
						                DatagramPacket msgin = new DatagramPacket(buf, buf.length, address, 8080);
						                try {
						                	clientSocket.send(msgin);
											clientSocket.receive(msgin);
										} catch (IOException e1) {
											
											e1.printStackTrace();
										}

						                /*String msg = new String(buf, 0, buf.length);*/
						                
						                System.out.println("Socket 1 received msg: " + msgin);
                                            }
                                	    });
						            }
						        } catch (IOException e) {
						            e.printStackTrace();
						        }
						    }
						}