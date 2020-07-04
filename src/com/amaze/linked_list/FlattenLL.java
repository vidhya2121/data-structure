package com.amaze.linked_list;

//{ Driver Code Starts
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
		// Node temp = head;
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
			// list.printList();
			GfG2 g = new GfG2();
			Node2 root = g.flatten(list.head);
			list.printList(root);

			t--;
		}
	}
}

/*
 * Function which returns the root of the flattened linked list.
 */
class GfG2 {
	Node2 flatten(Node2 root) {
		if (root == null || root.next == null) {
			return root;
		}
		root.next = flatten(root.next);
		root = merge(root, root.next);
		return root;
		// Your code here
	}

	private Node2 merge(Node2 a, Node2 b) {
		// TODO Auto-generated method stub
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
