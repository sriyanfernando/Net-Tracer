import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.*;

public class SortMapByValue {
	
	HashMap<String, Integer> map;
	
	public SortMapByValue(HashMap<String, Integer> map){
		this.map = map;
	}
 
	// prints the first 10 elements of the HashMap
	public void printValues() {
		
		TreeMap<String, Integer> sortedMap = sortMapByValue(map); 
		int count = 1;
		for(Map.Entry<String,Integer> entry : sortedMap.entrySet()) {
			if(count > 10)
				break;
			String key = entry.getKey();
			Integer value = entry.getValue();

			System.out.println(key + "	" + value);
			count++;
		}
		
	}
	
	// sorts the HashMaps by value
	public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map){
		Comparator<String> comparator = new ValueComparator(map); 
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}
}


// defines the comparator
class ValueComparator implements Comparator<String>{
 
	HashMap<String, Integer> map = new HashMap<String, Integer>();
 
	public ValueComparator(HashMap<String, Integer> map){
		this.map.putAll(map);
	}
 
	@Override
	public int compare(String s1, String s2) {
		if(map.get(s1) >= map.get(s2)){
			return -1;
		}else{
			return 1;
		}	
	}
}