//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

class InsertionSort
{
	private ArrayList<String> list;

	public InsertionSort()
	{
		list = new ArrayList<String>();
	}

	//modifiers
	public void add( String  word)
	{
		int loc = Collections.binarySearch(list, word);
		if (loc < 0)
		{
			loc = Math.abs(loc) - 1;
			if (loc > list.size())
				list.add(word);
			else
				list.add(loc, word);
		}
	}

	public void remove(String word)
	{
		list.remove(word);
	}

	public String toString()
	{
		return list.toString();
	}
}