//  Assignment
// Author: Tiffany Miao
// Date:   Apr 30, 2019
// Class:  CS163
// Email:  tmiao@rams.colostate.edu

public class R19 implements IR19 {

	@Override
	public int sumDigits(int n) {
		  if (n == 0)
              return 0;
		  else {
              int lastDigit = n % 10;
              return lastDigit + sumDigits(n / 10);
   }
	}

	@Override
	public int countCannonballs(int n) {
		   if (n == 1)
               return 1;
		   else {
               return n * n + countCannonballs(n - 1);
    }
	}

	@Override
	public int numDigits(int n) {
		 if (n < 10)
             return 1;
		 else
             return 1 + numDigits(n / 10);
	}

	@Override
	public String backString(String s) {
		 if (s.length() <= 1)
             return s;
		 else {
             int len = s.length();
             return s.charAt(len - 1) + backString(s.substring(0, len - 1));

  }
	}
	public static void main(String[] args) {

		R19 rec = new R19();
		System.out.println("sumDigits(int x):");
		System.out.println("Answer (1234): " + rec.sumDigits(1234) + "   Expecting: 10");
		System.out.println("Answer (7): " + rec.sumDigits (7) + "   Expecting: 7");
		System.out.println("Answer (6789): " + rec.sumDigits (6789));
		System.out.println();

		System.out.println("countCannonballs (int x):");
		System.out.println("Answer (1): " + rec.countCannonballs(1) + "   Expecting: 1");
		System.out.println("Answer: " + rec.countCannonballs (4) + "   Expecting: 30");
		System.out.println("Answer (10): " + rec.countCannonballs (10));
		System.out.println();
		
		System.out.println("numDigits(int x):");
		System.out.println("Answer (1234): " + rec.numDigits(1234) + "   Expecting: 4");
		System.out.println("Answer (7): " + rec.numDigits (7) + "   Expecting: 1");
		System.out.println("Answer (678900): " + rec.numDigits (678900));
		System.out.println();

		System.out.println("backString(String s):");
		System.out.println("Answer (yes): " + rec.backString("yes"));
		System.out.println("Answer (): " + rec.backString(""));
		System.out.println("Answer (a): " + rec.backString("a"));
		System.out.println("Answer (CS163): " + rec.backString("CS163"));
}

}
