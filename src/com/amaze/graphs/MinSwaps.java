package com.amaze.graphs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MinSwaps {

	// Driver program to test the above function
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
}// } Driver Code Ends

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