package com.amaze.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			String s1 = sc.next();
			String s2 = sc.next();
			System.out.println(areAnagram(s1, s2));
			// System.out.println(anagram(s1, s2));
		}
	}

	private static String areAnagram(String s1, String s2) {
		if (s1.length() != s2.length())
			return "NO";
		int count[] = new int[256];
		Arrays.fill(count,0);
		for(int i=0;i<s1.length();i++) {
			count[s1.charAt(i)]++;
			count[s2.charAt(i)]--;
		}
		for(int i=0;i<256;i++) {
			if(count[i]!=0) {
				return "NO";
			}
		}
		return "YES";
	}

	private static String anagram(String s1, String s2) {
		Map<Character, Integer> m1 = getChMap(s1);
		Map<Character, Integer> m2 = getChMap(s2);
		if (m1.size() != m2.size()) {
			return "NO";
		}
		Iterator<Character> it = m1.keySet().iterator();
		while (it.hasNext()) {
			char key = it.next();
			if (m1.get(key) != m2.get(key)) {
				return "NO";
			}
		}
		return "YES";
	}

	private static Map<Character, Integer> getChMap(String s1) {
		Map<Character, Integer> charMap = new HashMap<>();
		for (char ch : s1.toCharArray()) {
			if (charMap.containsKey(ch)) {
				charMap.put(ch, charMap.get(ch) + 1);
			} else {
				charMap.put(ch, 1);
			}
		}
		return charMap;
	}

}
