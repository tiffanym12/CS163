import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Scanner;
//Tiffany Miao
//CS 163
//ffelix1@rams.colostate.edu
public class P10 implements Interface{

	public static void main(String[] args) {
	   
	    P10 p10 = new P10();
	    
	    Temperature[] data = p10.readTemperatures("Temperatures.txt");
	    
	
	    Date start = Temperature.createDate( "04-Jul-2008" ,  "06:00" );
	    Date end = Temperature.createDate( "17-Aug-2010" ,  "23:00" );
	    
	    //print
	    System.out.println( "Verifying findMinimum method: " );
	    System.out.println( "Start date:  " + start.toString() );
	    System.out.println( "End date: " + end.toString());
	    System.out.printf( "Minimum = %.1f degrees\n" , p10.findMinimum( start , end , data ));

	    start = Temperature.createDate("19-Sep-2011", "07:00");
	    end = Temperature.createDate("23-Mar-2015", "13:00");
	    
	    //print
	    System.out.println("Verifying findMaximum method:");
	    System.out.println("Start date: " + start.toString());
	    System.out.println("End date: " + end.toString());
	    System.out.printf("Maximum = %.1f degrees\n", p10.findMaximum(start, end, data));

	    start = Temperature.createDate("09-Apr-2006", "19:00");
	    end = Temperature.createDate("31-Oct-2013", "10:00");
	    
	   //print
	    System.out.println("Verifying findAverage method:");
	    System.out.println("Start date: " + start.toString());
	    System.out.println("End date: " + end.toString());
	    System.out.printf("Average = %.1f degrees\n", p10.findAverage(start, end, data));

	    start = Temperature.createDate("01-Jan-2015", "00:00");
	    end = Temperature.createDate("31-Dec-2015", "23:00");
	    
	    //print
	    System.out.println("Verifying findHighest method:");
	    System.out.println("Start date: " + start.toString());
	    System.out.println("End date: " + end.toString());
	    System.out.printf("Highest windspeed = %.1f\n", p10.findHighest(start, end, data));
	}

	@Override
	public Temperature[] readTemperatures(String filename) {

		try {
			
			Scanner scan = new Scanner (new File(filename));
			Temperature[] array = new Temperature[scan.nextInt()];
			
			for (int i = 0; i < array.length; i++) {
				Temperature r = new Temperature(scan.next(), scan.next(), scan.nextDouble(), scan.nextDouble());
				array[i] = r;
			}
			
			return array;
			
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public double findMinimum (Date start , Date end , Temperature[] data ) {
		
		double min=Double.MAX_VALUE;
		int i=0,j=0;
		while(!start.equals(data[i].date))
		i++;//get starting index
		while(!end.equals(data[j].date))
		j++;
		for(;i<=j;i++)
		{
		if(data[i].temperature<min)
		min=data[i].temperature;
		}
		  
		return min;
	}

	@Override
	public double findMaximum(Date start, Date end, Temperature[] data) {
		
		double m = Double.MIN_VALUE;
		
		for (int i = 0; i < data.length; i++) {
		if (data[i].inInterval ( start , end ) == true) {
			if (data[i].temperature > m ) {
				m = data[i].temperature;
			}
		}
		} 
		return m;
	}

	@Override
	public double findAverage(Date start, Date end, Temperature[] data) {
		
		double sum = 0.0;
		int d = 0;
		
		for (int i = 0; i < data.length; i++) {
		if (data[i].inInterval(start, end) == true) {
			sum += data[i].temperature;
			d++;
		}
		} 
		return (sum / d);
	}

	@Override
	public double findHighest( Date start , Date end , Temperature[] data ) {
		
		double m = Double.MIN_VALUE;
		
		for (int i = 0; i < data.length; i++) {
		if (data[i].inInterval( start , end ) == true) {
			if (data[i].windspeed > m) {
				m = data[i].windspeed;
			}
		}
		} 
		return m;
	}

}