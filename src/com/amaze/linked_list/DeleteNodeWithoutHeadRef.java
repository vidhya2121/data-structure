package com.amaze.linked_list;

import java.util.*;

public class DeleteNodeWithoutHeadRef {

	Node head;
	Node tail;

	void printList(Node head) {
		Node tnode = head;
		while (tnode != null) {
			System.out.print(tnode.data + " ");
			tnode = tnode.next;
		}
		System.out.println();
	}

	void addToTheLast(Node node) {

		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	Node search_Node(Node head, int k) {
		Node current = head;
		while (current != null) {
			if (current.data == k)
				break;
			current = current.next;
		}
		return current;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			DeleteNodeWithoutHeadRef llist = new DeleteNodeWithoutHeadRef();
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new Node(a));
			}

			int k = sc.nextInt();
			Node del = llist.search_Node(llist.head, k);

			Del g = new Del();
			if (del != null && del.next != null) {
				g.deleteNode(del);
			}
			llist.printList(llist.head);
			t--;
		}
	}
}
/*
 * Input:
	N = 4
	value[] = {10,20,4,30}
	node = 20
	Output: 10 4 30
 */
// This function should delete node from linked list. The function
// may assume that node exists in linked list and is not last node
// node: reference to the node which is to be deleted
/*
 * just get the node to be deleted and swap with next node
 * set del as node swap as node.next
 * swap swap.data and del.data
 * set del.next as swap.next
 */
class Del {
	void deleteNode(Node node) {
		Node del = node;
		Node swap = node.next;
		int t = swap.data;
		swap.data = del.data;
		del.data = t;
		del.next = swap.next;
	}
}
