//� A+ Computer Science  -  www.apluscompsci.com
//Name - Rachael Liu
//Date - 3/8/18
//Class -P.1
//Lab  - Lab03d

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Lab03d
{
	public static void main( String[] args )
	{
		//add test cases
		
		Distance d1 = new Distance();
		d1.setCoordinates(1, 1, 2, 1);
		d1.calcDistance();
		d1.print();
		
		Distance d2 = new Distance();
		d2.setCoordinates(1, 1, -2, 2);
		d2.calcDistance();
		d2.print();
		
		Distance d3 = new Distance();
		d3.setCoordinates(1, 1, 0, 0);
		d3.calcDistance();
		d3.print();
		
		
			
	}
}