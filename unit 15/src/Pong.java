import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
//import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.Font;


//import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable
{
		
	/**
	 * IF YOU WANT TO PLAY     SPEED-UP BALL  	TYPE 'a' IN "PLAY" INSTANCE
	 * IF YOU WANT TO PLAY    BLINKY BALL	TYPE 'c' IN "PLAY" INSTANCE
	 * IF YOU WANT TO PLAY       REGULAR BALL       TYPE 'r' IN "PLAY" INSTANCE
	 */
	
	
	char play = 'a';
	
	
	
	//instance variables
	private static final long serialVersionUID = 1L;
	
	private Ball ball;
	
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private Wall wall;
	
	private int timer = 0;
	
	private boolean[] keys;
	private BufferedImage back;
	private int leftScore;
	private int rightScore;	

	//starting position of ball
	private static final int BALL_Xi = 380;
	private static final int BALL_Yi = 265;
	
	public Pong()
	{
		createBall();
		
		
		leftPaddle = new Paddle(10, 244, 10, 70, Color.PINK, 4);
		rightPaddle = new Paddle(760, 244, 10, 70, Color.PINK, 4);
		wall = new Wall(0, 770, 10, 550);
		keys = new boolean[4];
		leftScore = 0;
		rightScore = 0;
		
    	setBackground(Color.WHITE);
		setVisible(true);
		
		new Thread(this).start();
		addKeyListener(this);		
	}
	
	
	public void createBall() {
		if(play == 'a') ball = new SpeedUpBall(BALL_Xi, BALL_Yi, 10, 10, Color.darkGray, 1, 1);
		else if(play == 'c') ball = new BlinkyBall(BALL_Xi, BALL_Yi, 10, 10, Color.darkGray, 3, 1);
		else if(play == 'r') ball = new Ball(BALL_Xi, BALL_Yi, 10, 10, Color.darkGray, 3, 1);
	}
	
	public void subIncSpeed() {
		timer++;
		if(timer == 4) {
			((SpeedUpBall)ball).incSpeed();
			timer = 0;
		}
	}
	
	public void update(Graphics window){
		paint(window);
	}

   	public void paint(Graphics window)
   	{
		//set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		//take a snap shop of the current screen and save it as an image
		//that is the exact same width and height as the current screen
		if(back == null)
		   back = (BufferedImage)(createImage(getWidth(),getHeight()));

		//create a graphics reference to the back ground image
		//we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		


		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);
		

		//graphToBack.setColor(Color.RED);
		//graphToBack.drawLine(0, wall.getBottom(), 800, wall.getBottom());
		

		graphToBack.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 20));
		//graphToBack.clearRect(52, 556, 708, 248);
		graphToBack.setColor(Color.GRAY);
		graphToBack.drawString("Left Player: "+leftScore, 200,500);
		graphToBack.drawString("Right Player:  "+rightScore, 400, 500);
			

		if(ball.didCollideLeft(wall)) {
	
			if (ball.getX()<=leftPaddle.getX()){
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Right Player:  "+rightScore, 400, 500);
				rightScore++;
				graphToBack.setColor(Color.GRAY);
				graphToBack.drawString("Right Player:  "+rightScore, 400, 500);
			}
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.draw(graphToBack, Color.WHITE);
			ball.setPos(BALL_Xi, BALL_Yi);
			ball.setColor(Color.WHITE);
			
			
			leftPaddle.draw(graphToBack, Color.WHITE);
			leftPaddle.setColor(Color.WHITE);
			rightPaddle.draw(graphToBack, Color.WHITE);
			rightPaddle.setColor(Color.WHITE);
			
			
			createBall();
			leftPaddle = new Paddle(10, 244, 10, 70, Color.PINK, 4);
			rightPaddle = new Paddle(760, 244, 10, 70, Color.PINK, 4);
			
			if(rightScore == 5) {
				System.out.println("RIGHT WINS");
				
				
				System.exit(0);
			}
		}
			
		
		if(ball.didCollideRight(wall)) {
			
			if (ball.getX()>=rightPaddle.getX()+rightPaddle.getWidth()){
				graphToBack.setColor(Color.WHITE);
				graphToBack.drawString("Left Player: "+leftScore, 200, 500);
				leftScore++;
				graphToBack.setColor(Color.GRAY);
				graphToBack.drawString("Left Player: "+leftScore, 200, 500);
				
			}
			ball.setXSpeed(0);
			ball.setYSpeed(0);
			ball.draw(graphToBack, Color.WHITE);
			ball.setPos(BALL_Xi, BALL_Yi);
			ball.setColor(Color.WHITE);
			
			
			leftPaddle.draw(graphToBack, Color.WHITE);
			leftPaddle.setColor(Color.WHITE);
			rightPaddle.draw(graphToBack, Color.WHITE);
			rightPaddle.setColor(Color.WHITE);
			
			
			createBall();
			leftPaddle = new Paddle(10, 244, 10, 70, Color.PINK, 4);
			rightPaddle = new Paddle(760, 244, 10, 70, Color.PINK, 4);
			
			if(leftScore == 5) {
				System.out.println("LEFT WINS");
				
	
				System.exit(0);
			}
		}
			
		
		if(ball.didCollideTop(wall) || ball.didCollideBottom(wall)) {
			ball.setYSpeed(-ball.getYSpeed());
			if(play == 'a') subIncSpeed();
		}

		//checking if ball hits left paddle
		if(ball.getX() <= leftPaddle.getX()+leftPaddle.getWidth()
			&& ball.getY() >= leftPaddle.getY()
			&& (ball.getY() <= leftPaddle.getY()+leftPaddle.getHeight()
			|| ball.getY()+ball.getHeight() >= leftPaddle.getY()
			&& ball.getY()+ball.getHeight() < leftPaddle.getY()+leftPaddle.getHeight()))
		{
			
			if(ball.getX() <= leftPaddle.getX()+leftPaddle.getWidth()-Math.abs(ball.getXSpeed()))
				ball.setYSpeed(-ball.getYSpeed());
	
			else
				ball.setXSpeed(-ball.getXSpeed());
			if(play == 'a') subIncSpeed();
		}

		//checking if ball hits right paddle
		if(ball.getX() >= rightPaddle.getX()-rightPaddle.getWidth()
				&& ball.getY() >= rightPaddle.getY()
				&& (ball.getY() <= rightPaddle.getY()+rightPaddle.getHeight()
				|| ball.getY()+ball.getHeight() >= rightPaddle.getY()
				&& ball.getY()+ball.getHeight() < rightPaddle.getY()+rightPaddle.getHeight()))
		{
		
			if(ball.getX() >= rightPaddle.getX()-rightPaddle.getWidth()+Math.abs(ball.getXSpeed()))
				ball.setYSpeed(-ball.getYSpeed());
			
			else
				ball.setXSpeed(-ball.getXSpeed());
			if(play == 'a') subIncSpeed();
		}

		
		if(keys[0] == true) {
			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[1] == true) {
			leftPaddle.moveDownAndDraw(graphToBack);
		}
			
		if(keys[2] == true) {
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if(keys[3] == true) {
			rightPaddle.moveDownAndDraw(graphToBack);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
   	}
  	
	public void keyPressed(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=true; break;
			case 'Z' : keys[1]=true; break;
			case 'I' : keys[2]=true; break;
			case 'M' : keys[3]=true; break;
		}
	}

	public void keyReleased(KeyEvent e)
	{
		switch(toUpperCase(e.getKeyChar()))
		{
			case 'W' : keys[0]=false; break;
			case 'Z' : keys[1]=false; break;
			case 'I' : keys[2]=false; break;
			case 'M' : keys[3]=false; break;
		}
	}

	public void keyTyped(KeyEvent e){}
   	

  	public void run()
  	{
  		try 
  		{
  			while(true) 
  			{
	  			Thread.currentThread();
				Thread.sleep(8);
				repaint();
	  		}
	  	} catch (Exception e){
	  		System.out.println("oops");
	  	}
    }
}