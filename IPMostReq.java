
public class IPMostReq{
	
	String IP;
	int noOfReq;
	
	public IPMostReq(String IP){
		this.IP = IP;
	}
	
	public void run(){
		if(Plugin.IPsMostReqSent.containsKey(IP)){ 
			
				// if the IP address is already available, the no of requests is incremented by one
				noOfReq = Plugin.IPsMostReqSent.get(IP); 
				noOfReq++;
				Plugin.IPsMostReqSent.remove(IP);
				
				// if the IP address is not available, it is added to the HashMap
			}else{
				noOfReq = 1;
			}
			Plugin.IPsMostReqSent.put(IP,noOfReq);
	}
}
