public class TopYTUsers{
	
	String IP;
	int noOfReq;
	String urlObj;
	String url;
	String httpReq;
	
	public TopYTUsers(String urlObj, String IP, String httpReq){
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
					
		if(url.equals("https://www.youtube.com")){
		
			if(Plugin.topYouTubeUsers.containsKey(IP)){ 
			
				// if the url is already available, the no of requests is incremented by one
				noOfReq = Plugin.topYouTubeUsers.get(IP); 
				noOfReq++;
				Plugin.topYouTubeUsers.remove(IP);
				
				// if the url is not available, it is added to the HashMap
			}else{
				noOfReq = 1;
			}
			Plugin.topYouTubeUsers.put(IP,noOfReq);
		}
		
	}
	
}