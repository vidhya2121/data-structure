package com.amaze.array;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Train {

	public static void main(String[] args) {
		/*
		 * Given arrival and departure times of all trains that reach a railway station. 
		 * Your task is to find the minimum number of platforms required for the railway station so that no train waits.
			Note: Consider that all the trains arrive on the same day and leave on the same day. 
			Also, arrival and departure times will not be same for a train, but we can have arrival time of 
			one train equal to departure of the other. In such cases, we need different platforms, 
			i.e at any given instance of time, same platform can not be used for both departure of a train and arrival of another.
		 */
		/*
		 * Input:
				2
				6 
				0900  0940 0950  1100 1500 1800
				0910 1200 1120 1130 1900 2000
				3
				0900 1100 1235
				1000 1200 1240 
				
			Output:
				3
				1
		 */
		int n = 6;
		String a[] = { "0900", "0940", "0950", "1100", "1500", "1800" };
		String d[] = { "0910", "1200", "1120", "1130", "1900", "2000" };
		int arr[] = new int[a.length];
		int dep[] = new int[d.length];
		/*
		 * convert string array to integer array
		 * initialize platform=1 and no as 0
		 * loop through array and put in tree map with a and d as values
		 * iterate the tree map
		 * 		if value is a increment no and set platform as max(no,platform)
		 * 		else decrement no
		 */
		for(int i=0;i<a.length;i++) {
			arr[i]=Integer.parseInt(a[i]);
			dep[i]=Integer.parseInt(d[i]);
		}
		int count = 0;
		count = minPlatform(arr, dep);
		System.out.println(count);

	}

	private static int minPlatform(int[] a, int[] d) {
		Map<Integer, String> map = new TreeMap<>();
		int platform = 1;
		int no = 0;
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], "a");
			map.put(d[i], "d");
		}
		Iterator<Integer> it = map.keySet().iterator();
		while (it.hasNext()) {
			Integer next = it.next();
			if (map.get(next) == "a") {
				no++;
				platform = Math.max(no, platform);
			} else {
				no--;
			}
		}
		return platform;
	}

}
