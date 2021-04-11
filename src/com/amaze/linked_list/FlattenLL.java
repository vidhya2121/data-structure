package com.amaze.linked_list;

import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node2 {
	int data;
	Node2 next;
	Node2 bottom;

	Node2(int d) {
		data = d;
		next = null;
		bottom = null;
	}
}

public class FlattenLL {
	Node2 head;

	void printList(Node2 node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.bottom;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		FlattenLL list = new FlattenLL();
		while (t > 0) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			for (int i = 0; i < N; i++)
				arr[i] = sc.nextInt();

			Node2 temp = null;
			Node2 tempB = null;
			Node2 pre = null;
			Node2 preB = null;
			int flag = 1;
			int flag1 = 1;
			for (int i = 0; i < N; i++) {
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node2(a1);
				if (flag == 1) {
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				} else {
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}

				for (int j = 0; j < m; j++) {
					int a = sc.nextInt();
					tempB = new Node2(a);
					if (flag1 == 1) {
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					} else {
						preB.bottom = tempB;
						preB = tempB;
					}
				}

			}
			GfG2 g = new GfG2();
			Node2 root = g.flatten(list.head);
			list.printList(root);

			t--;
		}
	}
}

/*
 * Given a Linked List of size N, where every node represents a linked list and contains two pointers of its type:
	(i) a next pointer to the next node,
	(ii) a bottom pointer to a linked list where this node is head.
	
	You have to flatten the linked list to a single linked list which should be sorted.
 */
/*
 * Each node has next and bottom
 * function flatten with Node as arg
 * if root or root.next is null return
 * root.next = flatten(root.next)
 * root = merge(root, root.next)
 * 
 * function merge tkes 2 nodes a and b
 * declare a res node
 * if  is null return b and vice versa
 * if a.data < b.data
 * 		res = a
 * 		res.bottom = merge(a.bottom , b)
 * same if else
 * return res
 */
class GfG2 {
	Node2 flatten(Node2 root) {
		if (root == null || root.next == null) {
			return root;
		}
		root.next = flatten(root.next);
		root = merge(root, root.next);
		return root;
	}

	private Node2 merge(Node2 a, Node2 b) {
		Node2 res;
		if (a == null)
			return b;
		if (b == null)
			return a;
		if (a.data < b.data) {
			res = a;
			res.bottom = merge(a.bottom, b);
		} else {
			res = b;
			res.bottom = merge(a, b.bottom);
		}
		res.next = null;
		return res;
	}
}
