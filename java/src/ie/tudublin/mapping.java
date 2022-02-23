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

    // This is how the map function works!
    public float map1(float from, float start1, float stop1, float start2, float stop2) {
        float range1 = stop1 - start1;
        float range2 = stop2 - start2;
        float howFar = from - start1;

        return start2 + (howFar / range1) * range2;
    }

    // This is a demo of the map function
    public void drawGrid() {
        stroke(0, 255, 0);
        float border = width * 0.1f;
        textAlign(CENTER, CENTER);
        for (int i = -5; i <= 5; i++) {
            float x = map(i, -5, 5, border, width - border);
            line(x, border, x, height - border);
            line(border, x, width - border, x);
            fill(255);
            text(i, x, border * 0.5f);
            text(i, border * 0.5f, x);
        }
    }
    
} // end class
