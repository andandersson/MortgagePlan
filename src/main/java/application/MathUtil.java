package application;

/*
 * This class is creating methods for mathematical calculations.
 * When calculating the mortgage, we need to be able to calculate
 * the exponential, as well as rounding off values. Also
 * this class has clear methods, and its purpose will not change.
 * That is why the methods are static, and the singleton-
 * pattern is implemented.
 */

public class MathUtil {
	
	private static double exponent;
	private static double toRound;
	private static double roundedFloat;
	private static int roundedInt;
	private static MathUtil math = new MathUtil();

	/*
	 * Private constructor for implementing the singleton-pattern.
	 */
	private MathUtil() {
	}

	public static MathUtil getMath() {
		return math;
	}
	/*
	 * This method is calculating the exponent, or result
	 * of one number raised to the power of another. The numbers
	 * are inputs. 
	 */


	public static double calcExponent(double base, double power) {
		exponent = base;	
		for(int i = 1; i<= power-1; i++) {
			exponent = exponent * base;
		}	
		return exponent;
	}
	
	/*
	 * This method is rounding of numbers to to numbers without digits.
	 */
	
	public static int roundOf(double num) {
		toRound = num;   
		roundedInt = (int) toRound;   
		roundedFloat = (float) roundedInt;		
		if(toRound + 0.5 >=roundedFloat +1) {
			roundedInt = roundedInt +1;		
		}
		return roundedInt;	
		}
	}
