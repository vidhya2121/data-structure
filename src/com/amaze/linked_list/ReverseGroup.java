package com.amaze.linked_list;

import java.util.*;
import java.lang.*;

class ReverseGroup {
	static Node head;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			Node tail = head;
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				// addToTheLast(new Node(a));
				tail.next = new Node(a);
				tail = tail.next;
			}

			int k = sc.nextInt();
			GfG gfg = new GfG();
			Node res = gfg.reverse(head, k);
			printList(res);
			System.out.println();
		}
	}

	public static void printList(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

}
/*
 * Input:
		2
		8
		1 2 2 4 5 6 7 8
		4
		5
		1 2 3 4 5
		3
		
	Output:
		4 2 2 1 8 7 6 5
		3 2 1 5 4
 */

/*
 * solution includes both loop and recursion
 * prev=null curr=head next=null
 * loop till curr != null and i < k
 * 		next = curr.next
 * 		curr.next = prev
 * 		prev = curr
 *		curr = next
 * if curr is not null
 * 		node.next -> reverse(next, k )
 * return prev
 * 		
 */

class GfG {
	public static Node reverse(Node node, int k) {
		
		Node curr = node;
		Node prev = null;
		Node next = null;
		int i = 0;
		while(curr != null && i < k) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			i++;
		}
		
		if (curr != null) {
			node.next = reverse(next, k);
		}
		
		return prev;
		// Your code here
	}
}
