import application.MathUtil;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathUtilTest {

	private MathUtil math;
	
	@Test
	public void testCalcExponent() {
		math = MathUtil.getMath();
		double test = math.calcExponent(2, 3);
		assertEquals((float) 8, test, 1e-15);
	}
	@Test
	public void testRound() {
		
		assertEquals((int) 4, math.roundOf(4.14) );
		assertEquals((int) 5, math.roundOf(4.50) );
		assertEquals((int) 4, math.roundOf(4.49) );
	}
}
