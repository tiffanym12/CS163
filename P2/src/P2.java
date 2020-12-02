// P2 Assignment
// Author: Tiffany Miao
// Date:   Feb 02, 2019
// Class:  CS163
// Email:  tmiao@rams.colostate.edu

import java.util.Scanner;

public class P2 {

	public static void main(String[] args) {
		
		double alphaAcid;
		double ounces;
		double weight;
		double lovibond;	
		double volume;
		
		double HBUs;
		double SRM;
		
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Alpha Acid? ");	
		alphaAcid = keyboard.nextDouble();
		
		System.out.print("Ounces? ");
		ounces = keyboard.nextDouble();
				
		HBUs = alphaAcid * ounces;
		
		System.out.printf("The HBUs are %.2f.\n", HBUs);
		
		
		System.out.print("Weight? ");
		weight = keyboard.nextDouble();
		
		System.out.print("Lovibond? ");
		lovibond = keyboard.nextDouble();
		
		System.out.print("Volume? ");
		volume = keyboard.nextDouble();
		
		SRM = (0.3 * weight * lovibond / volume) + 4.7;
		System.out.printf("The SRM value is %.4f.", SRM);
		
		keyboard.close();
		
	}

}
