package com.stack_queues;

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
// } Driver Code Ends

// design the class in the most optimal way

class LRUCacheSol {
	static int capacity;
	static Deque<Integer> q;
	static Map<Integer,Integer> map;

	LRUCacheSol(int cap) {
		this.capacity = cap;
		// Intialize the cache capacity with the given
		// cap
		this.q = new LinkedList<Integer>();
		this.map = new LinkedHashMap<>();
	}

	// This method works in O(1)
	public static int get(int key) {
		// your code here
		if (q.isEmpty() || map.get(key) == null)
			return -1;
		q.remove(key);
		q.addLast(key);
		return map.get(key);
	}

	// This method works in O(1)
	public static void set(int key, int value) {
		// your code here
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
