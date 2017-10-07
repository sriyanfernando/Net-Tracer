import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.*;

public class SortMapByValueD {
	
	HashMap<String, Double> map;
	
	public SortMapByValueD(HashMap<String, Double> map){
		this.map = map;
	}
 
	// prints the first 10 elements of the HashMap
	public void printValues() {
		
		TreeMap<String, Double> sortedMap = sortMapByValue(map); 
		int count = 1;
		for(Map.Entry<String,Double> entry : sortedMap.entrySet()) {
			if(count > 10)
				break;
			String key = entry.getKey();
			Double value = entry.getValue();

			System.out.println(key + "	" + value);
			count++;
		}
		
	}
 
 
	// sorts the HashMaps by value
	public static TreeMap<String, Double> sortMapByValue(HashMap<String, Double> map){
		Comparator<String> comparator = new ValueComparatorD(map); 
		TreeMap<String, Double> result = new TreeMap<String, Double>(comparator);
		result.putAll(map);
		return result;
	}
}

// defines the comparator
class ValueComparatorD implements Comparator<String>{
 
	HashMap<String, Double> map = new HashMap<String, Double>();
 
	public ValueComparatorD(HashMap<String, Double> map){
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