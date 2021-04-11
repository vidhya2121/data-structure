package com.amaze.linked_list;

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

/*
 * Input:
	N = 8
	value[] = {1,2,3,4,5,6,7,8}
	k = 4
	Output: 5 6 7 8 1 2 3 4
 */
class Rotate {
	// This function should rotate list counter-
	// clockwise by k and return head node
	/*
	 * iterate k times 
	 * 		store the k-1 th node also temp -> temp.next
	 * set secondHead ad temp
	 * loop till temp is not null && temp.next is not null 
	 * 		temp -> temp.next
	 * if temp != null
	 * 		make temp.next as firsthead
	 *      k-1 th temp.next = null
	 */
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
		
	}
}
