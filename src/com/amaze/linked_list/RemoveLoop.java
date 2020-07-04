package com.amaze.linked_list;

//{ Driver Code Starts
//driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node1 {
	int data;
	Node1 next;
}

class RemoveLoop {
	public static Node1 newNode(int data) {
		Node1 temp = new Node1();
		temp.data = data;
		temp.next = null;
		return temp;
	}

	public static void makeLoop(Node1 head, int x) {
		if (x == 0)
			return;
		Node1 curr = head;
		Node1 last = head;

		int currentPosition = 1;
		while (currentPosition < x) {
			curr = curr.next;
			currentPosition++;
		}

		while (last.next != null)
			last = last.next;
		last.next = curr;
	}

	public static boolean detectLoop(Node1 head) {
		Node1 hare = head.next;
		Node1 tortoise = head;
		while (hare != tortoise) {
			if (hare == null || hare.next == null)
				return false;
			hare = hare.next.next;
			tortoise = tortoise.next;
		}
		return true;
	}

	public static int length(Node1 head) {
		int ret = 0;
		while (head != null) {
			ret += 1;
			head = head.next;
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();

			int num = sc.nextInt();
			Node1 head = newNode(num);
			Node1 tail = head;

			for (int i = 0; i < n - 1; i++) {
				num = sc.nextInt();
				tail.next = newNode(num);
				tail = tail.next;
			}

			int pos = sc.nextInt();
			makeLoop(head, pos);

			solver x = new solver();
			x.removeLoop(head);

			if (detectLoop(head) || length(head) != n)
				System.out.println("0");
			else
				System.out.println("1");
		}
	}
}
// } Driver Code Ends

/*
 * class Node { int data; Node next; }
 */

class solver {
	public static void removeLoop(Node1 head) {
		// code here
		// remove the loop without losing any nodes
		Node1 slow = head;
		Node1 fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null)
				return;
			slow = slow.next;
			fast = fast.next.next;
		}
		int c = 0;
		fast = slow.next;
		while (fast != slow) {
			fast = fast.next;
			c++;
		}
		slow = head;
		fast = head;
		for (int i = 0; i < c; i++) {
			fast = fast.next;
		}
		while (slow != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = null;
	}
}