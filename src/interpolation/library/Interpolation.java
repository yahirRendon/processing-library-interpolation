package interpolation.library;


import processing.core.*;

/**
 * This is a template class and can be used to start a new processing Library.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own Library naming convention.
 * 
 * (the tag example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 * @example Hello 
 */

public class Interpolation {
	
	// myParent is a reference to the parent sketch
	PApplet parent;

//	private float t;          // t is a value between 0.0 and 1.0 used for interpolation.
//    						// usually consider in terms of time or frames
//	private float tSpd;     // tspd is the value at which t grows per frame
	
	public final static String VERSION = "##library.prettyVersion##";
	

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the Library.
	 * 
	 * @example Hello
	 * @param theParent the parent PApplet
	 */
	public Interpolation(PApplet theParent) {
		parent = theParent;
//		t = (float)0.0;
//		tSpd = (float)0.005;
	}
	
	/**
	* Standard linear lerp function
	*
	* @param {int}   a      first value
	* @param {int}   b      second value
	* @param {float} t      amount between 0.0 and 1.0
	* @return               value between first and second value given t
	*/
	public float lerp(int a, int b, float t) {
	  if(t <= 0) return a;
	  if(t >= 1) return b;
	  return a + (b - a) * t;
	}
	
	/**
	* Inverse function for linear interpolation. Pass a value
	* between the first and second value to get the corresponding 
	* value between 0.0 and 1.0. 
	*
	* @param {int}   a      first value
	* @param {int}   b      second value
	* @param {float} v      value between first and second value
	* @return               value between 0.0 and 1.0 given v per linear easing
	*/
	public float lerpInverse(int a, int b, float v) {
	  if(v <= a) return (float)0.0;
	  if(v >= b) return (float)1.0;
	  return (v - a) / (b - a);
	}
	
	/**
	* Interpolation function using the sine in easing function
	* by easing.net
	*
	* @param {int}   a      first value
	* @param {int}   b      second value
	* @param {float} t      amount between 0.0 and 1.0
	* @return               value between first and second value given t
	*/
	public float serpIn(int a, int b, float t) {
	  if(t <= 0) return a;
	  if(t >= 1) return b;
	  float in_t = 1 - PApplet.cos((t * PConstants.PI) / 2);
	  return a + (b - a) * in_t;  
	}
	
	/**
	* Inverse interpolation for sine in interpolation. Pass a value
	* between the first and second value to get the corresponding 
	* value between 0.0 and 1.0 based on sine in easing. 
	*
	* @param {int}   a      first value
	* @param {int}   b      second value
	* @param {float} v      value between first and second value
	* @return               value between 0.0 and 1.0 given v per sine in easing
	*/
	public float serpInInverse(int a, int b, float v) {
	  if(v <= a) return (float)0.0;
	  if(v >= b) return (float)1.0;  
	  float t = (v - a) / (b - a);
	  return (2 * PApplet.acos(1-t)) / PConstants.PI;  
	}
	
	/**
	* Interpolation function using the sine out easing function
	* by easing.net
	*
	* @param {int}   a      first value
	* @param {int}   b      second value
	* @param {float} t      amount between 0.0 and 1.0
	* @return               value between first and second value given t
	*/
	public float serpOut(int a, int b, float t) {
	  if(t <= 0) return a;
	  if(t >= 1) return b;
	  float out_t = PApplet.sin((t * PConstants.PI) / 2);
	  return a + (b - a) * out_t;
	}

	/** 
	* Inverse interpolation for sine out interpolation. Pass a value
	* between the first and second value to get the corresponding 
	* value between 0.0 and 1.0 based on sine out easing. 
	*
	* @param {int}   a      first value
	* @param {int}   b      second value
	* @param {float} v      value between first and second value
	* @return               value between 0.0 and 1.0 given v per sine out easing
	*/
	public float serpOutInverse(int a, int b, float v) {
	  if(v <= a) return (float)0.0;
	  if(v >= b) return (float)1.0;  
	  float t = (v - a) / (b - a);
	  return (2 * PApplet.asin(t)) / PConstants.PI;
	  
	}

	/**
	* Interpolation function using the sine in out easing function
	* by easing.net
	*
	* @param a      first value
	* @param b      second value
	* @param t      amount between 0.0 and 1.0
	* @return       value between first and second value at t
	*/
	public float serpInOut(int a, int b, float t) {
	  if(t <= 0) return a;
	  if(t >= 1) return b;
	  float out_t = -(PApplet.cos(PConstants.PI * t) - 1) / 2;
	  return a + (b - a) * out_t;
	}

	/** 
	* Inverse interpolation for sine in out interpolation. Pass a value
	* between the first and second value to get the corresponding 
	* value between 0.0 and 1.0 based on sine in out easing. 
	*
	* @param {int}   a      first value
	* @param {int}   b      second value
	* @param {float} v      value between first and second value
	* @return               value between 0.0 and 1.0 given v per sine in/out easing
	*/
	public float serpInOutInverse(int a, int b, float v) {
	  if(v <= a) return (float)0.0;
	  if(v >= b) return (float)1.0;  
	  float t = (v - a) / (b - a);
	  return PApplet.acos(-(2 * t) + 1) / PConstants.PI;  
	}
		
	/**
	 * return the version of the Library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}

}

