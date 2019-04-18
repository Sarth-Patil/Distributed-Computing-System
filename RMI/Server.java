import java.rmi.*; 
import java.rmi.registry.*;

public class Server
{
	public static void main(String args[]) throws Exception
	{
		AdderClass obj = new AdderClass();
		Naming.rebind("Server",obj);
		System.out.println("Server Started");
	}
}