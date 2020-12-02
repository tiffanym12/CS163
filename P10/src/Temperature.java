// Temperature.java: Class for Temperature Analysis
// Author: Tiffany Miao
// Date:   
// Class:  CS163/CS164
// Email:  tmiao@rams.colostate.edu

import java.text.SimpleDateFormat;
import java.util.Date;

public class Temperature {

    // Instance data
    public Date date;
    public double temperature;
    public double windspeed;
    
        public Temperature(String dayMonthYear, String hour, double degrees, double speed) {
        windspeed = speed;
        temperature = degrees;
        date = createDate(dayMonthYear,hour);
        }
        
        
        public static Date createDate(String date, String hour) {
    		Date returnDate = null;
    		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
    		String stringDate = date + " " + hour;
    		
    		try {
    			returnDate = formatter.parse(stringDate);
    		} 
    		catch (Exception e) {
    			System.out.println("Invalid format: "  +  stringDate);
    		}
    		
    		return returnDate;
        }

        public boolean inInterval(Date start, Date end) {
        	if ( (date.compareTo( start ) == 0 || date.compareTo( start ) > 0) && (date.compareTo( end ) == 0 || date.compareTo( end ) < 0)) {
        		return true;
        	}
        		
        	return false;
        }
    }
