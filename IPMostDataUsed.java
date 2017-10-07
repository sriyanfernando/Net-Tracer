public class IPMostDataUsed{
	
	String IP;
	double dataUsed;
	double totalData;
	
	public IPMostDataUsed(String IP, double dataUsed){
		this.IP = IP;
		this.dataUsed = dataUsed;
	}
	
	public void run(){
		if(Plugin.IPsHighestDataUsage.containsKey(IP)){ 
			
				// if the IP address is already available, the no of requests is incremented by one
				totalData = Plugin.IPsHighestDataUsage.get(IP); 
				totalData = totalData + dataUsed;
				Plugin.IPsHighestDataUsage.remove(IP);
				
				// if the IP address is not available, it is added to the HashMap
			}else{
				totalData = dataUsed;
			}
			Plugin.IPsHighestDataUsage.put(IP,totalData);
	}
	
}