package com.amaze.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DetectCycleUndirected {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			int nov = sc.nextInt();
			int edg = sc.nextInt();

			for (int i = 0; i < nov + 1; i++)
				list.add(i, new ArrayList<Integer>());

			for (int i = 1; i <= edg; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				list.get(u).add(v);
				list.get(v).add(u);
			}
			if (new DetectCycle().isCyclic(list, nov) == true)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}// } Driver Code Ends

// User function Template for Java

/*
 * ArrayList<ArrayList<Integer>> g: represent graph containing 'V' number of
 * vertices and edges between them V: represent number of vertices
 */
class DetectCycle {
	static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (isCyclicUtil(adj, visited, i, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int i, int p) {

		visited[i] = true;
		Iterator<Integer> it = adj.get(i).iterator();
		while (it.hasNext()) {
			int next = it.next();
			if (!visited[next]) {
				if (isCyclicUtil(adj, visited, next, i)) {
					return true;
				}
			} 
			else if (next != p)
				return true;

		}
		return false;
	}
}