import java.net.*;
import java.io.*;

public class client {

	public static void main(String[] args) throws Exception{
		
		String Msg;
		String modiMsg;
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket cs = new Socket("localhost",5998);
		
		DataOutputStream outToServer = new DataOutputStream(cs.getOutputStream());
		
		
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(cs.getInputStream()));
		
		Msg = inFromUser.readLine();
		outToServer.writeBytes(Msg + '\n');
		
		modiMsg = inFromServer.readLine();
		System.out.println(modiMsg + '\n');

		outToServer.flush();
		outToServer.close();
		cs.close();
	}

}
