package com.amaze.stack_queues;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeat {
/*
 * Input:
	2
	4
	a a b c
	3
	a a c
	
	Output:
	a -1 b b
	a -1 c
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * have input as char array initialize a LinkedHashMap
		 * for each char in char array
		 * 		if char in map
		 * 			put huge value for the key in map
		 * 			iterate map and find first non 100 and add value to res
		 * 			if non of val is not 100 then return -1 (acheive logic thru flag)
		 * 		else
		 * 			iterate map and find first non 100 and add value to res
		 * 			if non of val is not 100 then add current char to res(acheive logic thru flag)
		 * 			put curr char in res with value 1
		 */
		char ch[] = { 'a', 'a','c'};
		firstNonRep(ch, ch.length);

	}

	private static void firstNonRep(char[] ch, int n) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		StringBuilder sb = new StringBuilder();

		for (char c : ch) {
			if (map.containsKey(c)) {
				map.put(c, 100);
				Iterator<Character> it = map.keySet().iterator();
				int flag = 0;
				while (it.hasNext()) {
					char val = it.next();
					if (map.get(val) != 100) {
						sb.append(val + " ");
						flag = 1;
						break;
					}
				}
				if (flag == 0)
					sb.append("-1 ");
			} else {
				Iterator<Character> it = map.keySet().iterator();
				int flag = 0;
				while (it.hasNext()) {
					char val = it.next();
					if (map.get(val) != 100) {
						sb.append(val + " ");
						flag = 1;
						break;
					}
				}
				if (flag == 0)
					sb.append(c + " ");
				map.put(c, 1);
			}
		}
		System.out.println(sb);
	}

}
