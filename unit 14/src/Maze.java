//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;

public class Maze
{
   private int[][] maze;
   private boolean exitFound;

	public Maze()
	{
		maze = new int[0][0];
	}

	public Maze(int size, String line)
	{
		String[] array = line.split(" ");
		int[] x = new int[array.length];
		exitFound = false;
		for (int i = 0; i < array.length; i++)
		{
			x[i] = Integer.parseInt(array[i]);
		}
		maze = new int[size][size];
		int i = 0;
		for (int j = 0; j < size; j++)
		{
			for (int k = 0; k <size; k++)
			{
				maze[j][k] = x[i];
				i++;
			}
		}
		
	}

	public void hasExitPath(int r, int c)
	{
		if (r <maze.length && r >=0 && c < maze[0].length && c>= 0 && maze[r][c] == 1)
		{
			if (c == maze.length - 1)
				exitFound = true;
			else
			{
				int save = maze[r][c];
				maze[r][c] = 0;
				hasExitPath(r-1,c);
				hasExitPath(r,c-1);
				hasExitPath(r+1,c);
				hasExitPath(r,c+1);
				maze[r][c] = save;
			}
			
		}
	}

	public String toString()
	{
		String output="";
		for (int r = 0; r < maze.length; r++)
		{
			for (int c = 0; c<maze[0].length;c++)
			{
				output += maze[r][c] + " ";
			}
			output += "\n";
		}
		if (exitFound)
			output += "exit found";
		else
			output+= "exit not found";
		return output;
	}
}