package application;

import java.util.Scanner;

/*
 * The purpose of this class is to create objects for
 * storing the data of the customers. There are variables
 * created for the customers, their loans, interest and
 * amount of years for the loan.
 * The method fromString is returning a CustomerData-object,
 * created from the txt-file.
 *
 */

public class CustomerData {

    private double totalLoan, interest;
    private int years;
    private int counter;
    private String customer;
    private String temp;
    private String tempChar;
    private Scanner scan;
    private Scanner tempScan;
    private CustomerData cusDat;

    /*
     *A constructor without parameters is needed for the initData-method in DataController.
     */

    public CustomerData() {
    }

    /*
     * Another constructor with parameters is needed, when creating the objects
     * in the fromString method in this class.
     */

    public CustomerData(String customer, double totalLoan, double interest, int years) {
        this.customer = customer;
        this.totalLoan = totalLoan;
        this.interest = interest;
        this.years = years;
    }

    public String getCustomer() {
        return customer;
    }

    public double getTotalLoan() {
        return totalLoan;
    }

    public double getInterest() {
        return interest;
    }

    public int getYears() {
        return years;
    }

    /*This method is parsing one row from the document containing
     *	information about the prospects. It is returning it as
     * a CustomerData-object.
     */

    public CustomerData fromString(String data) {
        scan = new Scanner(data);
        scan.useDelimiter(",");
        counter = 1;
        while (scan.hasNext()) {
            temp = scan.next();
            char ch = temp.charAt(0);
            tempChar = String.valueOf(ch);
            if (tempChar.equals("\"")) {
                tempScan = scan;
                temp = temp + " " + tempScan.next();
            }
            switch (counter) {
                case 1:
                    customer = temp;
                    counter++;
                    break;
                case 2:
                    totalLoan = Double.parseDouble(temp);
                    counter++;
                    break;
                case 3:
                    interest = Double.parseDouble(temp);
                    counter++;
                    break;
                case 4:
                    years = Integer.parseInt(temp);
                    break;
            }
            cusDat = new CustomerData(customer, totalLoan, interest, years);
        }
        return cusDat;
    }
}
