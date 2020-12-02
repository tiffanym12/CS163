//  Assignment
// Author: Tiffany Miao
// Date:   Jan 30, 2019
// Class:  CS163
// Email:  tmiao@rams.colostate.edu

import java.util.Scanner;

public class P3 {
	public static String evaluate(String expression) {

       
        
        System.out.println(expression);

        double operand1;
        double operand2;
        double result = 0.0;
        
        String operator;
    
        
        Scanner scnr = new Scanner(expression);
        if (scnr.hasNextDouble()) {
        	operand1 = scnr.nextDouble();
        } else {
        	scnr.close();
        	return "Invalid Operand!";
        
        }
        
        if (scnr.hasNext()) {
        operator = scnr.next();
        } else {
        	scnr.close();
        	return "Invalid Operator!";
        }
        
        String returnString = "";
        if (scnr.hasNextDouble()) {
        	operand2 = scnr.nextDouble();
        	
        }else {
        	scnr.close();
        	return "Invalid Operand!";
        	
        }
        
        	
        
        switch (operator) {
        case "+" :
        	
        	result = operand1 + operand2;
        	break;
        case "-" :
        	result = operand1 - operand2;
        	break;
        case "*" :
        	result = operand1 * operand2;
        	break;
        case "/" :
        	result = operand1 / operand2;
        	break;
        case "%" :
        	result = operand1 % operand2;
        	break;
        case "^" :
        	result = Math.pow(operand1,  operand2);
        	break;
        default:
        	scnr.close();
        	return "Invalid Operator!";
        	
        
        }
        
        
        scnr.close();	
        returnString = Double.toString(result);
        return returnString;
    }

}
