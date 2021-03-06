import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;


import javax.imageio.ImageIO;

public class DarthVader extends MovingThing
{
	private int speed;
	private Image image;
	private Graphics window;
	
	public DarthVader()
	{
		super(0,0,30,30);
		setSpeed(0);
	}
	
	public DarthVader(int x, int y, int w, int h, int s)
	{
		super(x, y, w,h);
		setSpeed(s);
		try
		{
			image = ImageIO.read(new File("H:\\APCS\\APCSA-liur1190\\unit 17 (new version)\\src\\vader.jpg"));
		}
		catch(Exception e)
		{
			//feel free to do something here
			System.out.println("Houston, we have a problem.");
		}
	}

	@Override
	public void setSpeed(int s) {
		// TODO Auto-generated method stub
		speed = s;
		
	}

	@Override
	public int getSpeed() {
		// TODO Auto-generated method stub
		return speed;
	}

	@Override
	public void move(String direction) {
		// TODO Auto-generated method stub
		
	    setX((int)(Math.random()*700));
	    setY((int)(Math.random()*400));
	    
	}
	
	public boolean touchingShip(Graphics window, Ship ship)
	{
		boolean touching = false;
		if ( ((ship.getX() >= this.getX() && ship.getX() <= this.getX()+45)
					|| (ship.getX()+50 >= this.getX() && ship.getX()+50 <= this.getX()+45))
					&& ((ship.getY()+55 >= this.getY() && ship.getY()+55 <= this.getY()+50)
					|| (this.getY() <= ship.getY() && ship.getY() <= this.getY()+50)) )
			{
				touching = true;
			}
		
		return touching;
	}

	@Override
	public void draw(Graphics window) {
		// TODO Auto-generated method stub
		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
		
	}
	
	public String toString()
	{
		return "";
	}

}
