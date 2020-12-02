import java.util.ArrayList;
import java.util.Arrays;
//  Assignment
// Author: Tiffany Miao
// Date:   Apr 24, 2019
// Class:  CS163
// Email:  tmiao@rams.colostate.edu

 
	public class P11 implements IP11 {

	@Override
	public void printPattern(int n) {
		if(n > 0) {
			printPattern(0, n);
		}
		
	}
	private void printPattern(int stars, int stripes) {
		if(stars <= stripes) {
			printStars(stars);
			printStripes(stripes-stars);
			System.out.println();
			printPattern(++stars,stripes);
		}
	}
	private void printStars(int x) {
		if(x > 0) {
			System.out.print("*");
			printStars(--x);
		}
	}
	private void printStripes(int x) {
		if(x > 0) {
			System.out.print("-");
			printStripes(--x);
		}
	}

	@Override
	public int convertNum(int[] num) {
		if(num.length>0) {
           return convertNum(num, 0, num.length-1, 0);
		}
		return 0;
	}
	private int convertNum(int[] num, int atIndex, int lastIndex, int result) {
        if(atIndex<=lastIndex) {
              result=   (int) (((num[atIndex]*Math.pow(10, lastIndex-atIndex)))+convertNum(num,++atIndex,lastIndex,result));

        }
        return result;
			}

	@Override
	public ArrayList<String> intersection(ArrayList<String> AL1, ArrayList<String> AL2) {
		ArrayList<String> empty = new ArrayList<String>();
		if(!AL1.isEmpty() && !AL2.isEmpty()) {
			intersection(AL1, AL2, empty, 0, AL1.size() - 1, 0, AL2.size() - 1);
		}
		return empty;
	}
	private ArrayList<String> intersection(ArrayList<String> AL1, ArrayList<String> AL2, ArrayList<String> resultList, int a1FIndex, int a1LIndex, int a2FIndex, int a2LIndex) {
			if(a1FIndex <= a1LIndex) {
				if(a2FIndex <= a2LIndex) {
				 if(AL1.get(a1FIndex).equals(AL2.get(a2FIndex))) {
                      resultList.add(AL1.get(a1FIndex));
                   }
                    intersection(AL1,AL2,resultList,a1FIndex,a1LIndex,++a2FIndex,a2LIndex);
				} else {
                    intersection(AL1,AL2,resultList,++a1FIndex,a1LIndex,0,a2LIndex);
               }
			}
          return resultList;

 
	}
	public static void main(String[] args) {
		P11 p11 = new P11();
		System.out.println("testing printPattern");
		System.out.println("pattern 5: ");
		p11.printPattern(5);
		System.out.println("\ntesting convertNum");
		int[] num123 = {1, 2, 3};
		System.out.println(Arrays.toString(num123) + ": " + p11.convertNum(num123));
		System.out.println("\ntesting intersection");
		ArrayList<String> AL1 = new ArrayList<String>();
		ArrayList<String> AL2 = new ArrayList<String>();
		AL1.add("a"); AL1.add("b"); AL1.add("c");
		AL2.add("b"); AL2.add("c"); AL2.add("d"); AL2.add("e");
		ArrayList<String> intersect = p11.intersection(AL1,AL2);
		System.out.println(AL1 + "intersect " + AL2 + "= " + intersect);
	}
	}