package com.amaze.linked_list;

//{ Driver Code Starts
//driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class DetectLoop {
	public static void makeLoop(Node head, Node tail, int x) {
		if (x == 0)
			return;

		Node curr = head;
		for (int i = 1; i < x; i++)
			curr = curr.next;

		tail.next = curr;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();

			int num = sc.nextInt();
			Node head = new Node(num);
			Node tail = head;

			for (int i = 0; i < n - 1; i++) {
				num = sc.nextInt();
				tail.next = new Node(num);
				tail = tail.next;
			}

			int pos = sc.nextInt();
			makeLoop(head, tail, pos);

			Loop x = new Loop();
			if (x.detectLoop(head))
				System.out.println("True");
			else
				System.out.println("False");
		}
	}
}

/*
 * Given a linked list of N nodes. The task is to check if the the linked list has a loop. Linked list can contain self loop.
 */
/*
 * Input:
	N = 3
	value[] = {1,3,4}
	x = 2
	Output: True
	Explanation: In above test case N = 3.
	The linked list with nodes N = 3 is
	given. Then value of x=2 is given which
	means last node is connected with xth
	node of linked list. Therefore, there
	exists a loop.
 */
/*
 * set slow as head and fast as head.next
 * loop till slow!=fast
 * 		if fast or fast.next becomes null then no loop return false
 * return true
 */
class Loop {
	public static boolean detectLoop(Node head) {
		Node slow = head;
		Node fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null)
				return false;
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
		// Add code here
	}
}