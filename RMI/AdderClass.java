import java.rmi.*; 
import java.rmi.server.*;

public class AdderClass extends UnicastRemoteObject implements AdderI
{
	AdderClass() throws RemoteException
	{ 
		super();
	}
	public int add(int x, int y) 
	{
		return x+y;
	}
}
