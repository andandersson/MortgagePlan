import application.MathUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathUtilTest {
	
	@Test
	public void testCalcExponent() {
		double test = MathUtil.calcExponent(2, 3);
		assertEquals((float) 8, test, 1e-15);

		//assertEquals((float) 8, MathUtil.calcExponent(2, 3));
	//	assertEquals((float) 27, MathUtil.calcExponent(3, 3));
	//	assertEquals((float) 256, MathUtil.calcExponent(4, 4));

	}
	@Test
	public void testRound() {
		
		assertEquals((int) 4, MathUtil.roundOf(4.14) );
		assertEquals((int) 5, MathUtil.roundOf(4.50) );
		assertEquals((int) 4, MathUtil.roundOf(4.49) );
	}
}
