import java.util.*;
public class Bully {

	static boolean[] state = new boolean[5];
	static int coordinator;
	
	public static void down(int down)
	{
		state[down-1] = false;
	}
	public static void msg(int msg)
	{
		int i,flag=0;
		if(state[msg-1])
		{
			for(i=0;i<5;i++)
			{
				if(i > (msg-1))
				{
					System.out.println("Msg sent by process "+ msg +" to process " + (i+1));
				}
			}
			for(i=0;i<5;i++)
			{
				if(i > (msg-1))
				{
					if(state[i])
					{
						msg(i+1);
						flag = 1;
						break;
					}
				}
			}
		}
		else
		{
			System.out.println("Process " +msg+" is down");
		}
	}
	public static void main(String[] args) {
		
		int i,ch=0,up,down,msg;
		Bully b = new Bully();
		Scanner sc = new Scanner(System.in);
		
		coordinator = 5;
		for(i=0;i<5;i++)
		{
			state[i]=true;
		}
		System.out.println("Processes are active");
		System.out.println("Process 5 is coordinator ");
		
		System.out.println("Enter Process no. to be down");
		down = sc.nextInt();
		b.down(down);
		System.out.println("Enter Process no. initiate election");
		msg = sc.nextInt();
		b.msg(msg);
		
		sc.close();
		
	}

}
