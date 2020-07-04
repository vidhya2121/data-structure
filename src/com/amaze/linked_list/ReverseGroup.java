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
