package com.amaze.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			int nov = sc.nextInt();
			int edg = sc.nextInt();
			for (int i = 0; i < nov; i++)
				list.add(i, new ArrayList<Integer>());

			for (int i = 1; i <= edg; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				list.get(u).add(v);
				list.get(v).add(u);
			}

			ArrayList<Integer> res = new Traversal2().dfs(list, nov);
			for (int i = 0; i < res.size(); i++)
				System.out.print(res.get(i) + " ");
			System.out.println();
		}
	}
}

// } Driver Code Ends

// User function Template for Java

/*
 * g : adjacency list of graph N : number of vertices
 * 
 * return a list containing the DFS traversal of the given graph
 */

class Traversal2 {
	static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> g, int N) {
		ArrayList<Integer> res = new ArrayList<>();
		boolean visited[] = new boolean[N];
		return dfsUtil(0,g,N,visited,res);
		
	}

	private static ArrayList<Integer> dfsUtil(int i, ArrayList<ArrayList<Integer>> g, int n, boolean[] visited, ArrayList<Integer> res) {
		
		visited[i] = true;
		res.add(i);
		Iterator<Integer> it = g.get(i).iterator();
		while (it.hasNext()) {
			int next = it.next();
			if (visited[next] == false) {
				dfsUtil(next,g,n,visited, res);
			}
		}
		return res;
	}
}
