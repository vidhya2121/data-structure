package com.amaze.heap;

import java.util.*;

class Node {
	int data;
	Node next;

	Node(int key) {
		data = key;
		next = null;
	}
}

public class SortKsortedLL {
	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t-- > 0) {
			int N = sc.nextInt();

			Node[] a = new Node[N];

			for (int i = 0; i < N; i++) {
				int n = sc.nextInt();

				Node head = new Node(sc.nextInt());
				Node tail = head;

				for (int j = 0; j < n - 1; j++) {
					tail.next = new Node(sc.nextInt());
					tail = tail.next;
				}

				a[i] = head;
			}

			Merge g = new Merge();

			Node res = g.mergeKList(a, N);
			if (res != null)
				printList(res);
			System.out.println();
		}
	}
}

/*
 * Input:
K = 4
value = {{1,2,3},{4 5},{5 6},{7,8}}
Output: 1 2 3 4 5 5 6 7 8
 */
/*
 * write comparator for node class and set a pq for this
 * have head and tail as null
 * loop 0  to no of linkedlist
 * 		add each ll head to pq
 * loop pq not empty
 * 		temp = poll from pq
 * 		if temp.next is not null add temp.next to pq
 * 		if head is null set both head and tail to temp
 * 			else tail.next = temp; tail = temp
 */
class Merge {

	public Node mergeKList(Node[] a, int n) {
		PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());
		Node head = null, tail = null;
		for (int i = 0; i < n; i++) {
			if (a[i] != null)
				pq.add(a[i]);
		}
		while (!pq.isEmpty()) {
			Node temp = pq.peek();
			pq.remove();
			if (temp.next != null) {
				pq.add(temp.next);
			}
			if (head == null) {
				head = temp;
				tail = temp;
			} else {
				tail.next = temp;
				tail = temp;
			}
		}
		return head;
	}

}

class NodeComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		return o1.data - o2.data;
	}

}
