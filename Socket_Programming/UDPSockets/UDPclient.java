import java.io.*;
import java.net.*;

public class UDPclient {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String Msg;
		String modiMsg;
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		
		DatagramSocket Ucs= new DatagramSocket();
		InetAddress ip = InetAddress.getByName("localhost");
		
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		
		Msg = inFromUser.readLine();
		sendData = Msg.getBytes();
		
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, 9877);
		Ucs.send(sendPacket);
		
		
		DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
		Ucs.receive(receivePacket);
		
		modiMsg = new String(receivePacket.getData());
		System.out.println(modiMsg + '\n');
		Ucs.close();
	}

}
