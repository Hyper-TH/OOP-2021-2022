package ie.tudublin;

import processing.core.PApplet;

public class mapping extends PApplet 
{

    public void settings() 
    {
        size(500, 500);
    }

    public void setup() 
    {
        noStroke();
    }
      
    public void draw() 
    {
        background(204);
        float  x1 = map(mouseX, 0, width, 50, 150);
        ellipse(x1, 75, 50, 50);  
        float x2 = map(mouseX, 0, width, 0, 200);
        ellipse(x2, 125, 50, 50);  
    }


    // SYNTAX FOR MAP
    /*
        map(value, start1, stop1, start2, stop2)
    */

    // Parameters
    /*
        value (float) = the incoming value to be converted
        start1 (float) = lower bound of the value's current range 
        stop1 (float) = upper bound of the value's current range 
        start2 (float) = lower bound of the value's target range 
        stop2 (float) = upper bound of the value's target range 

    */
} // end class
