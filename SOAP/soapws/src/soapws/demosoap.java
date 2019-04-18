package soapws;

import javax.jws.WebService;

@WebService
public class demosoap {

	public int add(int x, int y)
	{
		return x+y;
	}

}
