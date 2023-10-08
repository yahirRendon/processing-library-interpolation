/******************************************************************************
 Project:  example of interpolation library using sineIn interpolation (serpIn?)
           and inverse interpolation.
 
 Author:   Yahir
 Date:     October 2023
 
 Notes:    processing 3.5.4^ 
 
 Parameter Guide:
 
          @param {int}   a      first value
          @param {int}   b      second value
          @param {float} t      amountt between 0.0 and 1.0
          @return               value between first and second value given t
          serpIn(int a, int b, float t)

          @param {int}   a      first value
          @param {int}   b      second value
          @param {float} v      value between first and second value
          @return               value between 0.0 and 1.0 given v per linear easing
          serpInInverse(int a, int b, float v)        
 ******************************************************************************/
import interpolation.library.*;

// elements needed for interpolation
float t = 0.0;          // t is a value between 0.0 and 1.0 used for interpolation.
                        // usually considered in terms of time or frames
float tSpd = 0.005;     // tSpd is the value at which t grows per frame

// define interpolation object
Interpolation interpolation;

/******************************************************************************
 * 
 * setup method
 * 
 *****************************************************************************/
void setup() {
  size(400, 400);
  interpolation = new Interpolation(this);
}

/******************************************************************************
 * 
 * draw method
 * 
 *****************************************************************************/
void draw() {
  background(240);
  
  // interValue will be some value between 0 & 200 as t increments/decrements
  float interpValue = interpolation.serpIn(0, 200, t);
  // we traverse t between 0 and 1.0 at our desired speed
  t += tSpd;
  if(t < 0 || t > 1.0) tSpd *= -1;
  
  // ellipse moving given sine in interpolation defined above
  fill(0);
  line(100, 40, 300, 40);
  ellipse(100 + interpValue, 40, 10, 10);
  
  // color going between 0 and 200 given sine in interpolation defined above
  fill(interpValue);
  ellipse(200, 120, 100, 100);
     
  // inverse demonstration
  fill(0);
  textAlign(CENTER, CENTER);
  
  // titles
  text("i values", 100, 200);
  text("inverse values", 200, 200);
  text("linear values", 300, 200);
  
  int gap = 0;
  for(int i = 0; i <= 200; i+= 25, gap++) {
    // move through values 0 and 200 and return inverseValue between 0 and 1.0
   float inverseValue = interpolation.serpInInverse(0, 200, i);
   
   // display values between 0 and 200 counting by 25
   text(i, 100, 220 + (gap * 20));
   
   // display the inverse value given i and range between 0 and 200
   text(inverseValue, 200, 220 + (gap * 20));
   
   // feed inverseValue into sineIn interpolation to confirm they match i
   text(interpolation.serpIn(0, 200, inverseValue), 300, 220 + (gap * 20));
  }
}
