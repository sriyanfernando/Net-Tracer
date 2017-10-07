
class FilterData{
	
	// retrns the index of nth occurance of a given substring in a source string
	public static int ordinalIndexOf(String str, String substr, int n) {
        int pos = str.indexOf(substr);
        while (--n > 0 && pos != -1)
            pos = str.indexOf(substr, pos + 1);
        return pos;
    }
	
	// retrns the url of the website for GET, POST and OPTIONS requests
	public static String webSiteForGet(String urlObj){
		int index = ordinalIndexOf(urlObj,"/",3);
		return urlObj.substring(0,index);
	}
	
	// retrns the url of the website for a CONNECT request
	public static String webSiteForConnect(String urlObj){
		int index = urlObj.lastIndexOf(":");
		return urlObj.substring(0,index);
	}
	
}