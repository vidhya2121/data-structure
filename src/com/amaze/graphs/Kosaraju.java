package com.amaze.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Kosaraju {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			// arraylist of arraylist to represent graph
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();

			int vertices = Integer.parseInt(sc.next());
			int edges = Integer.parseInt(sc.next());

			for (int i = 0; i < vertices; i++)
				list.add(i, new ArrayList<Integer>());

			for (int i = 1; i <= edges; i++) {
				int u = Integer.parseInt(sc.next());
				int v = Integer.parseInt(sc.next());

				// adding directed edgese between
				// vertex 'u' and 'v'
				list.get(u).add(v);
			}

			Solution T = new Solution();
			System.out.println(T.kosaraju(list, vertices));
		}
	}
}
/*
 * Given a graph with N nodes and M directed edges. Your task is to complete the function kosaraju() 
 * which returns an integer denoting the number of strongly connected components in the graph.
 */
class Solution {
	public int kosaraju(ArrayList<ArrayList<Integer>> adj, int N) {
		Stack<Integer> stack = new Stack<>();
		boolean visited[] = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (visited[i] != true /*&& adj.get(i).size() != 0*/) {
				fillStack(stack, visited, adj, i);
			}
		}
		ArrayList<ArrayList<Integer>> transposed = transpose(adj, N);
		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}
		int count = 0;
		while (!stack.isEmpty()) {
			int v = stack.pop();
			if (!visited[v] /*&& adj.get(v).size() != 0*/) {
				dfsUtil(v, transposed, N, visited);
				count++;
			}
		}
		return count;

	}

	private ArrayList<ArrayList<Integer>> transpose(ArrayList<ArrayList<Integer>> adj, int n) {
		ArrayList<ArrayList<Integer>> g = new ArrayList<>();
		for (int i = 0; i < n; i++)
			g.add(i, new ArrayList<Integer>());
		for (int v = 0; v < n; v++)
			for (int i = 0; i < adj.get(v).size(); i++)
				g.get(adj.get(v).get(i)).add(v);

		return g;
	}

	private void fillStack(Stack<Integer> stack, boolean[] visited, ArrayList<ArrayList<Integer>> adj, int i) {
		visited[i] = true;
		Iterator<Integer> it = adj.get(i).iterator();
		while (it.hasNext()) {
			int next = it.next();
			if (!visited[next])
				fillStack(stack, visited, adj, next);
		}
		stack.push(i);
	}

	private static void dfsUtil(int i, ArrayList<ArrayList<Integer>> g, int n, boolean[] visited) {

		visited[i] = true;
		Iterator<Integer> it = g.get(i).iterator();
		while (it.hasNext()) {
			int next = it.next();
			if (visited[next] == false) {
				dfsUtil(next, g, n, visited);
			}
		}
	}
}
