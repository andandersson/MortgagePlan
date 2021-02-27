package application;

import java.util.ArrayList;
//fixa onödiga mellanrum bort
import java.util.List;

/*
 * This class is putting all the logic together.
 * The constructor is creating an object of CustomerData, without parameters.
 * The init-method
 * 
 * 
 * config fil, där man lägge rin user name, adress, password och sånt.
 * 
 * 
 * klass som representerar databasen..
 * 
 * 
 * ändra om koden, klasser. 
 * 
 * 
 * 
 * 
 * databas
 * config-file.
 * 
 * 
 * skilda metoder för parsing, och lägga till i listor
 * 
 */

public class DataController {
	private List<CustomerData> dataList;
	private String customer;
	private double loan;
	private double interestRate;
	private double monthlyPayments;
	private double payments;
	private double storeMonthlyPayments;
	private int years;
	private int counter;
	private StringBuffer outPut;
	private CustomerData cusDat;
	/*
	 * Constructor for initiating the class. The methods in this class are directly
	 * called from the constructor, when the application is starting.
	 */

	public DataController() {
		cusDat = new CustomerData();
		initData();
		outPut = new StringBuffer();
		printData(dataList);
	}

	public List<CustomerData> getDataList() {
		return this.dataList;
	}
	
	/*
	 * This method is calling the getLines-method in FileUtil, for accessing the
	 * text-document. It is then calling the fromString-method in Customerdata,
	 * which is creating CustomerData-objects from every row, in a forloop. It is finally
	 * storing the objects in a list.
	 */
	
	public List<CustomerData> initData() {
		dataList = new ArrayList<CustomerData>();
		List<String> lines = FileUtil.getLines("resources/prospects.txt");
		for (int i = 0; i < lines.size(); i++) {
			dataList.add(cusDat.fromString(lines.get(i)));
		}
		return dataList;
	}

	/*
	 * This method is performing the calculation for the monthly payments. It is
	 * taking the loan, interest rate and number of years as arguments, and
	 * performing the calculation according to the formula.
	 * 
	 */

	public double calculateMonthlyPayments(double loan, double interest, int years) {
		payments = years * 12;
		monthlyPayments = (double) (loan * ((interest / 12) * MathUtil.calcExponent(1 + interest / 12, payments))
				/ ((MathUtil.calcExponent(1 + interest / 12, payments)) - 1));

		monthlyPayments = MathUtil.roundOf(monthlyPayments);
		return monthlyPayments;
	}

	/*
	 * In this method, the calculateMonthlyPayments()-method is called. It is done
	 * inside a for-loop, that is iterating through list with customer-data. For
	 * every customer, the calculations are made. Finally, it is storing the data in
	 * a StringBuffer
	 * 
	 * 
	 * 
	 * 
	 */

	public void printData(List<CustomerData> list) {
		counter = 1;
		for (CustomerData dataPoint : list) {
			counter++;
			customer = dataPoint.getCustomer();
			loan = dataPoint.getTotalLoan();
			interestRate = dataPoint.getInterest();
			years = dataPoint.getYears();
			storeMonthlyPayments = calculateMonthlyPayments(loan, interestRate, years);
			outPut.append("Prospect " + counter + ": " + dataPoint.getCustomer() + " wants to borrow " + loan
					+ " for a period of " + years + " years and pay " + storeMonthlyPayments + " euros each month \n");
		}
		System.out.println(outPut);
	}
}
