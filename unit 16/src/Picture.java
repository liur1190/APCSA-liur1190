import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();
    //System.out.println("Rachael Liu, Period 1, 4/24/18, Computer No. 11");
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
    System.out.println("Rachael Liu, Period 1, 4/24/18, Computer No. 11");
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
        count++;
      }
    }
    System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\flower1.jpg");
    Picture flower2 = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color botColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
    for( int row = 0; row < pixels.length-1; row++)
    {
      for(int col = 0; col < pixels[0].length-1; col++)
      {
        topPixel = pixels[row][col];
        botPixel = pixels[row + 1][col];
        botColor = botPixel.getColor();
        if(topPixel.colorDistance(botColor) > edgeDist)
        {
          topPixel.setColor(Color.BLACK);
        }
        else
        {
          topPixel.setColor(Color.WHITE);
        }  
      }        
    }
  }
  
  
  public void keepOnlyBlue()
  {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setRed(0);
	        pixelObj.setGreen(0);
	        
	      }
	    }
  }
  
  public void keepOnlyRed()
  {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setBlue(0);
	        pixelObj.setGreen(0);
	        
	      }
	    }
  }
  
  public void keepOnlyGreen()
  {
	  Pixel[][] pixels = this.getPixels2D();
	    for (Pixel[] rowArray : pixels)
	    {
	      for (Pixel pixelObj : rowArray)
	      {
	        pixelObj.setBlue(0);
	        pixelObj.setRed(0);
	        
	      }
	    }
  }
  
  public void negate()
  {
	  for(Pixel p : getPixels()) {
			p.setRed(p.getRed()-255);
			p.setGreen(p.getGreen()-255);
			p.setBlue(p.getBlue()-255);
		}
  }
  
  public void grayscale()
  {
	  for(Pixel p : getPixels()) {
			p.setRed((p.getRed() + p.getGreen() + p.getBlue()) / 3);
			p.setGreen((p.getRed() + p.getGreen() + p.getBlue()) / 3);
			p.setBlue((p.getRed() + p.getGreen() + p.getBlue()) / 3);
		}
	  
  }
  
  public void fixUnderwater()
	{
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels)
		{
			for (Pixel pixelObj : rowArray)
			{
				if (pixelObj.getRed() < 24 && pixelObj.getBlue() > 155)
				{
					// pixelObj.setRed(pixelObj.getRed());
					// pixelObj.setBlue(pixelObj.getBlue());
					// pixelObj.setGreen(pixelObj.getGreen());
				}
				else
				{
					pixelObj.setRed(255);
					pixelObj.setBlue(255);
					pixelObj.setGreen(255);
				}
			}
		}
	}
  
  public void mirrorVerticalRightToLeft()
  {
	  Pixel[][] pixels = this.getPixels2D();
	    Pixel leftPixel = null;
	    Pixel rightPixel = null;
	    int width = pixels[0].length;
	    for (int row = 0; row < pixels.length; row++)
	    {
	      for (int col = width / 2; col < width - 1; col++)
	      {
	        leftPixel = pixels[row][col];
	        rightPixel = pixels[row][width - 1 - col];
	        rightPixel.setColor(leftPixel.getColor());
	      }
	    } 
  }
  
  public void mirrorHorizontal()
  {
	  Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length / 2 - 1; row++)
		{
			for (int col = 0; col < width - 1; col++)
			{
				topPixel = pixels[row][col];
				bottomPixel = pixels[pixels.length - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());

			}
		}
  }
  
  public void mirrorHorizontalBotToTop()
  {
	  Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel bottomPixel = null;
		int height = pixels[0].length;
		for (int row = pixels.length / 2; row < pixels.length; row++)
		{
			for (int col = 0; col < height - 1; col++)
			{
				topPixel = pixels[row][col];
				bottomPixel = pixels[pixels.length - 1 - row][col];
				bottomPixel.setColor(topPixel.getColor());

			}
		}
  }
  
  public void mirrorDiagonal()
  {
	  Pixel[][] pixels = this.getPixels2D();
		Pixel firstPixel = null;
		Pixel secondPixel = null;
		int width = pixels[0].length;
		int height = pixels.length;
		if (width > height)
		{
			width = height - 1;
		}
		else if (width < pixels.length)
		{
			height = width - 1;
		}
		for (int row = 0; row < height; row++)
		{
			for (int col = 0; col < width; col++)
			{
				firstPixel = pixels[col][row];
				secondPixel = pixels[row][col];
				secondPixel.setColor(firstPixel.getColor());

			}
		}
  }
  
  public void mirrorArms()
  {
	  int mirrorPoint = 195;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 163; row < mirrorPoint; row++)
		{

			for (int col = 100; col < 300; col++)
			{

				leftPixel = pixels[row][col];
				rightPixel = pixels[mirrorPoint - row + mirrorPoint][col];
				rightPixel.setColor(leftPixel.getColor());
				count++;
			}
		}
		System.out.println(count);
  }
  
  public void mirrorGull()
  {
	  int mirrorPoint = 345;
		Pixel leftPixel = null;
		Pixel rightPixel = null;

		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 230; row < 320; row++)
		{
			// loop from 13 to just before the mirror point
			for (int col = 235; col < mirrorPoint; col++)
			{

				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());

			}
		}
  }
  
  public void copy2(Picture fromPic, int startRow, int endRow, int startCol, int endCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length && toRow < toPixels.length; fromRow++, toRow++)
		{
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length && toCol < toPixels[0].length; fromCol++, toCol++)
			{
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}
  
  public void myCollage()
  {
	  Picture butterfly = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\butterfly1.jpg");
		Picture caterpillar = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\caterpillar.jpg");
		this.copy(butterfly, 50, 0);
		this.copy(caterpillar, 300, 0);
		this.copy(butterfly, 80, 0);
		Picture butterflyNoBlue = new Picture(butterfly);
		butterflyNoBlue.zeroBlue();
		this.copy(butterflyNoBlue, 100, 0);
		this.copy(butterfly, 300, 0);
		this.copy(caterpillar, 200, 0);
		this.mirrorVertical();
		this.write("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\collage.jpg");
  }
  
  public void blur(int x, int y, int w, int h)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel botPixel = null;
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel thePixel = null;
	  
	  int width = pixels[0].length;
	  int height = pixels.length;
	  for (int row = 1; row < height - 1; row++)
		{
			for (int col = 1; col < width - 1; col++)
			{
				thePixel = pixels[row][col];
				topPixel = pixels[row-1][col];
				botPixel = pixels[row+1][col];
				leftPixel = pixels[row][col-1];
				rightPixel = pixels[row+1][col];
				thePixel.setBlue((topPixel.getBlue()+botPixel.getBlue()+leftPixel.getBlue()+rightPixel.getBlue())/4);
				thePixel.setRed((topPixel.getRed()+botPixel.getRed()+leftPixel.getRed()+rightPixel.getRed())/4);
				thePixel.setGreen((topPixel.getGreen()+botPixel.getGreen()+leftPixel.getGreen()+rightPixel.getGreen())/4);

			}
		}
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\caterpillar.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
