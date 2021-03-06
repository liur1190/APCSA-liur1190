//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;
import static java.util.Arrays.*;

public class Grades
{
	//private double[] grades;
	private ArrayList<Double> grades;
	
	public Grades()
	{
		setGrades("");
	}
	
	public Grades(String gradeList)
	{
		setGrades(gradeList);		
	}
	
	public void setGrades(String gradeList)
	{
		int size = Integer.parseInt(gradeList.substring(0, 1));
		grades = new ArrayList<Double>();
		int index = gradeList.indexOf("-");
		for (int i = 0; i < size; i++)
		{
			int start = gradeList.indexOf(" ", index + 1);
			index = start + 1;
			int end = gradeList.indexOf(" ", index);
			if (end == -1)
			{
				grades.add(Double.parseDouble(gradeList.substring(start)));
			}
			else
				grades.add(Double.parseDouble(gradeList.substring(start, end)));
		}

	}
	
	public void setGrade(int spot, double grade)
	{
		grades.set(spot, grade);

	}
	
	public double getSum()
	{
		double sum=0.0;
		for (int i = 0; i < grades.size(); i++)
			sum+=grades.get(i);

		return sum;
	}
	
	public double getLowGrade()
	{
		double low = Double.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < grades.size(); i++)
		{
			double value = grades.get(i);
			if (value < low)
			{
				low = value;
				index = i;
			}
		}
		return low;

	}
	
	public double getHighGrade()
	{
		double high = Double.MIN_VALUE;
		int index = -1;
		for (int i = 0; i < grades.size(); i++)
		{
			double value = grades.get(i);
			if (value > high)
			{
				high = value;
				index = i;
			}
		}
		return high;

	}
	
	public int getNumGrades()
	{
		return grades.size();
	}
	
	public String toString()
	{
		String output="";
		output = grades + "\n";

		return output;
	}	
}