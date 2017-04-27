package DBDemo;
import java.io.*;
import java.net.*;
import java.util.*;


public class GroupServer implements Runnable{
	Socket sc;
	static HashMap<Integer,Socket> hm = new HashMap<Integer,Socket>();
	static int i = 1;
	GroupServer(Socket sc){
		this.sc = sc;
	}
	
	public static void main(String args[]) throws Exception{
		ServerSocket ss = new ServerSocket(5000);
		System.out.println("Listening to the client");
		while(true){
			Socket s = ss.accept();
			GroupServer ser = new GroupServer(s);
			new Thread(ser).start();
			hm.put(i,s);
			System.out.println("Connection established to client"+i);
			i++;
			
		}
		
	}
	
	public void run() {
		
		try{
			PrintWriter out;
			BufferedReader in = new BufferedReader(new InputStreamReader(sc.getInputStream()));
			String inputLine;
			String j = "sendmsg";
			String l = "to";
			String a = "sendtoall";
			while((inputLine = in.readLine())!= null){
				String t[] =inputLine.split(" ");
				if(t[0].equals(j) && t[2].equals(l)){
					int id = Integer.parseInt(t[3]);
					if(hm.containsKey(id)){
						Socket ser1 = hm.get(id);
						out = new PrintWriter(ser1.getOutputStream(),true);
						out.println(t[1]);
						out.flush();
						
					}
					else{
						out = new PrintWriter(sc.getOutputStream(),true);
						out.println("Unable to reach the user: User Offline");
						out.flush();
						}
				}
				else if (t[0].equals(a)){
					for(int k=1; k<=hm.size();k++)
					{
						Socket ser1 = hm.get(k);
						out = new PrintWriter(ser1.getOutputStream(),true);
						out.println(t[1]);
						out.flush();
						
					}
				}
				else{
					out = new PrintWriter(sc.getOutputStream(),true);
					out.println("Failed");
					out.flush();
					
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
