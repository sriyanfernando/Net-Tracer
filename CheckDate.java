import java.util.*;
import java.text.*;


public class CheckDate{

	static String today, nextDay;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  // defines the format of the date
	Date d = new Date();
	

	// finds today's date and assigns it to today
	public void currentDate(){
		today = sdf.format(d);
	}

	// finds tomorrow's date ans assigns it to nextday
	public void nextDate(){
		try{
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(today));
		c.add(Calendar.DATE, 1);  // number of days to add
		nextDay = sdf.format(c.getTime()); 
		}catch(Exception e){
			System.out.println(e);
		}
	}

	// checks whether the date has been changed
	public boolean findDateChanged(){
		return today.equals(nextDay);
	}

}
