package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet
{


    int mode = 0;

    public void settings()
    {
        size(500, 500);
    }

    public void setup() {
        colorMode(HSB);
        
    }

    public void keyPressed()
    {
        if (key >= '0' && key <='9')
        {
            mode = key - '0';
        }
        println(mode);
    }

    float magicMap(float a, float b, float c, float d, float e) {

        float output;
        a -= b;
        c -= b;
        e -= d;

        output = ((a/c) * e) + d;
        
        return output;
    }

    float magicMap1(float a, float b, float c, float d, float e) {

        float r1 = c - b;
        float r2 = e - d;
        float howFar = a - b;

        return d + ((howFar / r1) * r2);
    }
    
    public void draw()
    {
        
        switch(mode)    
        {
            case 0:
                background(0);
                int bars = 10;
                float w = width /(float) bars;
                // float colorGap = 255 / (float) bars;
                for (int i= 0; i < bars; i++) {
                    
                    noStroke();
                    fill(map(i, 0, 10, 0, 255), 255, 255);
                    rect(map(i, 0, 10, 0, 500), 0, w, height);
                }
                break;
            
			case 1:
				// map(a, b c, d, e)
				// a = input value
				// b - c = start at the end of first range
				// d - e =  start and end of the end range
				
				// map(-2, 10, 90, 200, 233);
				break;
			
			case 2:
				float gap = width * 0.1f;
				float halfGap = gap / 2.0f;
				colorMode(RGB);
				stroke(0, 255, 0);
				textAlign(CENTER, CENTER);
				for(int i = -5 ; i <=5 ; i ++)
				{
					float x = map(i, -5, 5, gap, width -gap);				
					line(x, gap, x, height - gap);
					line(gap, x, width - gap, x);
					fill(255);
					text(i, x, halfGap);
					text(i, halfGap, x);
					
				}
        }
    }
}