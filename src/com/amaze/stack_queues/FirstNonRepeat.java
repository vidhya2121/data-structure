package com.amaze.stack_queues;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
