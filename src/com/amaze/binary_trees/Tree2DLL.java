package com.amaze.binary_trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tree2DLL {

	static Node buildTree(String str) throws IOException {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
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
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	void inorder(Node node) {
		if (node == null)
			return;
		else
			inorder(node.left);
		System.out.print(node.data + " ");
		inorder(node.right);
	}

	public static void printList(Node head) {
		Node prev = head;
		while (head != null) {
			System.out.print(head.data + " ");
			prev = head;
			head = head.right;
		}

		System.out.println();
		while (prev != null) {
			System.out.print(prev.data + " ");
			prev = prev.left;
		}
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			Node root = buildTree(s);
			GfG g = new GfG();

			Node ans = g.bToDLL(root);
			printList(ans);
			t--;
			System.out.println();
		}

	}
}
// } Driver Code Ends

// User function Template for Java

/*
 * class Node class Node { Node left, right; int data;
 * 
 * Node(int d) { data = d; left = right = null; }
 * 
 * }
 */

/*
 * Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place. 
 * The left and right pointers in nodes are to be used as previous and next pointers respectively in converted DLL. 
 * The order of nodes in DLL must be same as Inorder of the given Binary Tree. 
 * The first node of Inorder traversal (leftmost node in BT) must be the head node of the DLL.
 */
/*
 * have head of DLL as class member = null 
 * have a prev also as class member = null
 * treeToDLL
 * 		call inorder(root)
 * 		return head
 * inorder
 * 		if root null return
 * 		inorder(root.left)
 * 		if prev not null
 * 			root.left = prev
 * 			prev.right = root
 * 		else head = root
 * 		prev = root
 * 		inorder(root.right)
 * 		
 */
class GfG {
	Node prev = null;
	Node head = null;

	Node bToDLL(Node root) {

		inOrder(root);

		return head;
		// Your code here
	}

	private void inOrder(Node root) {

		if (root == null)
			return;
		inOrder(root.left);
		if (prev != null) {
			root.left = prev;
			prev.right = root;
		} else {
			head = root;
		}
		prev = root;
		inOrder(root.right);

	}
}