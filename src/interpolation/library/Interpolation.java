package interpolation.library;

import processing.core.*;

/**
 * This is a template class and can be used to start a new processing Library.
 * Make sure you rename this class as well as the name of the example package
 * 'template' to your own Library naming convention.
 * 
 * (the tag example followed by the name of an example included in folder
 * 'examples' will automatically include the example in the javadoc.)
 *
 * @example Hello
 */

public class Interpolation {

	// parent is a reference to the parent sketch
	PApplet parent;


	public final static String VERSION = "##library.prettyVersion##";

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the Library.
	 * 
	 * @param theParent the parent PApplet
	 */
	public Interpolation(PApplet theParent) {
		parent = theParent;

	}

	/**
	 * Interpolation function using the exponential in easing function by easing.net
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} t amount between 0.0 and 1.0
	 * @return value between first and second value given t
	 */
	public float exerpIn(int a, int b, float t) {
		if (t <= 0)
			return a;
		if (t >= 1)
			return b;
		float in_t = PApplet.pow(2, 10 * t - 10);
		return a + (b - a) * in_t;
	}

	/**
	 * Inverse interpolation for exponential in interpolation. Pass a value between
	 * the first and second value to get the corresponding value between 0.0 and 1.0
	 * based on exponential in easing.
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} v value between first and second value
	 * @return value between 0.0 and 1.0 given v per exponential in easing
	 */
	public float exerpInInverse(int a, int b, float v) {
		if (v <= a)
			return (float) 0.0;
		if (v >= b)
			return (float) 1.0;
		float t = (v - a) / (b - a);
		return PApplet.log(1024 * t) / (10 * PApplet.log(2));
	}

	/**
	 * Interpolation function using the exponential out easing function by
	 * easing.net
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} t amount between 0.0 and 1.0
	 * @return value between first and second value given t
	 */
	public float exerpOut(int a, int b, float t) {
		if (t <= 0)
			return a;
		if (t >= 1)
			return b;
		float out_t = 1 - PApplet.pow(2, -10 * t);
		return a + (b - a) * out_t;
	}

	/**
	 * Inverse interpolation for exponential out interpolation. Pass a value between
	 * the first and second value to get the corresponding value between 0.0 and 1.0
	 * based on exponential out easing.
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} v value between first and second value
	 * @return value between 0.0 and 1.0 given v per exponential out easing
	 */
	public float exerpOutInverse(int a, int b, float v) {
		if (v <= a)
			return (float) 0.0;
		if (v >= b)
			return (float) 1.0;
		float t = (v - a) / (b - a);
		return -PApplet.log(1 - t) / (10 * PApplet.log(2));
	}

	/**
	 * Interpolation function using the exponential in/out easing function by
	 * easing.net
	 *
	 * @param a first value
	 * @param b second value
	 * @param t amount between 0.0 and 1.0
	 * @return value between first and second value at t
	 */
	public float exerpInOut(int a, int b, float t) {
		if (t <= 0)
			return a;
		if (t >= 1)
			return b;
		float out_t = t < 0.5 ? PApplet.pow(2, 20 * t - 10) / 2 : (2 - PApplet.pow(2, -20 * t + 10)) / 2;
		return a + (b - a) * out_t;
	}

	/**
	 * Inverse interpolation for exponential in/out interpolation. Pass a value
	 * between the first and second value to get the corresponding value between 0.0
	 * and 1.0 based on exponential in/out easing.
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} v value between first and second value
	 * @return value between 0.0 and 1.0 given v per exponential in/out easing
	 */
	public float exerpInOutInverse(int a, int b, float v) {
		if (v <= a)
			return (float) 0.0;
		if (v >= b)
			return (float) 1.0;
		float t = (v - a) / (b - a);
		return t < 0.5 ? PApplet.log(2048 * t) / (20 * PApplet.log(2))
				: -(PApplet.log((1 - t) / 512)) / (20 * PApplet.log(2));
	}

	/**
	 * Standard linear lerp function
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} t amount between 0.0 and 1.0
	 * @return value between first and second value given t
	 */
	public float lerp(int a, int b, float t) {
		if (t <= 0)
			return a;
		if (t >= 1)
			return b;
		return a + (b - a) * t;
	}

	/**
	 * Inverse function for linear interpolation. Pass a value between the first and
	 * second value to get the corresponding value between 0.0 and 1.0.
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} v value between first and second value
	 * @return value between 0.0 and 1.0 given v per linear easing
	 */
	public float lerpInverse(int a, int b, float v) {
		if (v <= a)
			return (float) 0.0;
		if (v >= b)
			return (float) 1.0;
		return (v - a) / (b - a);
	}

	/**
	 * Interpolation function using the quad in easing function by easing.net
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} t amount between 0.0 and 1.0
	 * @return value between first and second value given t
	 */
	public float qerpIn(int a, int b, float t) {
		if (t <= 0)
			return a;
		if (t >= 1)
			return b;
		float in_t = t * t;
		return a + (b - a) * in_t;
	}

	/**
	 * Inverse interpolation for quad in interpolation. Pass a value between the
	 * first and second value to get the corresponding value between 0.0 and 1.0
	 * based on quad in out easing.
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} v value between first and second value
	 * @return value between 0.0 and 1.0 given v per quad in easing
	 */
	public float qerpInInverse(int a, int b, float v) {
		if (v <= a)
			return (float) 0.0;
		if (v >= b)
			return (float) 1.0;
		float t = (v - a) / (b - a);
		return PApplet.sqrt(t);
	}

