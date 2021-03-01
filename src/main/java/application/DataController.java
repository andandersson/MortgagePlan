package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is putting all the logic together, and printing
 * the results.
 */
public class DataController {
	private List<CustomerData> dataList;
	private CustomerData cusDat;

	/**
	 * Constructor for initiating the class. The methods in this class are directly
	 * called from the constructor, when the application is starting.
	 * The constructor is creating an object of CustomerData, without parameters.
	 * That object is needed in the init-method, for accessing the fromString-method
	 * in the CutomerData-class.
	 */
	public DataController() throws FileNotFoundException {
		cusDat = new CustomerData();
		initData();
		printData(dataList);
	}

	/**
	* The only purpose of this getter is accessing the List in
	* the DataControllerTest-class, for assuring it is containing correct
	* information after the method initData.
	*/
	public List<CustomerData>  getDataList(){
		return this.dataList;
	}

	/**
	 * This method is calling the getLines-method in FileUtil, for accessing the
	 * text-document. It is then calling the fromString-method in CustomerData,
	 * which is creating CustomerData-objects from every row, in a for-loop.
	 * In that way it is accessing all rows. It is finally
	 * storing the objects in a list.
	 */
	public void initData() throws FileNotFoundException {
		dataList = new ArrayList<CustomerData>();
		List<String> lines = FileUtil.getLines("src/main/resources/prospects.txt");
		for (int i = 0; i < lines.size(); i++) {
			dataList.add(cusDat.fromString(lines.get(i)));
		}
	}

	/**
	 * This method is performing the calculation for the monthly payments. It is
	 * taking the loan, interest rate and number of years as arguments, and
	 * performing the calculation according to the formula.
	 */
	public double calculateMonthlyPayments(double loan, double interest, int years) {
		double payments = years * 12;
		double monthlyPayments = (double) (loan * ((interest / 100) * MathUtil.calcExponent(1 + interest / 100, payments))
				/ ((MathUtil.calcExponent(1 + interest / 100, payments)) - 1));

		monthlyPayments = MathUtil.roundOf(monthlyPayments);
		return monthlyPayments;
	}

	/**
	 * In this method, the calculateMonthlyPayments()-method is called. It is done
	 * inside a for-loop, that is iterating through a list with CustomerData-objects. For
	 * every customer, the calculations are made. Finally, it is printing.
	 */
	public void printData(List<CustomerData> list) {
		int counter = 0;
		String customer;
		for (CustomerData dataPoint : list) {
			counter++;
			customer = dataPoint.getCustomer();
			double loan = dataPoint.getTotalLoan();
			double interestRate = dataPoint.getInterest();
			int years = dataPoint.getYears();
			double storeMonthlyPayments = calculateMonthlyPayments(loan, interestRate, years);
			System.out.println("Prospect " + counter + ": " + dataPoint.getCustomer() + " wants to borrow " + loan
					+ " euros for a period of " + years + " years, and pay " + storeMonthlyPayments + " euros each month. \n");
		}
	}
}
