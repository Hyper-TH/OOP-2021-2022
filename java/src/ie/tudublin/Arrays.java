package ie.tudublin;

import processing.core.PApplet;

public class Arrays extends PApplet {


    float[] rainfall = { 45, 37, 55, 27, 38, 50, 79, 48, 104, 31, 100, 58 };

    String[] months = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", 
                        "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };

    // Other ways to allocate an array
    float[] a1 = new float[100];
    float[] a2; // Will get null pointer exception 

    int minIndex = 0;
    int maxIndex = 0;

    public void settings() 
    {
        size(500, 500);
    }

    public void setup()
    {
        // Use < instead of <= as you will get ArrayIndexOutOfBoundsException
        // for (int i = 0; i < rainfall.length; i++)
        // {
        //     // println is from PApplet superclass
        //     println(rainfall[i] + "\t" + months[i]);         
        // } 
        
        // Enhanced for loop (for each loop)
        // for (float r:rainfall) 
        // {
        //     println(r);
        // }
        
        // Enhanced for loop (for each loop)
        // int ii = 0;
        // for (float r:rainfall) 
        // {
        //     println(r + "\t" + months[ii]);
        //     ii++;
        // }

        // Backwards loop
        // for(int i = rainfall.length -1; i >= 0; i--)
        // {
        //     println(rainfall[i] + "\t" + months[i]);
        // }


        // Float.MIN_VALUE;
        // Float.MAX_VALUE;
        // ArrayList al = new ArrayLst<>();

        
        float total = 0;
        float average = 0;

        // Figure out what month has the least rainfall
        for (int i = 0; i < rainfall.length; i++)
        {
            // println is from PApplet superclass
            // println(rainfall[i] + "\t" + months[i]);   
            total += rainfall[i];

            if (rainfall[i] < rainfall[minIndex])
            {
                minIndex = i;
            }
            else if (rainfall[i] > rainfall[maxIndex])
            {
                maxIndex = i;
            }

        } 

        average = total / (rainfall.length);

        println("Month with least rain: " + months[minIndex]);
        println("Month with most rain: " + months[maxIndex]);
        println("Total rainfall: " + total);
        println("Average: " + average);
    } // end setup

    public void draw() 
    {
        background(0);
        colorMode(HSB);
        noStroke();

        float w = width / (float) rainfall.length;

        for(int i = 0; i < rainfall.length; i++) 
        {
            // float x = i * w;
            float x = map(i, 0, rainfall.length, 0, width);
            int c = (int) map(i, 0, rainfall.length, 0, 255);
            fill(c, 255, 255);
            float h = map(rainfall[i], 0, rainfall[maxIndex], 0, -height);
            rect(x, height, w, h);
            fill(255);
            textAlign(CENTER, CENTER);
            text(months[i], x + (w / 2), height - 50);
        }
    } // end draw
}
