import java.util.Scanner;

// P5 Assignment
// Author: Tiffany Miao
// Date:   Feb 13, 2019
// Class:  CS163
// Email:  tmiao@rams.colostate.edu

public class P5 {

	public static void main(String[] args) {
		 printPrimes(1, 50);
		    System.out.println(removeVowels("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
		    double result = evaluateExponent(2.0,16);
		    System.out.println("2.0 to the 16 = " + result);
		    computeStatistics(-1);
	
	}
		// Method to check whether an integer is prime.
		public static boolean isPrime(int number) {

		    // DO NOT CHANGE THIS CODE!
		    for(int i=2;i<=number/2;i++)
		        if(number%i==0)
		            return false;
		    return true;
		}

		// Method to print primes in a specified range
		public static void printPrimes(int start, int end) {
		    for(int i = start; i <= end;i++) {
		    	if(isPrime(i)) {
		    		System.out.print(i+ ", ");
		    	}
		    }
		    System.out.println();
		    
		}

		// Method to remove vowels from a string
		public static String removeVowels(String input) {
		    String returnVal = "";
		    String in = input.toLowerCase();
		    
		    for(int i= 0; i < in.length();++i) {
		    	if(in.charAt(i) != 'a' && in.charAt(i) != 'e' &&
		    		in.charAt(i) != 'i' && in.charAt(i) != 'o' && in.charAt(i) != 'u') {
		  		
		    	returnVal = returnVal + input.charAt(i); 
		    	}
		    }
		    return returnVal;
		}

		// Method to generate and print the value of a number raised to an exponent
		public static double evaluateExponent(double number, int exponent) {
		    double result = 1.0;
		    
		    if(exponent == 0) {
		    	return result;
		    }
		    
		    int loop =1;
		    do {
		    	result = result * number;
		    	loop++;
		    } while (loop <= exponent);
			return result;

		    }



		// Method to find and print the minimum/maximum/mean of a set of positive numbers
		public static void computeStatistics(int sentinel) {
		    Scanner keyboard = new Scanner (System.in);
		    int value = 0;
		    int count = 0;
		    double mean = 0;
		    int min = Integer.MAX_VALUE;
		    int max = Integer.MIN_VALUE;
		    
		    while(true) {
		    	value = keyboard.nextInt();
		    	if(value == sentinel) 
		    		break;
		    	++count;
		    	if (value < min) 
		    		min = value;
		        if (value > max) 
		    		max = value;
		    	
		    	mean = mean + value;
		   
		    }

		    
		    System.out.println("Count: " + count);
		    System.out.println("Average: " + mean/count);
		    System.out.println("Maximum: " + max);
		    System.out.println("Minimum: " + min);
		
		    keyboard.close();
		}


}
