import application.DataController;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
*This class is providing test-methods for testing the logic
* in the class DataController. The only method not tested is the printData-method,
 * that is for the reason that the method is tested every time the MainApplication
 * is starting, as it is printing results.
 */

public class DataControllerTest {	

	private DataController dc;

	/*
	*This method is testing the calculations of the mortgage for every customer.
	* I decided to put a separate test for everyone, since this is the main-purpose
	* of the application, and it is important that they are correct.
	 */
	
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

	/*
	*This method is testing the method initData. The method is creating
	* an instance of DataController, which means the constructor is calling
	* the initData-method. In order to assure it is working correctly,
	* it is checking the value of the first index of the
	* dataList, which is created in that method.
	 */

	@Test
	public void testInitData() {
		dc = new DataController();
		assertTrue(dc.getDataList().get(0).getCustomer().equals("Juha"));
		assertTrue(dc.getDataList().get(0).getTotalLoan()==1000);
		assertTrue(dc.getDataList().get(0).getInterest()==5);
		assertTrue(dc.getDataList().get(0).getYears()==2);
	}
}
