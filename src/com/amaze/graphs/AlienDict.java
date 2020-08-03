package com.amaze.graphs;

//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

public class AlienDict {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = Integer.parseInt(sc.next());
		while (t-- > 0) {
			int n = Integer.parseInt(sc.next());
			int k = Integer.parseInt(sc.next());

			String[] words = new String[n];

			for (int i = 0; i < n; i++) {
				words[i] = sc.next();
			}

			Solutionst T = new Solutionst();
			// System.out.println(T.findOrder(words,k));
			String order = T.findOrder(words, n, k);

			String temp[] = new String[n];
			for (int i = 0; i < n; i++)
				temp[i] = words[i];

			Arrays.sort(temp, new Comparator<String>() {

				@Override
				public int compare(String a, String b) {
					int index1 = 0;
					int index2 = 0;
					for (int i = 0; i < Math.min(a.length(), b.length()) && index1 == index2; i++) {
						index1 = order.indexOf(a.charAt(i));
						index2 = order.indexOf(b.charAt(i));
					}

					if (index1 == index2 && a.length() != b.length()) {
						if (a.length() < b.length())
							return 1;
						else
							return 0;
					}

					if (index1 < index2)
						return 1;
					else
						return 0;

				}
			});

			int flag = 1;
			for (int i = 0; i < n; i++) {
				if (!words[i].equals(temp[i])) {
					flag = 0;
					break;
				}
			}

			System.out.println(flag);
		}
	}

}
// } Driver Code Ends

// User function Template for Java

/*
 * dict : array of strings denoting the words in alien langauge N : Size of the
 * dictionary K : Number of characters
 */
class Solutionst {
	public String findOrder(String[] dict, int N, int K) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			graph.add(new ArrayList<>());
		}
		for (int i = 0; i < N - 1; i++) {
			String w1 = dict[i];
			String w2 = dict[i + 1];

			for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
				if (w1.charAt(j) != w2.charAt(j)) {
					graph.get(w1.charAt(j) - 'a').add(w2.charAt(j) - 'a');
					break;
				}
			}
		}
		int res[] = new Graph1().topoSort(graph, K);
		StringBuffer str = new StringBuffer();
		for(int i=0;i<res.length;i++) {
			str.append((char)(res[i]+'a'));
		}
		return str.toString();
		// Write your code here

	}
}