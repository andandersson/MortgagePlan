import application.MathUtil;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * This class is testing the logic in the MathUtil-class.
 */
public class MathUtilTest {

	/**
	 * This method is testing that the method for calculating the exponent
	 * is working correctly.
	 */
	@Test
	public void testCalcExponent() {
		double test = MathUtil.calcExponent(2, 3);
		assertEquals((float) 8, test, 1e-15);
	}

	/**
	 * This method is testing that the method for rounding off
	 * 	is worling correctly.
	 */
	@Test
	public void testRound() {
		assertEquals((int) 4, MathUtil.roundOf(4.14) );
		assertEquals((int) 5, MathUtil.roundOf(4.50) );
		assertEquals((int) 4, MathUtil.roundOf(4.49) );
	}
}
