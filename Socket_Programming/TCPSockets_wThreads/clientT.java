import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

class clientT
{
	public static void main(String[] args) throws Exception
	{
		Socket soc = new Socket("localhost", 6969);
		DataOutput dos = new DataOutputStream(soc.getOutputStream());
		Scanner sc = new Scanner(System.in);
		dos.writeUTF(sc.nextLine());
		soc.close();
	}
}