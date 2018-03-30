//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date -
//Class -
//Lab  -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable
{
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block()
	{
		xPos = 0;
		yPos = 0;
		width = 0;
		height = 0;
		color = new Color(0);
	}
	//add other Block constructors - x , y , width, height, color
	public Block(int x)
	{
		setX(x);
		yPos = 0;
		width = 0;
		height = 0;
		color = new Color(0);
	}
	
	public Block(int x, int y)
	{
		setX(x);
		setY(y);
		width = 0;
		height = 0;
		color = new Color(0);
	}
	
	public Block(int x, int y, int wid)
	{
		setX(x);
		setY(y);
		setWidth(wid);
		height = 0;
		color = new Color(0);
	}
	
	public Block(int x, int y, int wid, int ht)
	{
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		color = new Color(0);
	}
	
	public Block(int x, int y, int wid, int ht, Color col)
	{
		setX(x);
		setY(y);
		setWidth(wid);
		setHeight(ht);
		setColor(col);
	}
	
   //add the other set methods
  
	@Override
	public void setPos(int x, int y) {
		setX(x);
		setY(y);
	}

	@Override
	public void setX(int x) {
		xPos = x;
	}

	@Override
	public void setY(int y) {
		yPos = y;
	}
	public void setWidth(int wid)
   {
	   width = wid;
   }
   
   public void setHeight(int ht)
   {
	   height = ht;
   }
	
   public void setColor(Color col)
   {
	   color = col;
   }

   public void draw(Graphics window)
   {
   	//uncomment after you write the set and get methods
      window.setColor(color);
      window.fillRect(getX(), getY(), getWidth(), getHeight());
   }

   public void draw(Graphics window, Color col)
   {
	   window.setColor(col);
	   window.fillRect(getX(), getY(), getWidth(), getHeight());
   }
   
	public boolean equals(Object obj)
	{
		Block other = (Block)obj;
		if (getX() == other.getX() && getY() == other.getY() && getWidth() == other.getWidth() 
						&& getHeight() == other.getHeight() && getColor() == other.getColor())
			return true;
		else
			return false;
	}   

   //add the other get methods
	public int getX()
	{
		return xPos;
	}
	
	public int getY()
	{
		return yPos;
	}
    
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public Color getColor()
	{
		return color;
	}

   //add a toString() method  - x , y , width, height, color
	public String toString()
	{
		String output = " ";
		output += getX() + " " + getY() + " " + getWidth() + " " + getHeight() + " " + getColor();
		
		return output;
	}


}