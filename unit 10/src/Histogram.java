//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class Histogram
{
	private ArrayList<Integer> count;
	private ArrayList<Character> letters;
	private String fileName;

	public Histogram()
	{
		count = new ArrayList<Integer>();
		letters = new ArrayList<Character>();

	}

	public Histogram(char[] values, String fName)
	{
		this();
		fileName = fName;
		for (int i = 0; i < values.length; i++)
		{
			letters.add(values[i]);
		}


		out.println("search letters = "+letters);
	}

	public void loadAndAnalyzeFile() throws IOException
	{
		/**try{
			Scanner file = new Scanner(new File(fileName));
			while (file.hasNext())
			{
				for (int i = 0; i < letters.size(); i++)
					{
						for (int j = 0; j < fileName.length(); j++)
						{
							String symbol = file.next();
							out.print(symbol);
							if (symbol.equals(letters.get(i)))
							{
								count.set(i, count.get(i) + 1);
							}
						}
					}
				
			}
			file.close();
		}**/
		try{
			Scanner file = new Scanner(new File(fileName));
			for (int i = 0; i < letters.size(); i++)
			{
				while (file.hasNext())
				{
					char symbol = file.next().charAt(i);
					out.print(symbol);;
					if (symbol==letters.get(i))
					{
						count.set(i,  count.get(i) + 1);
					}
				}
			}
			file.close();
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}

	}

	public char mostFrequent()
	{
		
		return '#';
	}

	public char leastFrequent()
	{


		return '#';
	}

	public String toString()
	{
	   return fileName
	   + "\n" + letters
	   + "\n" + count + "\n\n\n";
	}
}