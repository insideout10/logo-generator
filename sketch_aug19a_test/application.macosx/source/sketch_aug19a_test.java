import processing.core.*; 
import processing.xml.*; 

import java.applet.*; 
import java.awt.Dimension; 
import java.awt.Frame; 
import java.awt.event.MouseEvent; 
import java.awt.event.KeyEvent; 
import java.awt.event.FocusEvent; 
import java.awt.Image; 
import java.io.*; 
import java.net.*; 
import java.text.*; 
import java.util.*; 
import java.util.zip.*; 
import java.util.regex.*; 

public class sketch_aug19a_test extends PApplet {

// public variables

int z = 32; // font size (available also 20, 24, 40, 50)  

int x = PApplet.parseInt(z*7.3f); // horizontal spacing - lenght of the full string
int y= z; // vertical spacing
int intMargin = 4; // define bounding box vertical margin 

int h;  // text width

PImage b; // splash screen img object

public void setup() 
{
  
  // size(screenWidth, screenHeight); // full screen 
  size(screenWidth/2, screenHeight/2); // test screen 
  // size(235, 43); // one and only
  
  frameRate(2);
  
  //noLoop(); // Only draw once
  
   b = loadImage("logo-000NEW.png"); //loading the splash screen

   b.resize(width, height); // resizing image to the width and height values
   
   background(b); // displaying splash screen as background
  
}

public void draw() {
    
    background(255,255,255);
    
    int x_;
    int y_;
  
    for (int f = 0; f < width/x; f = f+1) {
     for (int i = 0; i < height/y; i = i+1) {
      
      if (f == 0){
        x_ = 1;
        }else{
        x_ = x*f;
        }  
       
       if (i == 0){
        y_ = z;
        }else{
        y_ = y*i;
        }
        
        ////////////
        /// IN  ///
        ///////////  
        
        chooseRandomFont();      

        int num0 = PApplet.parseInt(random(0, 3));
        
        switch(num0) {
         case 0: 
          chooseRandomColor_write("iN", x_, y_);
          break;
         case 1: 
          chooseRandomColor_write("In", x_, y_);
          break;
         case 2: 
          chooseRandomColor_write("IN", x_, y_);
          break;
         case 3: 
          chooseRandomColor_write("in", x_, y_);
          break;
 
        }
                
        
        //////////////
        /// SIDE  ///
        /////////////
        
        chooseRandomFont();    
        
        int num1 = PApplet.parseInt(random(0, 2));

        switch(num1) {
         case 0: 
          chooseRandomColor_write("SIDE", h, y_);
          break;
         case 1: 
          chooseRandomColor_write("side", h, y_);
          break;
         
        }
        
      
        ////////////
        /// OUT  ///
        ///////////
        
        chooseRandomFont();
        
        int num2 = PApplet.parseInt(random(0, 6));

        switch(num2) {
          case 0: 
          chooseRandomColor_write("out", h, y_);
          break;
         case 1: 
          chooseRandomColor_write("Out", h, y_);
          break;
         case 2: 
          chooseRandomColor_write("OUT", h, y_);
          break;
         case 3: 
          chooseRandomColor_write("ouT", h, y_);
          break;
         case 4: 
          chooseRandomColor_write("OuT", h, y_);
          break;
         case 5: 
          chooseRandomColor_write("oUT", h, y_);
          break;
         case 6: 
          chooseRandomColor_write("OUt", h, y_);
          break;      
 
        }        
        
      
        ////////////
        /// 1   ///
        ///////////
      
        chooseRandomFont();
        chooseRandomColor_write("1", h, y_);
        
        ////////////
        /// 0   ///
        ///////////
        
      
        chooseRandomFont();
        chooseRandomColor_write("0", h, y_);
        

    }
}
}

public void chooseRandomColor_write(String sText, int xP, int yP) {

  int[] colorlistText;
  int[] colorlistRect;

  // calculating textWidth
  h = PApplet.parseInt(textWidth(sText)) + xP;
  
  // creating bounding box around text with no stroke
  noStroke();
  
  // coloring the bounding box using a random color from the palette
  colorlistRect = chooseRandomColor();
  fill(colorlistRect[0],colorlistRect[1],colorlistRect[2]); 
  rect(xP,yP-y+intMargin,h,yP+intMargin);
  
   
  // choosing a random color from the palette for the text
  colorlistText = chooseRandomColor();
   
  // avoiding color repetition between text and bounding box
  while (Arrays.equals(colorlistText,colorlistRect)) { 
      colorlistText = chooseRandomColor();    }
  fill(colorlistText[0],colorlistText[1],colorlistText[2]);
  text(sText, xP, yP);
  } 

  // random color generator
  public int[] chooseRandomColor() {
  
  String[] colors = new String[8];
  
  // color palette - change here to try different palette
  colors[0] = "242,15,98";
  colors[1] = "255,154,46";
  colors[2] = "249,248,30";
  colors[3] = "143,210,42";
  colors[4] = "100,41,148";
  colors[5] = "255,255,255";
  colors[6] = "25,24,24";
  colors[7] = "25,24,24";  
  
  float q = random(7);
  int c = PApplet.parseInt(q);
  String[] colorlist = split(colors[c], ','); 
  int[] colorlist_ = PApplet.parseInt(colorlist);
  return colorlist_; 
}

  // random font generator
public void chooseRandomFont() {
 
  // Load the font. Fonts must be placed within the data 
  // directory of your sketch. Use Tools > Create Font 
  // to create a distributable bitmap font. 

   PFont fontA;
   
   String k = str(z);
   
   String[] fonts = new String[8];
   fonts[0] = "TwCenMT-Bold-" + k + ".vlw";
   fonts[1] = "Calibri-Bold-" + k + ".vlw";
   fonts[2] = "Rockwell-ExtraBold-" + k + ".vlw";
   fonts[3] = "ACaslonPro-Semibold-" + k + ".vlw";
   fonts[4] = "AGaramondPro-Bold-" + k + ".vlw";
   fonts[5] = "AmericanTypewriter-Bold-" + k + ".vlw";
   fonts[6] = "Ayuthaya-" + k + ".vlw";
   fonts[7] = "TamilMN-Bold-" + k + ".vlw";
  
   float b = random(7);
   int c = PApplet.parseInt(b);
   fontA = loadFont(fonts[c]);
   textFont(fontA, z);

}

public void mousePressed() 
{
     saveFrame("logo-####.png"); 
}


  static public void main(String args[]) {
    PApplet.main(new String[] { "--bgcolor=#FFFFFF", "sketch_aug19a_test" });
  }
}
