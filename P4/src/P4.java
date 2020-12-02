import java.util.Scanner;

// P4 Assignment
// Author: Tiffany Miao
// Date:   Feb 8, 2019
// Class:  CS163
// Email:  tmiao@rams.colostate.edu

public class P4 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		double grossSalary = 0;
		double interestIncome = 0;
		double capGains = 0;
		double totalIncome;
		double adjIncome = 0;
		double fedTax = 0;
		double stateTax;
		
		int numExemptions = 0;
		
		System.out.print("Salary: ");
		grossSalary = scnr.nextDouble();
		
		System.out.print("Exemptions: ");
		numExemptions = scnr.nextInt();
		
		System.out.print("Interest: ");
		interestIncome = scnr.nextDouble();
		
		System.out.print("Gains: ");
		capGains = scnr.nextDouble();
		
		
		totalIncome = grossSalary + interestIncome + capGains - 5000;
		
		if (numExemptions >= 6) {
		adjIncome = totalIncome - (6 * 1500);

		}

		if (adjIncome >= 0 && adjIncome < 20000)
		fedTax = 0;
		else if (adjIncome >= 20000 && adjIncome < 35000)
		fedTax = (adjIncome - 20000) * 0.13;
		else if (adjIncome >= 35000 && adjIncome < 50000)
		fedTax = ((35000 - 20000) * 0.13) + ((adjIncome - 35000) * 0.23);
		else if (adjIncome >= 50000)
		fedTax = ((35000 - 20000) * 0.13) + ((50000 - 35000) * 0.23) + ((adjIncome - 50000) * 0.28);

		stateTax = adjIncome * 0.065;
			
				
		System.out.printf("Total Income: $%.2f\n" ,totalIncome);
		System.out.printf("Adjusted Income: $%.2f\n",adjIncome);
		System.out.printf("Total Tax: $%.2f\n", (fedTax));
		System.out.printf("State Tax: $%.2f\n", stateTax);
		
		scnr.close();

	}


}
