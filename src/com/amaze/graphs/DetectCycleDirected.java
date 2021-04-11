package com.amaze.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DetectCycleDirected {

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
			}
			if (new Cycle().isCyclic(list, nov) == true)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}
/*
 * have boolean visited array and also a boolean isInRecursionStack array
 * loop 0 to V
 * 		if cyclicUtil(adj, visited, isInRecursionStack,i) is true
 * 			return true
 * return false
 * cyclicUtil
 * 		if isInRecursionStack[i] is true
 * 			return true
 * 		mark both visited and isInRecursionStack as true for i
 * 		loop for ith list
 * 			if visited[next] == false
 * 				if cyclicUtil(adj, visited, isInRecursionStack, next) is true
 * 					return true
 * 		mark isInRecursionStack[i] as false// at this point the element comes out of rec stack
 * 		return false
 */
class Cycle {
	static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, int V) {
		boolean visited[] = new boolean[V];
		boolean recStack[] = new boolean[V];
		for (int i = 0; i < V; i++) {

			if (isCyclicUtil(adj, visited, recStack, i)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCyclicUtil(ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] recStack,
			int i) {
		if (recStack[i] == true) {
			return true;
		}
//		if (visited[i]) {
//			return false;
//		}
		visited[i] = true;
		recStack[i] = true;
		Iterator<Integer> it = adj.get(i).iterator();
		while (it.hasNext()) {
			int next = it.next();
			if (isCyclicUtil(adj, visited, recStack, next)) {
				return true;
			}
		}
		recStack[i] = false;
		return false;
	}
}