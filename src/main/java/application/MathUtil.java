package application;

/**
 * This class is creating methods for mathematical calculations.
 * When calculating the mortgage, we need to be able to calculate
 * the exponent, as well as rounding off values. Also
 * this class has a limited purpose that will not change.
 * That is why the class and its methods are static, and the singleton-
 * pattern is implemented.
 */
public final class MathUtil {

	/**
	 * Private constructor for implementing the singleton-pattern.
	 */
	private MathUtil() {
	}

	/**
	 * This method is calculating the exponent, or result
	 * of one number raised to the power of another. The numbers
	 * are inputs. 
	 */
	public static double calcExponent(double base, double power) {
		double exponent = base;
		for(int i = 1; i<= power-1; i++) {
			exponent = exponent * base;
		}	
		return exponent;
	}
	
	/**
	 * This method is rounding of numbers to other numbers without digits.
	 */
	public static int roundOf(double num) {
		double toRound = num;
		int roundedInt = (int) toRound;
		double roundedFloat = (float) roundedInt;
		if(toRound + 0.5 >=roundedFloat +1) {
			roundedInt = roundedInt +1;		
		}
		return roundedInt;	
		}
	}