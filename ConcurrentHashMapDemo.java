
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* * 
 * Java Program to print all key-value pairs of ConcurrentHashMap 
 * There are multiple ways to do this e.g. by using keySet(), entrySet() 
 * in combination of for loop and iterator. 
 */

public class ConcurrentHashMapDemo{
	
	public static void main(String...args){
		Map<String, Integer> map 
				= new ConcurrentHashMap<>();
		map.put("Kindle", 99);
		map.put("Samsung tablet", 99);
		map.put("iPad", 99);
		map.put("iPad Mini", 600);
		
		//printing all keys of ConcurrentHashMap
		
		System.out.println("All keys of ConcurrentHashMap");
		for(Map.Entry<String, Integer> entry : map.entrySet()){
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("Key : "+key+", Value : "+value);
		}
		
		//you can also use Iterator with EntrySet as shown below
		Set<Map.Entry<String, Integer>> entrySet = 
				map.entrySet();
		Iterator<Map.Entry<String, Integer>> iterator
				= entrySet.iterator();
		while(iterator.hasNext()){
			Map.Entry<String, Integer> entry 
					= iterator.next();
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println("Key : "+key+" , Value : "+value);
		}
	}
}