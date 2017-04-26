package chatapp;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    
	 BufferedReader in;
	 PrintWriter out;
    
 public Client() {

        
        Messages m=new Messages();
    }

 private void run() throws IOException {

        
        Socket socket = new Socket("127.0.0.1", 9001);
        in = new BufferedReader(new InputStreamReader(
            socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        
 }
public static void main(String args[]) throws IOException{
	Client client = new Client();
    client.run();
	
}


}