	/**
	 * Interpolation function using the quad out easing function by easing.net
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} t amount between 0.0 and 1.0
	 * @return value between first and second value given t
	 */
	public float qerpOut(int a, int b, float t) {
		if (t <= 0)
			return a;
		if (t >= 1)
			return b;
		float in_t = 1 - (1 - t) * (1 - t);
		return a + (b - a) * in_t;
	}

	/**
	 * Inverse interpolation for quad out interpolation. Pass a value between the
	 * first and second value to get the corresponding value between 0.0 and 1.0
	 * based on quad out easing.
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} v value between first and second value
	 * @return value between 0.0 and 1.0 given v per quad out easing
	 */
	public float qerpOutInverse(int a, int b, float v) {
		if (v <= a)
			return (float) 0.0;
		if (v >= b)
			return (float) 1.0;
		float t = (v - a) / (b - a);
		return -PApplet.sqrt(-t + 1) + 1;
	}

	/**
	 * Interpolation function using the quad in out easing function by easing.net
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} t amount between 0.0 and 1.0
	 * @return value between first and second value given t
	 */
	public float qerpInOut(int a, int b, float t) {
		if (t <= 0)
			return a;
		if (t >= 1)
			return b;
		float in_t = t < 0.5 ? 2 * t * t : 1 - PApplet.sq(-2 * t + 2) / 2;
		return a + (b - a) * in_t;
	}

	/**
	 * Inverse interpolation for quad in/out interpolation. Pass a value between the
	 * first and second value to get the corresponding value between 0.0 and 1.0
	 * based on quad in/out easing.
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} v value between first and second value
	 * @return value between 0.0 and 1.0 given v per quad in/out easing
	 */
	public float qerpInOutInverse(int a, int b, float v) {
		if (v <= a)
			return (float) 0.0;
		if (v >= b)
			return (float) 1.0;
		float t = (v - a) / (b - a);
		return t < 0.5 ? (PApplet.sqrt(2) * PApplet.sqrt(t)) / 2 : 1 - (PApplet.sqrt(2 - 2 * t)) / 2;
	}

	/**
	 * Interpolation function using the sine in easing function by easing.net
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} t amount between 0.0 and 1.0
	 * @return value between first and second value given t
	 */
	public float serpIn(int a, int b, float t) {
		if (t <= 0)
			return a;
		if (t >= 1)
			return b;
		float in_t = 1 - PApplet.cos((t * PConstants.PI) / 2);
		return a + (b - a) * in_t;
	}

	/**
	 * Inverse interpolation for sine in interpolation. Pass a value between the
	 * first and second value to get the corresponding value between 0.0 and 1.0
	 * based on sine in easing.
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} v value between first and second value
	 * @return value between 0.0 and 1.0 given v per sine in easing
	 */
	public float serpInInverse(int a, int b, float v) {
		if (v <= a)
			return (float) 0.0;
		if (v >= b)
			return (float) 1.0;
		float t = (v - a) / (b - a);
		return (2 * PApplet.acos(1 - t)) / PConstants.PI;
	}

	/**
	 * Interpolation function using the sine out easing function by easing.net
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} t amount between 0.0 and 1.0
	 * @return value between first and second value given t
	 */
	public float serpOut(int a, int b, float t) {
		if (t <= 0)
			return a;
		if (t >= 1)
			return b;
		float out_t = PApplet.sin((t * PConstants.PI) / 2);
		return a + (b - a) * out_t;
	}

	/**
	 * Inverse interpolation for sine out interpolation. Pass a value between the
	 * first and second value to get the corresponding value between 0.0 and 1.0
	 * based on sine out easing.
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} v value between first and second value
	 * @return value between 0.0 and 1.0 given v per sine out easing
	 */
	public float serpOutInverse(int a, int b, float v) {
		if (v <= a)
			return (float) 0.0;
		if (v >= b)
			return (float) 1.0;
		float t = (v - a) / (b - a);
		return (2 * PApplet.asin(t)) / PConstants.PI;

	}

	/**
	 * Interpolation function using the sine in out easing function by easing.net
	 *
	 * @param a first value
	 * @param b second value
	 * @param t amount between 0.0 and 1.0
	 * @return value between first and second value at t
	 */
	public float serpInOut(int a, int b, float t) {
		if (t <= 0)
			return a;
		if (t >= 1)
			return b;
		float out_t = -(PApplet.cos(PConstants.PI * t) - 1) / 2;
		return a + (b - a) * out_t;
	}

	/**
	 * Inverse interpolation for sine in out interpolation. Pass a value between the
	 * first and second value to get the corresponding value between 0.0 and 1.0
	 * based on sine in out easing.
	 *
	 * @param {int}   a first value
	 * @param {int}   b second value
	 * @param {float} v value between first and second value
	 * @return value between 0.0 and 1.0 given v per sine in/out easing
	 */
	public float serpInOutInverse(int a, int b, float v) {
		if (v <= a)
			return (float) 0.0;
		if (v >= b)
			return (float) 1.0;
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
