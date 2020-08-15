package com.amaze.linked_list;

//{ Driver Code Starts
import java.util.*;

class Palindrome {
	Node head;
	Node tail;

	/* Function to print linked list */
	void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Inserts a new Node at front of the list. */
	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			// int k = sc.nextInt();
			Palindrome llist = new Palindrome();
			// int n=Integer.parseInt(br.readLine());
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			Node tail = head;
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				tail.next = new Node(a);
				tail = tail.next;
			}

			PalindromeSol g = new PalindromeSol();
			if (g.isPalindrome(head) == true)
				System.out.println(1);
			else
				System.out.println(0);
			t--;
		}

	}
}

// } Driver Code Ends

/*
 * Structure of class Node is class Node { int data; Node next;
 * 
 * Node(int d) { data = d; next = null; } }
 */
/*
 * Input:
	N = 3
	value[] = {1,2,1}
	Output: 1
 */
/*
 * slow and fast find middle and also note prev -> slow's prev
 * head2 = reverse(slow)
 * loop head2!=null && head!=prev.next
 * 		if two data not equal return false
 * return true
 */
class PalindromeSol {
	// Function to check if linked list is palindrome
	boolean isPalindrome(Node head) {
		Node slow = head;
		Node fast = head;
		Node temp = null;
		while (fast != null && fast.next != null) {
			temp = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		Node head2 = reverse(slow);
		while (head2 != null && head != temp.next) {
			if (head.data != head2.data) {
				return false;
			}
			head = head.next;
			head2 = head2.next;
		}
		
		// Your code here
		return true;
	}

	Node reverse(Node node) {
		Node curr = node;
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
