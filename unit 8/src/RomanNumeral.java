//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class RomanNumeral
{
	private Integer number;
	private String roman;

	private final static int[] NUMBERS= {1000,900,500,400,100,90,
													50,40,10,9,5,4,1};

	private final static String[] LETTERS = {"M","CM","D","CD","C","XC",
												  "L","XL","X","IX","V","IV","I"};

	public RomanNumeral(String str)
	{
		number = 0;
		roman = str;
	}

	public RomanNumeral(Integer orig)
	{
		number = orig;
		roman = "";
	}

	public void setNumber(Integer num)
	{
		number = num;
	}

	public void setRoman(String rom)
	{
		roman = rom;
	}

	/**public Integer getNumber()
	{
		for (int i = 0; i < roman.length(); i++)
		{
			for (int j = 0; j < LETTERS.length; j++)
			{
				if (Character.toString(roman.charAt(i)) == LETTERS[j])
				{
					number += NUMBERS[j];
				}
					
			}
		}
		
		
		return number;
	}
	
	 public int getNumber() {
	     number = 0;   
		 if (roman.startsWith("M")) 
	        	roman = roman.substring(1);
	        	number += 1000;
	        if (roman.startsWith("CM")) 
	        	roman = roman.substring(1);
	        	number += 900;
	        if (roman.startsWith("D"))
	        	roman = roman.substring(1);
	        	number += 500;
	        if (roman.startsWith("CD"))
	        	roman = roman.substring(2);
	        	number += 400;
	        if (roman.startsWith("C"))
	        	roman = roman.substring(1);
	        	number += 100;
	        if (roman.startsWith("XC"))
	        	roman = roman.substring(2);
	        	number += 90;
	        if (roman.startsWith("L"))
	        	roman = roman.substring(1);
	        	number += 50;
	        if (roman.startsWith("XL"))
	        	roman = roman.substring(2);
	        	number += 40;
	        if (roman.startsWith("X"))
	        	roman = roman.substring(1);
	        	number += 10;
	        if (roman.startsWith("IX"))
	        	roman = roman.substring(2);
	        	number += 9;
	        if (roman.startsWith("V"))
	        	roman = roman.substring(1);
	        	number +=5;
	        if (roman.startsWith("IV"))
	        	roman = roman.substring(2);
	        	number +=4;
	        if (roman.startsWith("I"))
	        	roman = roman.substring(1);
	        	number +=1;
	        return number;
	    }**/
	
	public int getNumber()
	{
		String modified = roman;
		String firstTwo = modified.substring(0,2);
		String first = modified.substring(0,1);
		int total = 0;
		for (int i = 0; i<LETTERS.length; i++)
		{
			if (firstTwo.equals(LETTERS[i]))
			{
				modified = modified.substring(2);
				total += NUMBERS[i];
				i = -1;
				if (modified.length() >= 2)
					firstTwo = modified.substring(0,2);
				if (modified.length() >= 1)
					first = modified.substring(0,1);
			}
			else if (first.contentEquals(LETTERS[i]))
			{
				modified = modified.substring(1);
				total+=NUMBERS[i];
				i = -1;
				if (modified.length() >= 2)
					firstTwo = modified.substring(0,2);
				if (modified.length() >= 1)
					first = modified.substring(0,1);
			}
			else if (modified.isEmpty() == true)
				return total;
			

		}
		
		return number;
	}
	
	public String getRoman()
	{		
		String s = "";
		for (int i = 0; i < NUMBERS.length; i++)
		{
			while (number >= NUMBERS[i])
			{
				s+=LETTERS[i];
				number -= NUMBERS[i];
			}
		}
		
		return s;
	}

	public String toString()
	{
		return getRoman() + "\n";
	}
}