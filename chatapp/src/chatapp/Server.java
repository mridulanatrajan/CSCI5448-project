package chatapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;

public class Server extends Thread{

    private String name;
	private Socket sock;
	private BufferedReader in;
    private PrintWriter out;
    private static String mode;
    private String frnd;
    private static String finfrnd="";
    private static HashSet<String>friends=new HashSet<String>();
    private static HashSet<String>names = new HashSet<String>();
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    
    
    public Server(Socket sock)
    {
    	this.sock=sock;
    }
    
    public void peertopeer(BufferedReader inp, PrintWriter outp) throws IOException
    {
    	
    	while (true) {
            outp.println("name");
            name = inp.readLine();
            outp.println("friend");
            frnd=inp.readLine();
            synchronized (names) {
                if (!names.contains(name)) {
                	if(finfrnd.equals(""))
                	{
                		names.add(name);
                		finfrnd=frnd;
                		System.out.println(name+" " +finfrnd);
                		writers.add(out);
                	}
                	else if(finfrnd.equals(name))
                	{
                		names.add(name);
                		System.out.println("there is already a value in finfrnd"+name);
                		writers.add(out);
                	}
                	break;	
                }            
            }
        } while (true) {
            String input = inp.readLine();
            if(names.contains(name))
            {
	            for (PrintWriter writer : writers) {
	                writer.println("msg " + name + ": " + input);
	            }
            }
        }	
    }
    
    public void run(){    	
    	try {
			in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			out = new PrintWriter(sock.getOutputStream(), true);
			
			while(true)
			{
				out.println("mode");
				mode=in.readLine();
				if(mode.equals("p2p"))
				{
					peertopeer(in,out);
				}	
			}
    	} catch (IOException e) {
			e.printStackTrace();
		}      
    }
    	   
    public static void main(String[] args) throws Exception {
    	System.out.println("server started");
        ServerSocket listener = new ServerSocket(1991);
        try {
            while (true) {
                new Server(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }
    
}