package com.amaze.linked_list;

//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Reverse {
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

			ReverseLL g = new ReverseLL();
			head = g.reverseList(head);
			printList(head);
			t--;
		}
	}
}

/*
 * Input:
		N = 6
		value[] = {1,2,3,4,5,6}
	Output: 6 5 4 3 2 1
		Explanation: After reversing the list, 
		elements are 6->5->4->3->2->1.
 */
/*
 * prev=null curr=head next=null
 * loop till curr != null
 * 		next = curr.next
 * 		curr.next = prev
 * 		prev = curr
 *		curr = next
 */
class ReverseLL {
	Node reverseList(Node head) {
		Node curr = head;
		Node prev = null;
		Node next = null;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}
