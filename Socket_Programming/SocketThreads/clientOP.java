import java.net.*;
import java.io.*;
import java.util.Scanner;

public class clientOP {

	public static void main(String[] args) throws Exception{
		
		String Msg;
		String modiMsg;
	
		Socket cs = new Socket("localhost",6969);
		
		Scanner sc =new Scanner(System.in);
		DataInputStream inFromServer = new DataInputStream(cs.getInputStream());
		DataOutputStream outToServer = new DataOutputStream(cs.getOutputStream());
		
		System.out.println("Enter first no.");
		outToServer.writeUTF(sc.nextLine());
        outToServer.flush();
		
		System.out.println("Enter second no.");
		outToServer.writeUTF(sc.nextLine());
        outToServer.flush();

        System.out.println("Enter operation");
        outToServer.writeChar(sc.next().charAt(0));
        outToServer.flush();

		
		modiMsg = inFromServer.readUTF();
		System.out.println(modiMsg + '\n');

	
		outToServer.close();
		cs.close();
	}

}
