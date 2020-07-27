package com.amaze.matrix;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PrintSorted {

	public static void main(String args[]) {
		int mat[][] = { { 100, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 5 } };
		printSorted(mat);
	}

	private static void printSorted(int[][] mat) {
		int r = mat.length;
		int c = mat[0].length;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0;i<r;i++) {
			for(int j=0;j<c;j++) {
				pq.offer(mat[i][j]);
			}
		}
		
		while(!pq.isEmpty()) {
			System.out.print(pq.poll() + " ");
		}
	}

}
