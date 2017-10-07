public class TopFBUser{
	
	String IP;
	int noOfReq;
	String urlObj;
	String url;
	String httpReq;
	
	public TopFBUser(String urlObj, String IP, String httpReq){
		this.urlObj = urlObj;
		this.IP = IP;
		this.httpReq = httpReq;
	}
	
	public void run(){
		
		// filters the website according to the http request
		switch(httpReq){
			case "CONNECT" : 
				url = FilterData.webSiteForConnect(urlObj);
				break;
			case "NONE" :  // terminates for error
				return;
			default : 	
				url = FilterData.webSiteForGet(urlObj);
				break;
		}
					
		if(url.equals("https://www.facebook.com")){
		
			if(Plugin.topFBUsers.containsKey(IP)){ 
			
				// if the url is already available, the no of requests is incremented by one
				noOfReq = Plugin.topFBUsers.get(IP); 
				noOfReq++;
				Plugin.topFBUsers.remove(IP);
				
				// if the url is not available, it is added to the HashMap
			}else{
				noOfReq = 1;
			}
			Plugin.topFBUsers.put(IP,noOfReq);
		}
		
	}
	
}