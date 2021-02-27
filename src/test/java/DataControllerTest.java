import application.DataController;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class DataControllerTest {	
	private DataController dc;	 
	
	@Test
	public void testCalculateMonthlyPayments() {
		dc = new DataController();

		double test = dc.calculateMonthlyPayments(1000, 5, 10);
		System.out.println(test);

		Assert.assertEquals((float) 417.0, test, 1e-15);
		//Assert.assertEquals((float) 417.0, dc.calculateMonthlyPayments(1000, 5, 10));
	}
	
	@Test
	public void testInit() {
		dc = new DataController();
		assertNotNull(	dc.initData());
	}
}
