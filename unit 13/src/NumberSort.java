//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSort
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 0;
		while (number / 10 != 0)
		{
			number = number / 10;
			count++;
		}
		return count + 1;
		
	}
	
	public static int[] getSortedDigitArray(int number)
	{
		int numDigits = getNumDigits(number);
		int[] sorted = new int[numDigits];
		for (int i = 0; i < numDigits; i++)
		{
			sorted[i] = number % 10;
			number = number / 10;
		}
		
		for (int i = 0; i < numDigits; i++)
		{
			int min = i;
			for (int j = i+1; j < sorted.length; j++)
			{
				if (sorted[j] < sorted[min])
					min = j;
			}
			if (min != i)
			{
				int temp = sorted[min];
				sorted[min] = sorted[i];
				sorted[i] = temp;
			}
		}
		return sorted;
	}
}

