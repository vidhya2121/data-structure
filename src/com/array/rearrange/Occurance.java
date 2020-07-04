package com.array.rearrange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class Occurance {

	public static void main(String[] args) {

//		arr[] = {3, 1, 4, 4, 5, 2, 6, 1}, 
//				k = 2
//				Output: 4 1
//				Explanation:
//				Frequency of 4 = 2
//				Frequency of 1 = 2
//				These two have the maximum frequency and
//				4 is larger than 1.
		
		int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
		int k = 3;
		
		HashMap<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(map.get(arr[i])==null) {
				map.put(arr[i], 1);
			} else {
				map.put(arr[i], map.get(arr[i])+1);
			}
		}
		System.out.println(map);
		
		sortHashMap(map);
		
		
	}
	
	public static void sortHashMap(HashMap<Integer,Integer> map) {
		List<Integer> keys = new ArrayList<>(map.keySet());
		List<Integer> values = new ArrayList<>(map.values());
		
		Comparator<Integer> comp = Collections.reverseOrder();
		
		Collections.sort(keys, comp);
		Collections.sort(values, comp);
		
		System.out.println(keys);
		System.out.println(values);
		
		Iterator<Integer> valueIt = values.iterator();
		LinkedHashMap<Integer,Integer> lhmap = new LinkedHashMap<>();
		while(valueIt.hasNext()) {
			Integer val = valueIt.next();
			
			Iterator<Integer> keyIt = keys.iterator();
			while(keyIt.hasNext()) {
				Integer key = keyIt.next();
				Integer fromOriginal = map.get(key);
				
				if( val == fromOriginal) {
					keyIt.remove();
					lhmap.put(key, val);
					break;
				}
			}
		}
		System.out.println(lhmap);
	}

}
