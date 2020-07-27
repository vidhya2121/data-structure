package com.amaze.heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthSmallest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		 System.out.println(k + " " + n);
		 System.out.println(Arrays.toString(a));

		kthMax(k, n, a);
	}

	private static void kthMax(int k, int n, int[] a) {
		PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
		int i = 0;
		for (i = 0; i < k - 1; i++) {
			min.add(a[i]);
			System.out.print(-1 + " ");
		}
		min.add(a[i]);
		System.out.print(min.peek() + " ");
		for (i = k; i < n; i++) {
			if(a[i] < min.peek()) {
				min.poll();
				min.add(a[i]);
			}
			System.out.print(min.peek() + " ");
		}
	}

}
