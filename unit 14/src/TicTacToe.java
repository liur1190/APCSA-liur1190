//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class - 
//Lab  -

import java.util.Scanner;
import static java.lang.System.*;

public class TicTacToe
{
	private char[][] mat;

	public TicTacToe()
	{
		mat = new char[0][0];
	}

	public TicTacToe(String game)
	{
		mat = new char[3][3];
		int i = 0;
		for (int j = 0; j < 3; j++)
		{
			for (int k = 0; k < 3; k++)
			{
				mat[j][k] = game.charAt(i);
				i++;
			}
		}
		
	}

	public String getWinner()
	{
		for (int i = 0; i < 3; i++)
		{
			if (mat[i][0] == mat[i][1] && mat[i][1] == mat[i][2])
				return mat[i][0] + " wins horizontally!";
		
			if (mat[0][i] == mat[1][i] && mat[1][i] == mat[2][i])
				return mat[0][i] + " wins vertically!";
			
		}
		
		if (mat[0][0] == mat[1][1] && mat[1][1] == mat[2][2])
			return mat[0][0] + " wins diagonally!";
		
		if (mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0])
			return mat[0][2] + " wins diagonally!";
		
		else
			return "cat's game - no winner!";
	}

	public String toString()
	{
		String output="";
		for (int r = 0; r < mat.length; r++)
		{
			for (int c = 0; c<mat[r].length;c++)
			{
				output += mat[r][c];
			}
			output += "\n";
		}
		output+=getWinner();


		return output+"\n\n";
	}
}