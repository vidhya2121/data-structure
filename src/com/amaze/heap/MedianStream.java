package com.amaze.heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
/*
 * Given an input stream of N integers. The task is to insert these numbers 
 * into a new stream and find the median of the stream formed by each insertion of X to the new stream.
 */
/*
 * Input:
		4
		5
		15
		1 
		3
	Output:
		5
		10
		5
		4
 */
/*
 * 
 */
public class MedianStream {
/*
 * have minheap and maxheap
 * loop 0 to n
 * 		get element from scanner
 * 		add element to maxheap
 * 		remove first from maxheap and add it to minheap
 * 		if maxheap size is less thn minheap size
 * 			remove first from minheap and add to maxheap
 * 		if both heaps are equal in size
 * 			sysout add both peek /2
 * 		else 	
 * 			sysout peek of maxheap
 */
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
