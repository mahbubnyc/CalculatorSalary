import java.util.Scanner;

public class CalculatorV6_1 {

	// == Important Color Display 
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";	
	
	
	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	
	// == All Global Variables
	static String nameOfEmployee;
	static double numberOfHourWorked;
	static double hourlyPayRate;
	static double grossPay;
	static double netPay;

	// ==Module 1
	public static void wellcome() {
		System.out.println("******* Employee Calculator V1.0**********\n");
		//System.out.println("Please Follow the Instruction ");
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
				System.out.print("Enter Total Hour    : ");
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
				System.out.print("Enter Hourly Rate   : ");
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
		grossPay = calculateGrossPay();
		netPay = calculateNetPay();
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
		System.out.println("********Pay Slip*****************************");
		System.out.println("Employee Name Is " + nameOfEmployee);
		System.out.println("Employee Total Is  " + numberOfHourWorked);
		System.out.println("Employee Hourly Rate is   " + hourlyPayRate);
		System.out.println("Employee Gross Pay is   " + grossPay);
		System.out.println("Employee Net Pay is   " + netPay);
		System.out.println("************************************");
	}

	
	@SuppressWarnings("resource")
	public static void displayMenueSelection() {		
		
		Scanner scan;
		scan = new Scanner(System.in);
		System.out.print(ANSI_BLUE + "Select an Action [ Add(A) | Edit(E) | Delete(D) ] : \t" + ANSI_RESET);
		String cMenueSelection = scan.nextLine();

		switch(cMenueSelection) {

		case "A" : 
			System.out.println("");
			System.out.println(ANSI_BLUE_BACKGROUND + ANSI_WHITE + " Enter Employee Name, TotalHour-Worked & Hourly-Rate Information" + ANSI_RESET);

			getinput();
			calculateSalary();
			displayOutput();
			break;

		case "E" : 
			System.out.println(ANSI_BLUE_BACKGROUND + ANSI_WHITE + " Edit Infomration .. " + ANSI_RESET);
			break;

		case "D" : 
			System.out.println(ANSI_BLUE_BACKGROUND + ANSI_WHITE + " Delete Infomration .. " + ANSI_RESET);
			break;

		default:
			//System.out.println("[ Option Selected " + cMenueSelection + " is not available !!!!]");
			System.out.println(ANSI_RED + " [" + cMenueSelection + "] is not a valid Chose correct Action !!!!]" + ANSI_RESET);
			displayMenueSelection() ;
		}
	}
	
	@SuppressWarnings("resource")
	public static boolean doYouWantToContinue() {
		
		Scanner scan;
		scan = new Scanner(System.in);

		System.out.println("");
		System.out.print(ANSI_BLUE + "Do you want to continue [No(N) | Yes(Y)] : \t" + ANSI_RESET );
		char cContinue = scan.next().charAt(0);
		if(Character.toUpperCase(cContinue)=='Y') {
			return true;
		}

		return false;
	}
	
	
	// === Special Main Module
	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		
		// Calling All other Modules
		wellcome();
		
		int counter=0;
		
		do {
			displayMenueSelection();
			if(doYouWantToContinue()==false) break;
			
		} while (true);
		
		
		
		System.out.println("\n\nThanks for using - Exiting ....!!!");

	}

}
