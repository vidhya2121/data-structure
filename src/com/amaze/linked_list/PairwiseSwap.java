package com.amaze.linked_list;

//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class PairwiseSwap {
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

			Sol g = new Sol();
			head = g.pairwiseSwap(head);
			printList(head);
			t--;
		}
	}
}

class Sol {
	// Function to pairwise swap elements of a linked list.
	// It should returns head of the modified list
	public Node pairwiseSwap(Node head) {
		Node curr = head;
		Node prev = null;
		Node next = null;
		for (int i = 0; i < 2 && curr != null; i++) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		if (curr!=null) {
			head.next = pairwiseSwap(next);
		}
		return prev;
	}
}