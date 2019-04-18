import java.rmi.*;

public interface AdderI extends Remote
{
	public int add(int x, int y) throws Exception;
}