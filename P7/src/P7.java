import java.util.Arrays;

//  Assignment
// Author: Tiffany Miao
// Date:   Mar 4, 2019
// Class:  CS163
// Email:  tmiao@rams.colostate.edu

public class P7 {

	public static void main(String[] args) {
		// Create arrays
        int[] integerArray = createIntegers();
        System.out.println(Arrays.toString(integerArray));
        double[] doubleArray = createDoubles();
        System.out.println(Arrays.toString(doubleArray));
        String[] stringArray = createStrings("Hello There");
        System.out.println(Arrays.toString(stringArray));
        char[] charArray = createChars("Java1234!&");
        System.out.println(Arrays.toString(charArray));

        // Test processing
        System.out.println("Sum of integer array = " + sumArray(integerArray));
        System.out.println("Largest of double array = " + findLargest(doubleArray));
        System.out.println("Frequency of 'e' = " + charFrequency(stringArray, 'e'));
        System.out.println("Translated characters = " + Arrays.toString(translateChars(charArray)));
	}
		public static int[] createIntegers() {
			int[] integers = {16, 21, 34, 49, 55, 60, 72, 83, 101};
			return integers;
	}
		public static double[] createDoubles() {
			double [] value = new double [7];
			int i=0;
			for (double a= 10.0; a <= 13.0; a= a+0.5) {
				value[i] = a * a;
				i++;
			}
			return value;
	}
		public static String[] createStrings (String s) {
			String [] result = new  String[4];
			result[0] = s;
			result[1] = s.toUpperCase();
			result[2] = s.toLowerCase();
			result[3] = s.substring(0, 0) + s.substring(0 + 1);
			return result;
	}
		public static char[] createChars (String w) {
			char[] res = w.toCharArray();
			return res;
		}
		public static int sumArray (int[] ans) {
			int sum = 0;
			for(int i: ans) {
				sum += i;
			}
			return sum;
		}
		public static double findLargest (double[] lar) {
			double largest = lar[0];
			
			for(int i=1; i<lar.length;i++) {
				if(lar[i] > largest); 
					largest = lar[i];
			}
			return largest;
		}
		public static int charFrequency (String[] str, char c) {
			int count =0;
			for(int i=0; i < str.length;i++) {
				String value = str[i];
				for (int r= 0; r < value.length();r++) {
					if(value.charAt(r) == (c)) {
						count++;
					}
				}
			}
			return count;
		}
		public static int [] translateChars(char[] result) {
		int[] array = new int[result.length];
		for(int i=0; i < result.length;i++) {
			array[i] = result[i];
		}
		return array;
		}
}



