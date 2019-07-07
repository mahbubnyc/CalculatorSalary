import java.util.Scanner;

public class CalculatorV5 {

	// == All Global Variables
	static String nameOfEmployee;
	static double numberOfHourWorked;
	static double hourlyPayRate;
	//static double grossPay;
	//static double netPay;

	// ==Module 1
	public static void wellcome() {
		System.out.println("******* Employee Calculator V1.0**********");
		System.out.println("Please Follow the Instruction ");

	}

	// ==Module 2
	public static void getinput() {

		boolean isValid = false;

		// Taking Input 1 - Employee Name
		Scanner namescanner = new Scanner(System.in);
		System.out.print("Enter Employee Name : ");
		nameOfEmployee = namescanner.nextLine();

		// Taking Input 2 - Total Hour
		while (isValid == false) {
			try {
				Scanner TotalHourScanner = new Scanner(System.in);
				System.out.print("Enter Total Hour  : ");
				numberOfHourWorked = TotalHourScanner.nextDouble();
				if (numberOfHourWorked >= 0 && numberOfHourWorked <= 80) {
					isValid = true;
				} else {
					isValid = false;
					System.out.println("Hey The Value is Not Valid enter [0-80]");
				}
			} catch (Exception e) {
				System.out.println("The Input is not a Number Please Enter 0-80");
			}

		}

		// Taking Input 3 - Hourly Pay Rate
		isValid = false;
		while (isValid == false) {
			try {
				Scanner HrScanner = new Scanner(System.in);
				System.out.print("Enter Hourly Rate  : ");
				hourlyPayRate = HrScanner.nextDouble();
				if (hourlyPayRate >= 10 && hourlyPayRate <= 50) {
					isValid = true;
				} else {
					isValid = false;
					System.out.println("Hey The Value is Not Valid enter [10-50]");
				}
			} catch (Exception e) {
				System.out.println("The Input is not a Number Please Enter 10-50");
			}
		}
	}

	public static void calculateSalary() {
		calculateGrossPay();
		calculateNetPay();
	}

	// ==Module 3
	public static double calculateGrossPay() {
		return numberOfHourWorked * hourlyPayRate;
	}

	public static double calculateNetPay() {
		double tempNP = 0;

		if (calculateGrossPay() > 0 && calculateGrossPay() < 1500) {
			tempNP = calculateGrossPay() - 10;
		} else if (calculateGrossPay() >= 1500 && calculateGrossPay() < 3000) {
			tempNP = calculateGrossPay() - 20;
		} else if (calculateGrossPay() >= 3000 && calculateGrossPay() < 4500) {
			tempNP = calculateGrossPay() - 30;

		} else if (calculateGrossPay() >= 4500 && calculateGrossPay() < 6000) {
			tempNP = calculateGrossPay() - 40;

		} else if (calculateGrossPay() >= 6000) {
			tempNP = calculateGrossPay() - 50;
		} else {
			System.out.println("Hmmm Something went Wrong !!");
		}

		return tempNP;
	}

	// ==Module 4
	public static void displayOutput() {
		System.out.println("");
		System.out.println("");

		System.out.println("=======Pay Slip=========================");
		System.out.println("Employee Name Is " + nameOfEmployee);
		System.out.println("Employee Total Is  " + numberOfHourWorked);
		System.out.println("Employee Hourly Rate is   " + hourlyPayRate);
		System.out.println("===========================================");
		System.out.println("Employee Gross Pay is   " + calculateGrossPay());
		System.out.println("Employee Net Pay is   " + calculateNetPay());

	}

	// === Special Main Module
	public static void main(String[] args) {

		// Calling All other Modules
		wellcome();

		final int maxEmployee = 10;

		for (int i = 1; i <= maxEmployee; i++) {
			System.out.println("======Calculating Salary For Employee Number (" + i + ") =============");
			getinput();
			calculateSalary();
			displayOutput();
			System.out.println("=======================================================================");
			System.out.println("");

			// If Maximum Reached Stop it here
			if (i == maxEmployee) {
				break;
			}

			// == get the Couce And Continue if it Yes
			Scanner scan = new Scanner(System.in);
			String doYouWantToContinue;
			System.out.print("Do You want to continue (no to stop) : \t");
			doYouWantToContinue = scan.nextLine();
			if (doYouWantToContinue.equals("no")) {
				break;
			}
		}

		System.out.println("Exiting ......");
	}

}
