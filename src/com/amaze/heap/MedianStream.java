package com.amaze.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class MedianStream {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Queue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> min_heap = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int e = sc.nextInt();
			max_heap.add(e);
			min_heap.add(max_heap.poll());
			if (max_heap.size() < min_heap.size()) {
				max_heap.add(min_heap.poll());
			}
			if (min_heap.size() == max_heap.size()) {
				System.out.println((max_heap.peek() + min_heap.peek()) / 2);
			} else {
				System.out.println(max_heap.peek());
			}
		}
	}

}
