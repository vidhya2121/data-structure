package com.amaze.linked_list;

import java.util.*;

public class NthFromEnd {
	Node head;
	Node tail;

	/* Function to print linked list */
	void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Inserts a new Node at front of the list. */
	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			NthFromEnd llist = new NthFromEnd();
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}

			Nth g = new Nth();
			System.out.println(g.getNthFromLast(llist.head, k));

			t--;
		}
	}
}
/*
 * Input:
	L = 9, N = 2
	value[] = {1,2,3,4,5,6,7,8,9}
	Output: 8
 */
/*
 * have slow and fast
 * move fast n times
 * loop till fast!=null
 * 		slow->slow.next fast->fast.next
 * return slow.data
 */
class Nth {
	int getNthFromLast(Node head, int n) {
		Node slow = head;
		Node fast = head;
		for (int i = 0; i < n; i++) {
			if (fast == null)
				return -1;
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow.data;
	}
}
