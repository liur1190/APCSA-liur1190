//� A+ Computer Science  -  www.apluscompsci.com
//Name - Rachael Liu
//Date - 2/8/18
//Class - P.1
//Lab  - Lab03c

import java.util.Scanner;
import static java.lang.System.*;
import static java.lang.Math.*;

public class Lab03c
{
	public static void main( String[] args )
   {
		Quadratic q1 = new Quadratic();
		q1.setEquation(5, -8, 3);
		q1.calcRoots();
		q1.print();
		
		Quadratic q2 = new Quadratic();
		q2.setEquation(3, 2, -7);
		q2.calcRoots();
		q2.print();
		
		Quadratic q3 = new Quadratic();
		q3.setEquation(9, 6, 1);
		q3.calcRoots();
		q3.print();
   	
   	
		
		
	}
}