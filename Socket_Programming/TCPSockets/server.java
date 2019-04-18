import java.net.*;
import java.io.*;

public class server {

	public static void main(String[] args) throws Exception{
		
		String ClientMsg;
		String SmodiMsg;
		
		ServerSocket ss = new ServerSocket(5998);
		while(true) {
			
			Socket s = ss.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(s.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(s.getOutputStream());
		
			ClientMsg = inFromClient.readLine();
			SmodiMsg = ClientMsg.toUpperCase()+ '\n';
			
			outToClient.writeBytes(SmodiMsg);
			
			System.out.println(SmodiMsg + '\n');
			
			outToClient.flush();
			outToClient.close();
			
		}
		
	}

}
