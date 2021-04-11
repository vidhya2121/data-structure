package com.amaze.linked_list;

import java.util.*;

class YIntersection {
	Node head = null;
	Node tail = null;

	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
			tail = head;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	/* Function to print linked list */
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int n3 = sc.nextInt();
			YIntersection llist1 = new YIntersection();
			YIntersection llist2 = new YIntersection();
			YIntersection llist3 = new YIntersection();

			int a1 = sc.nextInt();
			Node head1 = new Node(a1);
			Node tail1 = head1;

			for (int i = 1; i < n1; i++) {
				int a = sc.nextInt();
				tail1.next = (new Node(a));
				tail1 = tail1.next;
			}

			int b1 = sc.nextInt();
			Node head2 = new Node(b1);
			Node tail2 = head2;
			for (int i = 1; i < n2; i++) {
				int b = sc.nextInt();
				tail2.next = (new Node(b));
				tail2 = tail2.next;
			}

			int c1 = sc.nextInt();
			Node head3 = new Node(c1);
			tail1.next = head3;
			tail2.next = head3;
			Node tail3 = head3;
			for (int i = 1; i < n3; i++) {
				int c = sc.nextInt();
				tail3.next = (new Node(c));
				tail3 = tail3.next;
			}

			Intersect obj = new Intersect();
			System.out.println(obj.intersectPoint(head1, head2));
			t--;
		}
	}
}

/*
 * Given two singly linked lists of size N and M, write a program to get the point where two linked lists intersect each other.
 */
/*
   Input:
	LinkList1 = {10,20,5,10}
	LinkList2 = {30,40,50,5,10}
   Output: 5
 */

/*
 * get count of both list
 * traverse larger list to length1 - length2
 * loop till both list not null and do next for both and if both nodes are same break
 */
class Intersect {
	int intersectPoint(Node headA, Node headB) {
		int c1 = getCount(headA);
		int c2 = getCount(headB);
		int d = Math.abs(c1 - c2);
		int which = c1 > c2 ? 2 : 1;
		if (which == 2) {
			for (int i = 0; i < d && headA != null; i++) {
				headA = headA.next;
			}
		} else {
			for (int i = 0; i < d && headB != null; i++) {
				headB = headB.next;
			}
		}
		while (headA != null && headB != null) {
			if (headA == headB) {
				break;
			}
			headA = headA.next;
			headB = headB.next;
		}
		if (headA == null || headB == null) {
			return -1;
		}
		return headA.data;
	}

	int getCount(Node head) {
		Node t = head;
		int count = 0;
		while (t != null) {
			t = t.next;
			count++;
		}
		return count;
	}
}
