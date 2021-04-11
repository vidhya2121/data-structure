package com.amaze.binary_trees;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class CNode {
	int data;
	CNode left;
	CNode right;
	CNode nextRight;

	CNode(int data) {
		this.data = data;
		left = null;
		right = null;
		nextRight = null;
	}
}

public class Connect {

	static CNode buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		CNode root = new CNode(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<CNode> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			CNode currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new CNode(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new CNode(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	public static void printInorder(CNode root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void printSpecial(CNode root) {
		if (root == null)
			return;

		CNode next_root = null;

		while (root != null) {
			System.out.print(root.data + " ");

			if (root.left != null && next_root == null)
				next_root = root.left;
			else if (root.right != null && next_root == null)
				next_root = root.right;

			root = root.nextRight;
		}

		printSpecial(next_root);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			CNode root = buildTree(s);
			CTree g = new CTree();
			g.connect(root);
			printSpecial(root);
			System.out.println();
			printInorder(root);
			System.out.println();
			t--;

		}
	}

}

/*
 * used nextRight within node object
 * 
 */
class CTree {
	/*
	 * Node class is Defined as follows: class Node{ int data; Node left; Node
	 * right; Node nextRight; Node(int data){ this.data = data; left=null;
	 * right=null; nextRight = null; } }
	 */
	/*
	 * Given a binary tree, connect the nodes that are at same level. You'll be given an addition nextRight pointer for the same.

Initially, all the nextRight pointers point to garbage values. 
Your function should set these pointers to point next right for each node.
       10                       10 ------> NULL
      / \                 /      \
     3   5       =>     3 ------> 5 --------> NULL
    / \     \          /  \        \
   4   1   2          4 --> 1 -----> 2 -------> NULL
	 */
	
	/*
	 * have a queue
	 * add root to q then add null, adding null is used as line ending
	 * loop q not empty
	 * 		t = q.remove
	 * 		if t not null
	 * 			t.nextRight = q.peek
	 * 			if t.left not null add to q
	 * 			if t.right not null add to q
	 * 		else \	
	 * 			if q not empty add null to q	
	 */
	public static void connect(CNode p) {
		Queue<CNode> q = new LinkedList<>();
		q.add(p);
		q.add(null);
		while (!q.isEmpty()) {
			CNode t = q.remove();
			if (t != null) {
				t.nextRight = q.peek();
				if (t.left != null) {
					q.add(t.left);
				}
				if (t.right != null) {
					q.add(t.right);
				}
			} else {
				if (!q.isEmpty()) {
					q.add(null);
				}
			}
		}
	}
}