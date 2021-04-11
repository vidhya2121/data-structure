package com.amaze.linked_list;

import java.util.*;

class Merge {
	Node head;

	/* Function to print linked list */
	public static void printList(Node head) {

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			Node head1 = new Node(sc.nextInt());
			Node tail1 = head1;
			for (int i = 0; i < n1 - 1; i++) {
				tail1.next = new Node(sc.nextInt());
				tail1 = tail1.next;
			}
			Node head2 = new Node(sc.nextInt());
			Node tail2 = head2;
			for (int i = 0; i < n2 - 1; i++) {
				tail2.next = new Node(sc.nextInt());
				tail2 = tail2.next;
			}

			LinkedList obj = new LinkedList();
			Node head = obj.sortedMerge(head1, head2);
			printList(head);

			t--;

		}
	}
}

/*
 * Input:
	N = 4, M = 3 
	valueN[] = {5,10,15,40}
	valueM[] = {2,3,20}
	Output: 2 3 5 10 15 20 40
 *//*
 *	Without using temp node
 *	have A as such, and for very B check value with A and insert into A
 *	First do for head
 *	have currA = headA and nextA as headA.next
 *	loop till currA nextA and headB no null
 *		if headB.data is btw currA and nextA data. insert
 */
class LinkedList {
	Node sortedMerge(Node headA, Node headB) {
		if (headA == null)
			return headB;
		if (headB == null)
			return headA;
		if (headB.data < headA.data) {
			Node newnode = new Node(headB.data);
			newnode.next = headA;
			headA = newnode;
			headB = headB.next;
		}
		Node currA = headA;
		Node nextA = headA.next;
		while (currA != null && nextA != null && headB != null) {
			if (headB.data >= currA.data && headB.data <= nextA.data) {
				Node newnode = new Node(headB.data);
				newnode.next = nextA;
				currA.next = newnode;
				currA = newnode;
				nextA = newnode.next;
				headB = headB.next;
			} else {
				currA = currA.next;
				nextA = nextA.next;
			}

		}
		if (headB != null)
			currA.next = headB;
		return headA;
	}
}

/*
 * using dummy node. set dummy as new Node(0)
 * initialize tail as dummy
 * while true
 * 		if headA is null tail.next is headB and vice versa
 * 		if headA.data < headB.data 
 * 			tail.next = headA and do headA = headA.next
 * 		similar for else
 * 		tail->tail.next
 * return dummy.next
 */

/*Node sortedMerge(Node headA, Node headB) 
{ 
    Node dummyNode = new Node(0); 
    
    Node tail = dummyNode; 
    while(true)  
    { 
        if(headA == null) 
        { 
            tail.next = headB; 
            break; 
        } 
        if(headB == null) 
        { 
            tail.next = headA; 
            break; 
        } 
        if(headA.data <= headB.data) 
        { 
            tail.next = headA; 
            headA = headA.next; 
        }  
        else
        { 
            tail.next = headB; 
            headB = headB.next; 
        } 
        tail = tail.next; 
    } 
    return dummyNode.next; 
} */
