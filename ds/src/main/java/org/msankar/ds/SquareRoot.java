package org.msankar.ds;

/**
 * Use Newton's method to approximate the square root of a method. 
 * Newton's method is to approximate z = Sqrt(x) by picking a starting 
 * point z and then repeating: z = z - (z*z - x)/(2*z)
 * Pick a sensible point to stop the iteration
 * 
 */
public class SquareRoot {
	public static void main (String[] args) {
		SquareRoot sr = new SquareRoot();
		System.out.println("***Finding square root of 2 ***");
		sr.getSquareRoot(2.0);		
		System.out.println("\n" + Math.sqrt(2.0));
		
		System.out.println("\n***Finding square root of 25 ***");
		sr.getSquareRoot(25.0);
		System.out.println("\n" + Math.sqrt(25.0));
	}

	private double getSquareRoot(double a) {
		double x0 = 1, x1;
		
		for ( ; ; ) {
			x1 = (x0/2) + (a/(2*x0));
			System.out.println(x1);
			if (Math.abs(x1 - x0) < 1.0e-6) {
	            break;
			}
	         x0 = x1;
		}
		return x1;
	}
}
