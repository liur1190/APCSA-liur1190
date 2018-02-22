//� A+ Computer Science  -  www.apluscompsci.com
//Name - Rachael Liu
//Date - 2/20/18
//Class - P.1
//Lab  - Lab10e

import java.util.Scanner;
import static java.lang.System.*;

public class Lab10e
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		char response = 'y';
		
		while (response == 'y')
		{
			System.out.println("Guessing game - how many numbers? ");
			int number = keyboard.nextInt();
			GuessingGame test = new GuessingGame(number);
			test.playGame();
			out.println(test);
			
			System.out.println("Do you want to play again? (y or n)");
			response = keyboard.next().charAt(0);
		}
		
		
	

	}
}