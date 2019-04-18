import java.rmi.*; 

public class Client
{
	public static void main(String args[]) throws Exception
	{
		String Serverurl="rmi://"+args[0] +"/Server";
		AdderI obj = (AdderI)Naming.lookup(Serverurl);
		int n = obj.add(4,5);
		System.out.println("addition is " + n);
	}
}