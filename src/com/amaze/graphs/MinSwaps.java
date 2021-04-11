package com.amaze.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinSwaps {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			String str[] = br.readLine().trim().split(" ");
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(str[i]);
			}
			System.out.println(new GfGMin().minSwaps(a, n));
		}
	}
}
/*
 * Given an array of integers. Find the minimum number of swaps required to sort the array in non-decreasing order.
 */
/*
 * Input:
	2
	5
	1 5 4 3 2
	4
	8 9 16 15
	
	Output:
	2
	1

Explanation:
Test Case 1: We need two swaps, swap 2 with 5 and 3 with 4 to make it sorted. 
 */
/*
 * create a class with data and index as variable and write a comparator
 * create a temp arraylist and a boolean visited array
 * loop through input and add each element with index in temp array list and sort
 * loop from 0 to N
 * 		if i is visited or temp.get(i).index == i	continue
 * 		j = i and cycle = 0
 * 		loop j not visited
 * 			mark j as visited
 * 			cycle++
 * 			j = temp.get(j).index
 * 		if cycle > 0 add cycle - 1 to ans
 * 		
 */
class Grp {
	int data;
	int index;

	Grp(int data, int index) {
		this.data = data;
		this.index = index;
	}
}

class GrpComparator implements Comparator<Grp> {

	@Override
	public int compare(Grp arg0, Grp arg1) {
		// TODO Auto-generated method stub
		return arg0.data > arg1.data ? 1 : -1;
	}

}

class GfGMin {
	// return the minimum number of swaps required to sort the arra
	public int minSwaps(int[] arr, int N) {
		ArrayList<Grp> sorted = new ArrayList<>();
		boolean visited[] = new boolean[N];
		int ans = 0;
		for (int i = 0; i < N; i++) {
			sorted.add(new Grp(arr[i], i));
		}
		sorted.sort(new GrpComparator());
		for (int i = 0; i < N; i++) {
			if (visited[i] == true || sorted.get(i).index == i)
				continue;
			int j = i;
			int cycle = 0;
			while (!visited[j]) {
				visited[j] = true;
				j = sorted.get(j).index;
				cycle++;
			}
			if (cycle > 0) {
				ans += cycle - 1;
			}
		}
		return ans;

	}

}