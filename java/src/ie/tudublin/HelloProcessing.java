package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() { 
		// colorMode(HSB); // HSB: Hue Saturation Brightness
		colorMode(RGB);
		background(0);
		
	}

	float x1, y1, x2, y2;
	float x1dir, x2dir, y1dir, y2dir;
	float c = 0;
	
	public void draw()
	{	
		// stroke(255); 
		background(255, 0, 0); // single number is greyscale
		// line(10, 10, 200, 200); // x1, y1, x2, y2 (origin at top left)
		// circle(200, 250, 50); // cx, cy, r
		// ellipse(50, 200, 90, 200); // cs, cy, w, h

		// stroke(0);
		// fill(0, 0, 255);
		// noFill();
		// noStroke();

		// rectMode(CENTER);

		// rect(300, 20, 100, 20); // tlx, tly, w, h
		
		// rectMode(CORNER);
		// rect(200, 20, 100, 20); // tlx, tly, w, h

		// point(20, 300);

		// triangle(10, 400, 50, 450, 300, 200); // x1, y1, x2, y2, x3, y3
	
		fill(255, 255, 0);
		noStroke();
		circle(250, 270, 430);		

		fill(0, 255, 255);
		noStroke();
		triangle(30, 450, 250, 10, 470, 450);

		fill(128, 128, 128);
		noStroke();
		ellipse(250, 210, 190, 110);
	
		fill(0, 0, 0);
		noStroke();
		circle(250, 210, 100);
	}
}
