package com.amaze.linked_list;

import java.util.*;
import java.io.*;

class Node {
	int data;
	Node next;

	Node(int x) {
		data = x;
		next = null;
	}

}

class FindMiddle {
	static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			Node head = new Node(sc.nextInt());
			Node tail = head;
			for (int i = 0; i < n - 1; i++) {
				tail.next = new Node(sc.nextInt());
				tail = tail.next;
			}
			Solution g = new Solution();
			int ans = g.getMiddle(head);
			System.out.println(ans);
			// printList(head);
			t--;
		}
	}
}

/*
 * Input:
	2
	5
	1 2 3 4 5
	6
	2 4 6 7 5 1
	
	Output:
	3
	7
 */
/*
 *  set slow and fast as head
 *  loop till fast.next and fast.next.next is not null
 *  	slow -> slow.next
 *  	fast -> fast.next.next
 *  (fast.next will be not null if it is even length)
 *  if fast.next is not null slow -> slow.next
 */
class Solution {
	int getMiddle(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast.next != null) {
			slow = slow.next;
		}
		return slow.data;
	}
}
