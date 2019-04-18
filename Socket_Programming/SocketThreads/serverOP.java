import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.lang.*;

public class serverOP{

	public static void main(String[] args) throws Exception{
		
		ServerSocket ss = new ServerSocket(6969);
		while(true) {
			
			Socket s = ss.accept();
			System.out.println(s.toString());
			
			DataInputStream inFromClient = new DataInputStream(s.getInputStream());
			DataOutputStream outToClient = new DataOutputStream(s.getOutputStream());
		

			Thread t = new handler(s, inFromClient, outToClient);
			t.start();
		}
	}
}
class handler extends Thread
{
	Socket s = null;
	DataInputStream inFromClient = null;
	DataOutputStream outToClient = null;
	
	
	public handler(Socket s,DataInputStream inFromClient, DataOutputStream outToClient)
	{
		this.s= s;
		this.inFromClient = inFromClient;
		this.outToClient = outToClient;
	}
	public void run() 
	{
		try{
		
			int num1 = Integer.parseInt(inFromClient.readUTF());
			int num2 = Integer.parseInt(inFromClient.readUTF());
			char op = inFromClient.readChar();
			int result;

			switch(op)
			{
				case'+':
				result = num1 + num2;
				break;
				default:
				result = 0;
			}

			//System.out.println(ClientMsg + '\n');

		//	Scanner sc = new Scanner(System.in);
			outToClient.writeUTF(String.valueOf(result));
			//System.out.println(SmodiMsg + '\n');
			
			outToClient.flush();
			outToClient.close();
		
		}
		catch(Exception e)
		{
		
		}
	}
}