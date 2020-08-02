package com.amaze.graphs;

import java.util.ArrayList;

public class CircleString {

	public static void main(String[] args) {

		String arr[] = { "ab","bc","cd","da" };
		findCircle(arr, arr.length);
	}

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
