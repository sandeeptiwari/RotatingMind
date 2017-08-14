package com.test.teggig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TripPlanner {
	
	public static void main(String... args){
		
	}
	
	public boolean  getTripGroup(int input, String val){
		boolean isTrip = false;
		List<Key> keys = new ArrayList<Key>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		String value1 = val.replace("(","").replace(")", "").replace("{", "").replace("}", "");
		String arr[] = value1.split(",");
		int len = arr.length;
		for (int index = 0; index < arr.length; index = index+2) {
			int key = Integer.parseInt(arr[index]);
			int value = Integer.parseInt(arr[index + 1]);
			
				if(map.containsKey(key)){
					List<Integer> setD = map.get(key);
					setD.add(value);
				}else{
					List<Integer> set = new ArrayList<Integer>();
					set.add(value);
					map.put(key, set);
					Key mKey = new Key();
					keys.add(mKey);
				}
		}
		
		int length = keys.size();
		for (int i = 0; i < length; i++) {
			//int currentKey = keys.get(i);
			
			for (int j = i + 1; j < length; j++) {
				/*//int keyValue = keys.get(j);
				if(map.get(keyValue).contains(currentKey)){
					isTrip = true;
				}
				else{
					isTrip = false;
				}*/
			}
		}
		
		return isTrip;
	}
	
	public class Key{
		int current;
		int prev;
		public int getCurrent() {
			return current;
		}
		public void setCurrent(int current) {
			this.current = current;
		}
		public int getPrev() {
			return prev;
		}
		public void setPrev(int prev) {
			this.prev = prev;
		}
		
	}

}
