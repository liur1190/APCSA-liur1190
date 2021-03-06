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

public class MadLib
{
	private ArrayList<String> verbs;
	private ArrayList<String> nouns;
	private ArrayList<String> adjectives;
	
	public MadLib()
	{
		verbs = new ArrayList<String>();
		nouns = new ArrayList<String>();
		adjectives = new ArrayList<String>();
		

	}

	public MadLib(String fileName)
	{
		//load stuff
		this();
		loadNouns();
		loadVerbs();
		loadAdjectives();
		

		try{
			Scanner file = new Scanner(new File(fileName));
			while (file.hasNext())
			{
				String symbol = file.next();
				if(symbol.equals("#"))
				{
					out.print(getRandomNoun() + " ");
				}
				else if(symbol.equals("@"))
				{
					out.print(getRandomVerb() + " ");
				}
				else if(symbol.equals("&"))
				{
					out.print(getRandomAdjective() + " ");
				}
				else
				{
					out.print(symbol + " ");
				}
			}
			file.close();

		}
		catch(Exception e)
		{
			out.println("Houston 1 we have a problem!");
		}
		
	}

	public void loadNouns()
	{
		try{
			Scanner file = new Scanner(new File("H:\\APCS\\APCSA-liur1190\\unit 10\\src\\nouns.dat"));
			while (file.hasNextLine()){
				nouns.add(file.nextLine());
			}
		file.close();
		
		}
		catch(Exception e)
		{
			out.println("Houston 2 we have a problem!");
		}	
		
	}
	
	public void loadVerbs()
	{
		try{
			Scanner file = new Scanner(new File("H:\\APCS\\APCSA-liur1190\\unit 10\\src\\verbs.dat"));
			while (file.hasNextLine()) {
				verbs.add(file.nextLine());
			}
		file.close();

		}
		catch(Exception e)
		{
			out.println("Houston3  we have a problem!");
		}
	}

	public void loadAdjectives()
	{
		try{
			Scanner file = new Scanner(new File("H:\\APCS\\APCSA-liur1190\\unit 10\\src\\adjectives.dat"));
			while (file.hasNextLine()) {
				adjectives.add(file.nextLine());
			}
		file.close();

		}
		catch(Exception e)
		{
			out.println("Houston 4 we have a problem!");
		}
		
	}

	public String getRandomVerb()
	{
		
		return (String)verbs.get((int)(Math.random()*verbs.size()));
	}
	
	public String getRandomNoun()
	{
		
		return (String)nouns.get((int)(Math.random()*nouns.size()));
	}
	
	public String getRandomAdjective()
	{
		
		return (String)adjectives.get((int)(Math.random()*adjectives.size()));
	}		

	public String toString()
	{
		/**String output = "";
		Scanner file = new Scanner(System.in);
		while (file.hasNext())
		{
		   String next = file.next();
		   if (next.equals("#"))
			   if (file.hasNext())
				   output += getRandomNoun() + " ";
			   else
				   output += getRandomNoun() + ".";
		   else if (next.equals("@"))
			   if (file.hasNext())
				   output += getRandomVerb() + " ";
			   else 
				   output += getRandomVerb() + ".";
		   else if (next.equals("&"))
			   if (file.hasNext())
				   output += getRandomAdjective() + " ";
			   else 
				   output += getRandomAdjective() + ".";
		   else
			   if (file.hasNext())
				   output += next + " ";
			   else 
				   output += next + ".";
		   
		   
	   }
		file.close();
		return output;**/
		return "\n\n\n";
	}
}