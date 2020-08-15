package com.amaze.stack_queues;

import java.io.*;
import java.util.*;
import java.lang.*;

public class LRUCache {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {

			int capacity = Integer.parseInt(read.readLine());
			int queries = Integer.parseInt(read.readLine());
			LRUCacheSol cache = new LRUCacheSol(capacity);
			String str[] = read.readLine().trim().split(" ");
			int len = str.length;
			int itr = 0;

			for (int i = 0; (i < queries) && (itr < len); i++) {
				String queryType = str[itr++];
				if (queryType.equals("SET")) {
					int key = Integer.parseInt(str[itr++]);
					int value = Integer.parseInt(str[itr++]);
					cache.set(key, value);
				}
				if (queryType.equals("GET")) {
					int key = Integer.parseInt(str[itr++]);
					System.out.print(cache.get(key) + " ");
				}
			}
			System.out.println();
		}
	}
}
/*
 *Input:
		N = 2
		Q = 7
		Queries = SET 1 2 SET 2 3 SET 1 5
		SET 4 5 SET 6 7 GET 4 GET 1
	Output: 5 -1
		Explanation: Cache Size = 2
		SET 1 2 SET 2 3 SET 1 5 SET 4 5
		SET 6 7 GET 4 GET 1
		SET 1 2 : 1 -> 2
		SET 2 3 : 1 -> 2, 2 -> 3 (the most
		recently used one is kept at the
		rightmost position) 
		SET 1 5 : 2 -> 3, 1 -> 5
		SET 4 5 : 1 -> 5, 4 -> 5 (Cache size
		is 2, hence we delete the least
		recently used key-value pair)
		SET 6 7 : 4 -> 5, 6 -> 7 
		GET 4 : Prints 5
		GET 1 : No key-value pair having
		key = 1. Hence prints -1.
 */
/*
 * class with capacity Map and Deque and constructor
 * get method
 * 		if q empty or key not found in map return -1
 * 		remove key from q
 * 		addLast key into q
 * 		return value of key from map
 * set
 * 		if key not in map
 * 			if q is full
 * 				remove from queue also corresponding value from map
 * 		else remove key from queue
 * 		put key val in map
 * 		add key into q
 */
class LRUCacheSol {
	static int capacity;
	static Deque<Integer> q;
	static Map<Integer,Integer> map;

	LRUCacheSol(int cap) {
		this.capacity = cap;
		this.q = new LinkedList<Integer>();
		this.map = new LinkedHashMap<>();
	}

	// This method works in O(1)
	public static int get(int key) {
		if (q.isEmpty() || map.get(key) == null)
			return -1;
		q.remove(key);
		q.addLast(key);
		return map.get(key);
	}

	// This method works in O(1)
	public static void set(int key, int value) {
		if (!map.containsKey(key)) {
			if(q.size() >= capacity) {
				int r = q.remove();
				map.remove(r);
			}
		} else {
			q.remove(key);
		}
		map.put(key,value);
		q.add(key);
	}
}
