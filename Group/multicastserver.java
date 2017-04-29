package chatapp;
import java.net.*;
import java.io.*;

public class multicastserver {
	   final static String INET_ADDR = "224.0.0.1";
	   final static int PORT = 8080;
	   public static void main(String[] args) throws UnknownHostException, InterruptedException {
	          InetAddress addr = InetAddress.getByName(INET_ADDR);
	          
              							try 
              							{
            	  							DatagramSocket serverSocket = new DatagramSocket();							           
							                String msg = "Sent message no ";
							                DatagramPacket packet = new DatagramPacket(msg.getBytes(),
							                msg.getBytes().length, addr, PORT);
							                //DatagramPacket packet = new DatagramPacket()
							                serverSocket.receive(packet);
							                
							                System.out.println("Server received message from client");
							                serverSocket.send(packet);
							                Thread.sleep(500);
							            
							        } catch (IOException e) {
							            e.printStackTrace();
							        }
							    }
							}