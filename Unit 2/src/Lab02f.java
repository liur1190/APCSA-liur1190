//� A+ Computer Science  -  www.apluscompsci.com
//Name - Rachael Liu
//Date - 2/5/18
//Class - p.1
//Lab  - Lab02f

public class Lab02f
{
	public static void main( String[] args )
   {
		//add test cases
		Line l1 = new Line(1, 9, 14, 2);
		l1.setCoordinates(1, 9, 14, 2);
		l1.calculateSlope();
		l1.print();
		
		Line l2 = new Line(1, 7, 18, 3);
		l2.calculateSlope();
		l2.print();
		
		Line l3 = new Line(6, 4, 2, 2);
		l3.calculateSlope();
		l3.print();
		
		Line l4 = new Line(4, 4, 5, 3);
		l4.calculateSlope();
		l4.print();
		
		Line l5 = new Line(1, 1, 2, 9);
		l5.calculateSlope();
		l5.print();
		
		
		
		
		
	}
}