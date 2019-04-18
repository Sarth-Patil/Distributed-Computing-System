import java.net.*;
import java.io.*;
import java.util.Scanner;

public class clientF {

	public static void main(String[] args) throws Exception{
		
		String Msg;
		String modiMsg;
	
		Socket cs = new Socket("localhost",6969);
		
		Scanner sc =new Scanner(System.in);
		DataInputStream inFromServer = new DataInputStream(cs.getInputStream());
		DataOutputStream outToServer = new DataOutputStream(cs.getOutputStream());
		
		outToServer.writeUTF(sc.nextLine());
        outToServer.flush();
		

		
		modiMsg = inFromServer.readUTF();
		System.out.println(modiMsg + '\n');

	
		outToServer.close();
		cs.close();
	}

}
