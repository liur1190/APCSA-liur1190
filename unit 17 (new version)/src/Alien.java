//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;
	private Graphics window;

	public Alien()
	{
		this(0,0,60,60,0);
	}

	public Alien(int x, int y)
	{
		//add code here
		this(x,y,60,60,0);
	}

	public Alien(int x, int y, int s)
	{
		//add code here
		this(x,y,60,60,s);
	}

	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w,h);
		speed=s;
		try
		{
			image = ImageIO.read(new File("H:\\APCS\\APCSA-liur1190\\unit 17\\src\\alien.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("Houston, we have a problem.");
		}
	}

	public void setSpeed(int s)
	{
	   //add code
		speed = s;
	}

	public int getSpeed()
	{
	   return speed;
	}

   public void move(String direction)
	{
	   //add code here
	   /**while(direction == "RIGHT")
	   {
		   setX(getX()+speed);
		   if(getSpeed()>0 && getX()==800)
		   {
			   setSpeed(getSpeed()*-1);
			   direction = "LEFT";
		   }
	   }
	   while(direction == "LEFT")
	   {
		   setX(getX()+speed);
		   if(getSpeed()<0 && getX()==0)
		   {
			   setSpeed(getSpeed()*-1);
			   direction = "RIGHT";
		   }
	   }**/
	   setX(getX()+getSpeed());
	   if(getX() < 0 || getX()>760)
		   setSpeed(-getSpeed());
	   //4.18.18 having issues with making the aliens move continuously
	   //4.20.18 solved it!
		   
	}
   
   
	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}
	
	public void checkDead (Ammo ammo)
	{
		if(ammo.getX()>=this.getX())
		{
			this.setSpeed(0);
			window.setColor(Color.black);
			ammo.setSpeed(0);
		}
		
	}

	public String toString()
	{
		return "";
	}
}
