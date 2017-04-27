package DBDemo;
import java.net.*;
import java.io.*;

public class Group1 implements Runnable{
	
	private static Socket clientSocket = null;
	private static PrintStream os = null;
	private static DataInputStream ds = null;
	private static BufferedReader inputLine =null;
	private static boolean closed = false;
	public static void main (String args[]) throws IOException
	{
		int portNumber = 5000;
		String host = "localhost";
		if(args.length < 2)
		{
			System.out.println("More than two ports are required for multicasting messages");
		}
		else
		{
			host = args[0];
			portNumber = Integer.valueOf(args[1]).intValue();
		}
		try
		{
			clientSocket = new Socket(host,portNumber);
			inputLine = new BufferedReader(new InputStreamReader(System.in));
			os = new PrintStream(clientSocket.getOutputStream());
			ds = new DataInputStream(clientSocket.getInputStream());
		}
		catch(UnknownHostException e){
			e.printStackTrace();
			
		}
		
		if(clientSocket!=null && os!=null && ds!=null){
			try{
				new Thread(new Group1()).start();
				while(!closed){
					os.println(inputLine.readLine());
					
				}
					os.close();
					ds.close();
					clientSocket.close();
					
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		String reply;
		try{
			while((reply = ds.readLine())!= null){
				System.out.println(reply);
			}
			closed = true;
			
			}catch(IOException e){
				e.printStackTrace();
		}
		
		
	}
	

}
