
public class SitesMV{
	
	String urlObj;  // full address of the requested object
	int reqToUrl;	// no of requests sent to the site
	String httpReq;	// http request type, GET or CONNECT
	
	String url;
	
	public SitesMV(String urlObj, String httpReq){ // constructor
		this.urlObj = urlObj;
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
		//synchronized(Plugin.mostVisitedSites){
			
			if(Plugin.mostVisitedSites.containsKey(url)){ 
			
				// if the url is already available, the no of requests is incremented by one
				reqToUrl = Plugin.mostVisitedSites.get(url); 
				reqToUrl++;
				Plugin.mostVisitedSites.remove(url);
				
				// if the url is not available, it is added to the HashMap
			}else{
				reqToUrl = 1;
			}
			Plugin.mostVisitedSites.put(url,reqToUrl);
		//}
	}
	
}