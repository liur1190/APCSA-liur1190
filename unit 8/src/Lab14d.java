//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.lang.System;

public class Lab14d
{
	public static void main( String args[] )
	{
		//add test cases
		Grades player = new Grades();
		double [] test = new double[] {100.0, 90.0, 85.0, 72.5, 95.6};
		player.setGrades(test);
		player.getSum();
		player.getAverage();
		System.out.println(player);
		
		double [] quiz = new double[] {50.0, 100.0, 80.0};
		player.setGrades(quiz);
		player.getSum();
		player.getAverage();
		System.out.println(player);
		
		double [] quiz2 = new double[] {93.4, -90.0, 90.0};
		player.setGrades(quiz2);
		player.getSum();
		player.getAverage();
		System.out.println(player);
		
		double [] Final = new double[] {1.00, 2.00, 3.00, 4.00, 5.00, 6.00, 7.00, 8.00, 9.00};
		player.setGrades(Final);
		player.getSum();
		player.getAverage();
		System.out.println(player);
	}
}