package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {


    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };

    String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

    float[] a1 = new float[100];
    float[] a2;

    int minIndex = 0;
    int maxIndex  = 0;

    int mode = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		println(mode);
	}
        

    public void settings()
    {
        size(500, 500);
    }

    // This is how the map function works!
    public float map1(float from, float start1, float stop1, float start2, float stop2) {
        float range1 = stop1 - start1;
        float range2 = stop2 - start2;
        float howFar = from - start1;

        return start2 + (howFar / range1) * range2;
    }

    float sum(float[] array) {
        float sum = 0;
        for (float r : array) {
            sum += r;
        }
        return sum;
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

    public void setup()
    {
        for(int i = 0 ; i < rainfall.length ; i ++)
        {
            println(rainfall[i] + "\t" + months[i]);
        }
        for(float r:rainfall)
        {
            println(r);
        }
        
        int j = 0;
        for(float r:rainfall)
        {
            println(r + "\t" + months[j]);
            j ++;
        }

        for(int i = rainfall.length - 1; i >= 0 ; i -- )
        {
            println(rainfall[i] + "\t" + months[i]);
        }

        for(int i = 1 ; i < rainfall.length ; i ++)
        {
            if (rainfall[i] < rainfall[minIndex])
            {
                minIndex = i;
            }
            else if (rainfall[i] > rainfall[maxIndex])
            {
                maxIndex = i;
            } 
        }

        println("Max rainfall: " + rainfall[maxIndex] + " in month " + months[maxIndex]);
        println("Min rainfall: " + rainfall[minIndex] + " in month " + months[minIndex]);

    }

    public void draw()
    {
        switch (mode) {
			case 0:
            {
                background(0);
                colorMode(HSB);
                float wi = width / (float)rainfall.length;
                noStroke();
                for(int i = 0 ; i < rainfall.length ; i ++)
                {
                    float x = map(i, 0, rainfall.length, 0, width);
                    int c = (int)map(i, 0, rainfall.length, 0, 255);
                    fill(c, 255, 255);
                    float h = map(rainfall[i], 0, rainfall[maxIndex], 0, -height);
                    rect(x, height, wi, h);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(months[i], x + (wi / 2), height - 50);
                }
                break;
            }
            case 1:
            {
                // Trendline
                // Draw the axis
                background(0);
                float border = width * 0.1f;
                float range = 120;
                stroke(255);
                line(border, border, border, height - border);
                line(border, height - border, width - border, height - border);
                // Draw the vertical tick marks
                textAlign(CENTER, CENTER);
                colorMode(HSB);
                for(float f = 0; f <= range ; f += 10)
                {
                    float y = map(f, 0, range, height - border, border);
                    line(border - 5, y, border, y);
                    fill(255);
                    text((int) f, border * 0.5f, y);
                }    
                // Draw the labels
                float w = (width - (border * 2)) / rainfall.length;
                for(int i = 0 ; i < rainfall.length; i ++)
                {                    
                    float x = map(i, 0, rainfall.length, border+1, width - border);
                    fill(255);
                    text(months[i], x + (w * 0.5f), height - (border * 0.5f));
                }
                // Draw the trend line
                for(int i = 1 ; i < rainfall.length; i ++)
                {                    
                    float x1 = map(i-1, 0, rainfall.length-1, border + (w/2), width - border - (w/2));
                    float y1 = map(rainfall[i-1], 0, range, height - border, border);
                    float x2 = map(i, 0, rainfall.length-1, border + (w/2), width - border - (w/2));
                    float y2 = map(rainfall[i], 0, range, height - border, border);
                    line(x1, y1, x2, y2);
                }
                fill(255);
                text("Rainfall Trend Chart", width / 2, border / 2);
                break;
            }
            case 2:
            {
                // Bar chart
                // Draw the axis
                background(0);
                float border2 = width * 0.1f;
                float range2 = 120;
                stroke(255);
                line(border2, border2, border2, height - border2);
                line(border2, height - border2, width - border2, height - border2);
                // Draw the vertical tick marks
                textAlign(CENTER, CENTER);
                colorMode(HSB);
                for(float f = 0; f <= range2 ; f += 10)
                {
                    float y = map(f, 0, range2, height - border2, border2);
                    line(border2 - 5, y, border2, y);
                    fill(255);
                    text((int) f, border2 * 0.5f, y);
                }    
                // Draw the bars & the labels
                float w2 = (width - (border2 * 2)) / rainfall.length;
                for(int i = 0 ; i < rainfall.length; i ++)
                {
                    float x = map(i, 0, rainfall.length, border2+1, width - border2);
                    float h = map(rainfall[i], 0, range2, 0, height - (border2 * 2));
                    float c = map(i, 0, rainfall.length, 0, 255);
                    fill(c, 255, 255);
                    rect(x, height - border2 - 1, w2, - h);
                    fill(255);
                    text(months[i], x + (w2 * 0.5f), height - (border2 * 0.5f));
                }
                fill(255);
                text("Rainfall Bar Chart", width / 2, border2 / 2);
                break;    
            }


            /* START OF TUTORIAL */
            case 3:
            {
                background(0);
                float border3 = width * 0.1f;
                float w3 = (width - (border3 * 2.0f)) / (float) rainfall.length;

                // Draw the axis
                stroke(255);
                line(border3, border3, border3, height - border3);
                line(border3, height - border3, width - border3, height - border3);
                for (int i = 0; i < 120; i+= 10) 
                {
                    float y = map(i, 0, 120, height - border3, border3);
                    line(border3 - 5, y, border3, y);
                    fill(255);
                    textAlign(CENTER, CENTER);
                    text(i, border3 / 2, y);

                }
                for (int i = 0; i < rainfall.length; i++) 
                {
                    float x = map(i, 0, rainfall.length, border3, width - border3);    
                    float c = map(i, 0 , rainfall.length, 0 ,255);
                    stroke(255);
                    fill(c, 255, 255);
                    float h = map(rainfall[i], 0, 120, 0, -height - (border3 * 2)); 
                    rect(x, height - border3, w3, h);
                    fill(255);
                    text(months[i], x + (w3 / 2), height - (border3 / 2));
                }
                break;
            }

            // Pie chart
            case 4:
            {
                background(0);
                float border = width * 0.1f;                
                float sum = sum(rainfall);
                float thetaPrev = 0;
                float cx = width / 2;
                float cy = height / 2;
                for(int i = 0 ; i < rainfall.length ; i ++)
                {
                    float theta = map(rainfall[i], 0, sum, 0, TWO_PI);
                    textAlign(CENTER);
                    float thetaNext = thetaPrev + theta;
                    float radius = cx * 0.6f;       
                    float x = cx + sin(thetaPrev + (theta * 0.5f) + HALF_PI) * radius;      
                    float y = cy - cos(thetaPrev + (theta * 0.5f) + HALF_PI) * radius;
                    fill(255);
                    text(months[i], x, y);             
                    float c = map(i, 0, rainfall.length, 0, 255);
                    fill(c, 255, 255);       
                    stroke(255);
                    arc(cx, cy, cx, cy, thetaPrev, thetaNext);
                    thetaPrev = thetaNext;
                }
                fill(255);
                text("Rainfall piechart", width / 2, border / 2);
            }

            // Pie chart tutorial
            case 5:
            {
                background(0);

                // float r = mouseX;
                float r = width * 0.3f;
                float cx = width / 2;
                float cy = height / 2;
                
                stroke(255);
                noFill();
                circle(cx, cy, r * 2.0f);

                // Calculate total
                float tot  = 0;
                for (float f:rainfall) 
                {
                    tot += f;
                }

                float start = 0;

                for (int i = 0; i < rainfall.length; i++) 
                {
                    float val = map(rainfall[i], 0, tot, 0, TWO_PI);
                    float c = map(i, 0, rainfall.length, 0, 255);
                    fill(c, 255, 255);       
                    noStroke();
                    arc(cx, cy, r * 2, r* 2, start, start + val, PIE);
            
                    float theta = start + (val * 0.5f);
                    float x = cx + cos(theta) * (r * 1.2f);
                    float y = cy + sin(theta) * (r * 1.2f);
                    fill(255);
                    text(months[i], x, y);

                    start = start + val;
                }

            

                break;
            }
        }
    }    
}