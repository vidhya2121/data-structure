package com.amaze.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

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
			}
			ArrayList<Integer> res = new Traversal().bfs(list, nov);
			for (int i = 0; i < res.size(); i++)
				System.out.print(res.get(i) + " ");
			System.out.println();
		}
	}
}
/*
 * have a arraylist for result, visited boolea array and a queue
 * mark visited[0] as true and add to queue
 * while q is not empty
 * 		curr = poll from q
 * 		add curr to res
 * 		iterate thro curr in list
 * 			if visited[next] == false
 * 				make visited as true and add next to q
 * return res
 */
class Traversal {
	static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> g, int N) {
		ArrayList<Integer> res = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[N];
		int firstNode = 0;
		visited[firstNode] = true;
		q.add(firstNode);
		while (!q.isEmpty()) {
			int curr = q.poll();
			res.add(curr);
			Iterator<Integer> it = g.get(curr).iterator();
			while (it.hasNext()) {
				int next = it.next();
				if (visited[next] == false) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		return res;
	}
}
