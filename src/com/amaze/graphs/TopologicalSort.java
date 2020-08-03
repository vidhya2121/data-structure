package com.amaze.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			String st[] = read.readLine().trim().split("\\s+");
			int edg = Integer.parseInt(st[0]);
			int nov = Integer.parseInt(st[1]);

			for (int i = 0; i < nov + 1; i++)
				list.add(i, new ArrayList<Integer>());

			String s[] = read.readLine().trim().split("\\s+");
			int p = 0;
			for (int i = 1; i <= edg; i++) {
				int u = Integer.parseInt(s[p++]);
				int v = Integer.parseInt(s[p++]);
				list.get(u).add(v);
			}

			int[] res = new Graph1().topoSort(list, nov);

			if (check(list, nov, res) == true)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}

	static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
		int[] map = new int[V];
		for (int i = 0; i < V; i++) {
			map[res[i]] = i;
		}
		for (int i = 0; i < V; i++) {
			for (int v : list.get(i)) {
				if (map[i] > map[v])
					return false;
			}
		}
		return true;
	}
}
// } Driver Code Ends

/* Complete the function below */

/*
 * ArrayList<ArrayList<>Integer>adj: to represent graph containing 'N' vertices
 * and edges between them N: represent number of vertices
 */
class Graph1 {
	public static int[] topoSort(ArrayList<ArrayList<Integer>> adj, int N) {
		int[] res = new int[N];
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				topSortUtil(i, adj, stack, visited);
			}
		}
		int i = 0;
		while (!stack.empty()) {
			res[i] = stack.pop();
			i++;
		}
//		System.out.println(Arrays.toString(res));
		return res;
		// add your code here
	}

	private static void topSortUtil(int i, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack, boolean[] visited) {
		visited[i] = true;
		Iterator<Integer> it = adj.get(i).iterator();
		while (it.hasNext()) {
			int next = it.next();
			if (!visited[next]) {
				topSortUtil(next, adj, stack, visited);
			}
		}
		stack.push(i);
	}
}
