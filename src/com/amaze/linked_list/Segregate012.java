package com.amaze.linked_list;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Segregate012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			Node head = new Node(sc.nextInt());
			Node tail = head;
			while (n-- > 1) {
				tail.next = new Node(sc.nextInt());
				tail = tail.next;
			}

			head = new Seg().segregate(head);
			printList(head);
			System.out.println();
		}
	}

	public static void printList(Node head) {
		if (head == null)
			return;

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

}
/*
 * Input:
	N = 8
	value[] = {1,2,2,1,2,0,2,2}
	Output: 0 1 1 2 2 2 2 2
 */
/*
 *  have nodes zero one two and also heads of all
 *  loop head != null
 *  	if head.data is zero
 *  		add to zero node and do changes to zeroHead if first entry
 *  	same for 1 and 2 also
 *  	head = head.next
 *  add all nodes like zero.head=one.head=two.head but with null check
 */
class Seg {
	static Node segregate(Node head) {
		Node zero = null;
		Node one = null;
		Node two = null;

		Node zeroH = null;
		Node oneH = null;
		Node twoH = null;

		while (head != null) {
			if (head.data == 0) {
				if (zeroH == null) {
					zero = new Node(0);
					zeroH = zero;
				} else {
					zero.next = new Node(0);
					zero = zero.next;
				}
			} else if (head.data == 1) {
				if (oneH == null) {
					one = new Node(1);
					oneH = one;
				} else {
					one.next = new Node(1);
					one = one.next;
				}
			} else if (head.data == 2) {
				if (twoH == null) {
					two = new Node(2);
					twoH = two;
				} else {
					two.next = new Node(2);
					two = two.next;
				}
			}
			head = head.next;
		}
		if (oneH != null) {
			zero.next = oneH;
			if (twoH != null) {
				one.next = twoH;
			}
		} else {
			if (twoH != null) {
				zero.next = twoH;
			}
		}
		return zeroH;
	}
}
