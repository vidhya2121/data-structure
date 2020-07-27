package com.amaze.matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {

	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };
		int ans = rotOranges(arr, arr.length, arr[0].length);
		if (ans == -1)
			System.out.println("All oranges cannot rot");
		else
			System.out.println("Time required for all oranges to rot = " + ans);
	}

	private static int rotOranges(int[][] arr, int r, int c) {
		int overAll = 0;
		Queue<ArrayList<Integer>> q = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (arr[i][j] == 2) {
					ArrayList<Integer> al = new ArrayList<>();
					al.add(i);
					al.add(j);
					q.add(al);
				}
			}
		}
		ArrayList<Integer> all = new ArrayList<>();
		all.add(-1);
		all.add(-1);
		q.add(all);
		while (!q.isEmpty()) {
			if (q.peek().get(0) == -1 && q.peek().get(1) == -1) {
				q.poll();
				if (!q.isEmpty()) {
					overAll += 1;
					ArrayList<Integer> al = new ArrayList<>();
					al.add(-1);
					al.add(-1);
					q.add(al);
					continue;
				} else
					break;
			}
			ArrayList<Integer> temp = q.peek();
			if (isValid(temp.get(0), temp.get(1) + 1, r, c) && arr[temp.get(0)][temp.get(1) + 1] == 1) {
				arr[temp.get(0)][temp.get(1) + 1] = 2;
				ArrayList<Integer> al = new ArrayList<>();
				al.add(temp.get(0));
				al.add(temp.get(1) + 1);
				q.add(al);

			}
			if (isValid(temp.get(0) + 1, temp.get(1), r, c) && arr[temp.get(0) + 1][temp.get(1)] == 1) {
				arr[temp.get(0) + 1][temp.get(1)] = 2;
				ArrayList<Integer> al = new ArrayList<>();
				al.add(temp.get(0) + 1);
				al.add(temp.get(1));
				q.add(al);

			}
			if (isValid(temp.get(0), temp.get(1) - 1, r, c) && arr[temp.get(0)][temp.get(1) - 1] == 1) {
				arr[temp.get(0)][temp.get(1) - 1] = 2;
				ArrayList<Integer> al = new ArrayList<>();
				al.add(temp.get(0));
				al.add(temp.get(1) - 1);
				q.add(al);

			}
			if (isValid(temp.get(0) - 1, temp.get(1), r, c) && arr[temp.get(0) - 1][temp.get(1)] == 1) {
				arr[temp.get(0) - 1][temp.get(1)] = 2;
				ArrayList<Integer> al = new ArrayList<>();
				al.add(temp.get(0) - 1);
				al.add(temp.get(1));
				q.add(al);

			}
			q.poll();

		}
		return check(arr) ? overAll : -1;
	}

	private static boolean check(int[][] arr) {
		for (int i = 0; i < arr.length; i++)
			for (int j = 0; j < arr[0].length; j++)
				if (arr[i][j] == 1)
					return false;
		return true;
	}

	private static boolean isValid(int i, int j, int r, int c) {
		// TODO Auto-generated method stub
		if (i >= 0 && i < r && j >= 0 && j < c)
			return true;
		else
			return false;
	}

}
