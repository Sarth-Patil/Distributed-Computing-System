import java.io.*;
import java.net.*;

public class UDPserver {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String ClientMsg;
		String SmodiMsg;
		
		
		DatagramSocket Uss= new DatagramSocket(9877);
	
		
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		
		while(true) {
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			Uss.receive(receivePacket);
			
			ClientMsg = new String(receivePacket.getData());
			System.out.println("Received "+ClientMsg + '\n');
			
			InetAddress IPAddress = receivePacket.getAddress();
			int port = receivePacket.getPort();
			
			SmodiMsg = ClientMsg.toUpperCase()+ '\n';
			sendData = SmodiMsg.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData,
			sendData.length, IPAddress, port);
			Uss.send(sendPacket);
			System.out.println(SmodiMsg + '\n');
			}

		}
	}
