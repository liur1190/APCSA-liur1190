/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\swan.jpg");
    swan.explore();
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testKeepOnlyBlue()
  {
	  Picture beach = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\beach.jpg");
	  beach.explore();
	  beach.keepOnlyBlue();
	  beach.explore();
  }
  
  public static void testKeepOnlyRed()
  {
	  Picture beach = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\beach.jpg");
	  beach.explore();
	  beach.keepOnlyRed();
	  beach.explore();
  }
  
  public static void testKeepOnlyGreen()
  {
	  Picture beach = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\beach.jpg");
	  beach.explore();
	  beach.keepOnlyGreen();
	  beach.explore();
  }
  
  public static void testNegate()
  {
	  Picture beach = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\beach.jpg");
	  beach.explore();
	  beach.negate();
	  beach.explore();
  }
  
  public static void testGrayscale()
  {
	  Picture beach = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\beach.jpg");
	  beach.explore();
	  beach.grayscale();
	  beach.explore();
  }
  
  public static void testFixUnderwater()
  {
	  Picture water = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\water.jpg");
	  water.explore();
	  water.fixUnderwater();
	  water.explore();
  }
  
  public static void testMirrorVerticalRightToLeft()
  {
	  Picture caterpillar = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorVerticalRightToLeft();
	  caterpillar.explore();
  }
  
  public static void testMirrorHorizontal()
  {
	  Picture caterpillar = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorHorizontal();
	  caterpillar.explore();
  }
  
  public static void testMirrorHorizontalBotToTop()
  {
	  Picture caterpillar = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorHorizontalBotToTop();
	  caterpillar.explore();
  }
  
  public static void testMirrorDiagonal()
  {
	  Picture beach = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\beach.jpg");
	  beach.explore();
	  beach.mirrorDiagonal();
	  beach.explore();
  }
  
  public static void testMirrorArms()
  {
	  Picture snowman = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\snowman.jpg");
	  snowman.explore();
	  snowman.mirrorArms();
	  snowman.explore();
  }
  
  public static void testMirrorGull()
  {
	  Picture seagull = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\seagull.jpg");
	  seagull.explore();
	  seagull.mirrorGull();
	  seagull.explore();
  }
  public static void testCopy()
  {
	  Picture snowman = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\snowman.jpg");
	  snowman.explore();
	  snowman.copy(snowman, 70, 120);
	  snowman.explore();
  }
  public static void testCopy2()
  {
	  Picture snowman = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\snowman.jpg");
	  snowman.explore();
	  snowman.copy2(snowman, 80, 164, 164, 247);
	  snowman.explore();
  }
  
  public static void testMyCollage()
  {
	  Picture seagull = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\640x480.jpg");
	  seagull.explore();
	  seagull.myCollage();
	  seagull.explore();
  }
  
  public static void testEdgeDetection2()
  {
	  Picture swan = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\swan.jpg");
	    swan.explore();
	    swan.edgeDetection(10);
	    swan.explore();
  }
  
  
  public static void testBlur(int x, int y, int w, int h, int n)
  {
	  Picture redMoto = new Picture("H:\\APCS\\APCSA-liur1190\\Unit16\\pixLab\\images\\redMotorcycle.jpg");
	  redMoto.explore();
	  for (int i = 0; i < n; i++)
	  {
		  redMoto.blur(x,y,w,h);
	  }
	  redMoto.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
	//testMirrorHorizontal();
	//testMirrorHorizontalBotToTop();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();     
    //testMirrorDiagonal();
	//testCollage();
    //testMyCollage();
    //testCopy();
	//testCopy2();
    //testEdgeDetection(); 
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
	testBlur(190,160,20,20,10);
  }
}