/*Write a program to sort a map by value.*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class SortMapOnValue {
    
	public List<Entry<String, Integer>> getSortedMap(Map<String, Integer> map){
		
		Set<Entry<String, Integer>> set = map.entrySet();
		List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
				
				return (o1.getValue()).compareTo(o2.getValue());
				
			}
		});
		
		return list;
	}
	
    public static void main(String a[]){
		SortMapOnValue sortMapOnValue = new SortMapOnValue();
         Map<String, Integer> map = new HashMap<String, Integer>();
		 map.put("a", 9);
		 map.put("c", 19);
		 map.put("v", 30);
		 map.put("x", 2);
		 map.put("q", 0);
		 map.put("r", 4);
		 map.put("p", 1);
		 List<Entry<String, Integer>> list = sortMapOnValue.getSortedMap(map);
		 for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }
    }
}
