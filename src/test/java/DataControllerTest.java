import application.DataController;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

/*
*This class is providing test-methods for testing the logic
* in the class MathUtil.
 */

public class DataControllerTest {	
	private DataController dc;	 
	
	@Test
	public void testCalculateMonthlyPayments() {
		dc = new DataController();
		double testProspectOne = dc.calculateMonthlyPayments(1000, 5, 2);
		double testProspectTwo = dc.calculateMonthlyPayments(4356, 1.27, 6);
		double testProspectThree = dc.calculateMonthlyPayments(1300.55, 8.67, 2);
		double testProspectFour = dc.calculateMonthlyPayments(2000, 6, 4);
		Assert.assertEquals((float) 72.0, testProspectOne, 1e-15);
		Assert.assertEquals((float) 93.0, testProspectTwo, 1e-15);
		Assert.assertEquals((float) 130.0, testProspectThree, 1e-15);
		Assert.assertEquals((float) 128.0, testProspectFour, 1e-15);
	}
	
	@Test
	public void testInit() {
		dc = new DataController();
		assertNotNull(dc.initData());
	}
}
