package com.amaze.graphs;

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

/*
 * dict : array of strings denoting the words in alien langauge N : Size of the
 * dictionary K : Number of characters
 */
/*
 * Given a sorted dictionary of an alien language having N words and k starting alphabets of standard dictionary. 
 * Find the order of characters in the alien language.
Note: Many orders may be possible for a particular test case, thus you may return any valid order.
 */
/*
 * Input:
		2
		5 4
		baa abcd abca cab cad
		3 3
		caa aaa aab
		
	Output:
		1
		1

Explanation:
Test Case 1:
Input:  Dict[ ] = { "baa", "abcd", "abca", "cab", "cad" }, k = 4
Output: Function returns "bdac"
Here order of characters is 'b', 'd', 'a', 'c'
 */
/*input string array dict
 * initialize graph of size k -> 2d arraylist
 * loop 0 to n - 1
 * 		w1 = dict[i]
 * 		w2 = dict[i+1]
 * 		loop till shorter length
 * 			if char at j of w1 and w2 are nor equal
 * 				graph.get(w1.charAt(j)-'a').add(w2.charAt(j)-'a')
 * 				break
 * do topological sorting and print res
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

	}
}