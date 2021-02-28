import application.CustomerData;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

/*
*This class is providing a test-method for testing the only
* method in the CustomerData-class.
 */
public class CustomerDataTest {
	CustomerData cd;
	private String customer;
	private double totalLoan, interest;
	private int years;
	private String testString;

	/*
	*This method is testing an example-string, which is a direct copy
	* of the first row in the txt-file. It is at first creating a
	* CustomerData-object, and then asserting that it is getting the
	* correct values of the string.
	 */
	
	@Test
	public void testFromString() {
		cd = new CustomerData(customer, totalLoan, interest, years);
		testString = "Juha,1000,5,2";
		assertTrue(cd.fromString(testString).getCustomer().equals("Juha"));
		assertTrue(cd.fromString(testString).getTotalLoan() ==1000.0);
		assertTrue(cd.fromString(testString).getInterest() ==5);
		assertTrue(cd.fromString(testString).getYears() ==2);
	}
}
