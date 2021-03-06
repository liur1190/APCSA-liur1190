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
			count.add(0);
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
		/**try{
			Scanner file = new Scanner(new File(fileName));
			for (int i = 0; i < letters.size(); i++)
			{
				while (file.hasNext())
				{
					char symbol = file.next().charAt(i);
					out.print(symbol);

					if (Character.toString(symbol).equals(letters.get(i)))
					{
						out.print(symbol);
						count.set(i,  count.get(i) + 1);

					}
					symbol = file.next();
				}
			}
			file.close();
		}**/
		
		/**try{
			Scanner file = new Scanner(new File(fileName));
			int fileSize = file.nextInt();
			for (int i = 0; i < fileSize; i++)
			{
				String sentence = file.nextLine();
				out.println(sentence);
				for (int j = 0; j < letters.size(); j++)
					{
						for (int k = 0; k < sentence.length(); k++)
						{
							if (letters.get(j) == sentence.charAt(k))
								out.print(sentence.charAt(k));
								count.set(j, count.get(j) + 1);
						}
					}
						
							//still having issues with this stupid thing, for whatever reason the program won't go into the if statement

			}
		}**/
		
		try{
			Scanner file = new Scanner(new File(fileName));
			String text = "";
			while(file.hasNext())
			{
				text += file.nextLine() + "\n";
			}
			for (int i = 0; i < text.length(); i++)
			{
				char symbol = text.charAt(i);
				int index = letters.indexOf(symbol);
				if (index != -1)
				{
					count.set(index, count.get(index) +1);
				}
			}
		
		}
		catch(Exception e)
		{
			out.println("Houston we have a problem!");
		}

	}

	public char mostFrequent()
	{
		int max = Integer.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < letters.size(); i++)
		{
			int value = count.get(i);
			if (value > max)
			{
				max = value;
				index = i;
			}
		}
		return letters.get(index);
		
	}

	public char leastFrequent()
	{
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < letters.size(); i++)
		{
			int value = count.get(i);
			if (value < min)
			{
				min = value;
				index = i;
			}
		}
		return letters.get(index);


	}

	public String toString()
	{
	   return fileName
	   + "\n" + letters
	   + "\n" + count + "\n\n\n";
	}
}