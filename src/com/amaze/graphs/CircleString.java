package com.amaze.graphs;

import java.util.ArrayList;

public class CircleString {

	public static void main(String[] args) {
/*
 * Given an array of strings A[], determine if the strings can be chained together to form a circle. A
string X can be chained together with another string Y if the last character of X is same as first
character of Y. If every string of the array can be chained, it will form a circle.

For eg for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf"


 */
		String arr[] = { "ab","bc","cd","da" };
		findCircle(arr, arr.length);
	}
/*
 * Solve this using kosaraju
 * The idea is to create a directed graph of all characters and then find if their is an eulerian circuit in the graph or not.
 *   If there is an eulerian circuit, then chain can be formed, otherwise not.
Note:  directed graph has eulerian circuit only if in degree and out degree of every vertex is same, 
and all non-zero degree vertices form a single strongly connected component.
 */
	/*
	 * input -> string array
	 * findCircle function
	 * 		initialize 2d arraylist of size 26 and an indegree array of size 26
	 * 		loop 0 to n
	 * 			letter1 = arr[i].charAt(0) - 97
	 * 			letter2 = arr[i].charAt(arr.length()-1) - 97
	 * 			grqph.get(letter1).add(letter2)
	 * 			inDegree[letter2++]
	 * 		call eulerian
	 * isEulerian
	 * 		if kosaraju not 1 return false
	 * 		loop 0 to 26 
	 * 			if indegreee != outdegree return false
	 * 		return true
	 */
	private static void findCircle(String[] arr, int n) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		int inDegree[] = new int[26];
		for (int i = 0; i < 26; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < n; i++) {
			int letter1 = arr[i].charAt(0) - 97;
			int letter2 = arr[i].charAt(arr[i].length() - 1) - 97;
			graph.get(letter1).add(letter2);
			inDegree[letter2]++;
		}
		System.out.println(isEulerian(arr, n, graph, inDegree));
	}

	private static boolean isEulerian(String[] arr, int n, ArrayList<ArrayList<Integer>> graph, int[] inDegree) {
		if (new Solution().kosaraju(graph, 26) != 1) {
			return false;
		}
		for (int i = 0; i < 26; i++) {
			if (graph.get(i).size() != inDegree[i]) {
				return false;
			}
		}
		return true;
	}

}
