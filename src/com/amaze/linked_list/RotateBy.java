package com.amaze.linked_list;

//{ Driver Code Starts
import java.util.*;

class RotateBy {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();

			int a = sc.nextInt();
			Node head = new Node(a);
			Node tail = head;

			for (int i = 0; i < n - 1; i++) {
				a = sc.nextInt();
				tail.next = new Node(a);
				tail = tail.next;
			}

			int k = sc.nextInt();

			Rotate g = new Rotate();
			head = g.rotate(head, k);
			printList(head);
		}
	}

	public static void printList(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
}

class Rotate {
	// This function should rotate list counter-
	// clockwise by k and return head node

	public Node rotate(Node head, int k) {
		Node firstHead = head;
		Node temp = head;
		int count = 1;
		Node lastToTemp = null;
		while (temp != null && count <= k) {
			lastToTemp = temp;
			temp = temp.next;
			count++;
		}
		Node secHed = temp;
		while (temp != null && temp.next != null) {
			temp = temp.next;
		}
		if(temp!=null) {
			temp.next = firstHead;
			lastToTemp.next = null;
			return secHed;
		} else {
			return firstHead;
		}
		
		// add code here
	}
}
