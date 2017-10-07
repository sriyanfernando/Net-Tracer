import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class Plugin{

	// HashMaps to store data
	static volatile HashMap <String, Integer> mostVisitedSites = new HashMap<>();
	static volatile HashMap <String, Integer> IPsMostReqSent = new HashMap<>();
	static volatile HashMap <String, Double> IPsHighestDataUsage = new HashMap<>();
	static volatile HashMap <String, Integer> topFBUsers = new HashMap<>();
	static volatile HashMap <String, Integer> topYouTubeUsers = new HashMap<>();
	
	public static void main(String [] args){
		CheckDate checkdate = new CheckDate();
		checkdate.currentDate();
		checkdate.nextDate();
		
		try{
			// runs the shell script that monitors the updates of the log file and writes the changes to a text file
			Process p1 = Runtime.getRuntime().exec("sh Shell_Scripts/update.sh");
		}catch(Exception e){}
		
		while(!checkdate.findDateChanged()){
			
			try{
				// runs the shell script that converts the text file to csv and clears the text file
				Process p2 = Runtime.getRuntime().exec("sh Shell_Scripts/convertToCsv.sh");
			}catch(Exception e){}
			
			try{
			BufferedReader br = new BufferedReader(new FileReader("new_req.csv"));
				
				String line;
				
				while (( line = br.readLine()) != null) {	// reads the file line by line
					
					String[] item = line.split(",");  // use comma as the delimiter of each value in a line
					
					String httpRequest = item[5];  	// type of http requst
					String ipAddr = item[2];  		// IP address
			
					double data = new Double(item[4]);  // amount of data consumed on retrieving the object in bytes
					if(data > 0)
						data = data/1000;				// data is converted to KB
					
					String url = item[6];				// url of the requested object
					
					SitesMV smv = new SitesMV(url, httpRequest);
					IPMostReq ipmr = new IPMostReq(ipAddr);
					IPMostDataUsed ipmd = new IPMostDataUsed(ipAddr,data);
					TopYTUsers tfbu = new TopYTUsers(url,ipAddr,httpRequest);
									
					smv.run();				
					ipmr.run();				
					ipmd.run();				
					tfbu.run();

					checkdate.currentDate();
					
				}
				try{
					// runs the shell script that clears the csv file
					Process p3 = Runtime.getRuntime().exec("sh Shell_Scripts/clrCsv.sh");
				}catch(Exception e){}
			
		
		// top ten entries of each HashMap is printed (by the shell script running in the php code these are sent to the report file)
		System.out.println("Most visited sites");
				System.out.println();
				
				SortMapByValue sortHashMapByValue1 = new SortMapByValue(mostVisitedSites);
				sortHashMapByValue1.printValues();
				
				System.out.println();
				
				
				System.out.println("IPs sending most number of requests");	
				System.out.println();
				
				SortMapByValue sortHashMapByValue2 = new SortMapByValue(IPsMostReqSent);
				sortHashMapByValue2.printValues();
				
				System.out.println();
				
				
				System.out.println("IPs used most data");	
				System.out.println();
				
				SortMapByValueD sortHashMapByValueD = new SortMapByValueD(IPsHighestDataUsage);
				sortHashMapByValueD.printValues();
				
				System.out.println();
				
				
				System.out.println("Top You Tube users");
				System.out.println();
				
				SortMapByValue sortHashMapByValue3 = new SortMapByValue(topYouTubeUsers);
				sortHashMapByValue3.printValues();
							
				System.out.println();
				
			
				System.out.println("Top Facebook users");
				System.out.println();
							
				SortMapByValue sortHashMapByValue4 = new SortMapByValue(topFBUsers);
				sortHashMapByValue4.printValues();
				
				try{
					Process p1 = Runtime.getRuntime().exec("sh Shell_Scripts/update.sh");
				}catch(Exception e){}
		}catch(Exception e){
			System.out.println(e);
			System.out.println("Log file not found");
		}
	}

	}
}