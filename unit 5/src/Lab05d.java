//� A+ Computer Science  -  www.apluscompsci.com
//Name - Rachael Liu
//Date - 2/9/18
//Class - P.1
//Lab  - Lab05d

import static java.lang.System.*;
import java.util.Scanner;

public class Lab05d
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		
		out.print("Enter a letter :: ");
		char letter = keyboard.next().charAt(0);
		CharacterAnalyzer test = new CharacterAnalyzer(letter);
		//out.println(test);   //A
		test.setChar(letter);
		test.getASCII();
		System.out.println(test + "\n");

		//add more test cases
		letter = keyboard.next().charAt(0);
		test.setChar(letter);
		test.getASCII();
		System.out.println(test + "\n");
		
		letter = keyboard.next().charAt(0);
		test.setChar(letter);
		test.getASCII();
		System.out.println(test + "\n");
		
		letter = keyboard.next().charAt(0);
		test.setChar(letter);
		test.getASCII();
		System.out.println(test + "\n");
		
		letter = keyboard.next().charAt(0);
		test.setChar(letter);
		test.getASCII();
		System.out.println(test + "\n");
		
		letter = keyboard.next().charAt(0);
		test.setChar(letter);
		test.getASCII();
		System.out.println(test + "\n");
		
		letter = keyboard.next().charAt(0);
		test.setChar(letter);
		test.getASCII();
		System.out.println(test + "\n");
		
		letter = keyboard.next().charAt(0);
		test.setChar(letter);
		test.getASCII();
		System.out.println(test + "\n");
		
		letter = keyboard.next().charAt(0);
		test.setChar(letter);
		test.getASCII();
		System.out.println(test + "\n");
		
		
		
		
		
		
		

	}
}