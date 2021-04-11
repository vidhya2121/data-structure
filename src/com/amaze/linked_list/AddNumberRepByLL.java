package com.amaze.linked_list;

import java.util.*;

public class AddNumberRepByLL {

	static void printList(Node n) {
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		while (T-- > 0) {

			int n = sc.nextInt();
			int val = sc.nextInt();

			Node first = new Node(val);
			Node tail = first;
			for (int i = 0; i < n - 1; i++) {
				val = sc.nextInt();
				tail.next = new Node(val);
				tail = tail.next;
			}

			int m = sc.nextInt();
			val = sc.nextInt();

			Node second = new Node(val);
			tail = second;
			for (int i = 0; i < m - 1; i++) {
				val = sc.nextInt();
				tail.next = new Node(val);
				tail = tail.next;
			}

			Add g = new Add();
			Node res = g.addLists(first, second);
			printList(res);
		}
	}
}
/*
 * Input:
	N = 2
	valueN[] = {4,5}
	M = 3
	valueM[] = {3,4,5}
	Output: 3 9 0  
 */
/*
 * reverse both list
 * have sum and carry
 * while first or second not null
 * 		sum = first+second+carry
 * 		carry=sum/10
 * 		sum=sum%10
 * 		add sum to newList
 * if carry!=0 add carry to the list
 * return reversed result
 */
class Add {
	static Node addLists(Node first, Node second) {
		Node revFirst = reverseList(first);
		Node revSecond = reverseList(second);
		Node res = null;
		Node reHead = null;
		int sum = 0;
		int carry = 0;
		while (revFirst != null || revSecond != null) {
			sum = (revFirst == null ? 0 : revFirst.data) + (revSecond == null ? 0 : revSecond.data) + carry;
			carry = sum / 10;
			sum = sum % 10;
			Node sumNode = new Node(sum);
			if (res == null) {
				res = sumNode;
				reHead = sumNode;
			} else {
				res.next = sumNode;
				res = res.next;
			}
			revFirst = revFirst != null ? revFirst.next : null;
			revSecond = revSecond != null ? revSecond.next : null;
		}
		if (carry != 0) {
			res.next = new Node(carry);
		}
		return reverseList(reHead);
	}

	static Node reverseList(Node head) {
		Node curr = head;
		Node prev = null;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
}