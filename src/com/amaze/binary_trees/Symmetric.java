package com.amaze.binary_trees;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class Symmetric {

	static Node buildTree(String str) {

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

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			Node root = buildTree(s);

			Tree9 g = new Tree9();
			if (g.isSymmetric(root) == true)
				System.out.println("True");
			else
				System.out.println("False");

			t--;

		}
	}
}
/*
 *            100
            /     \
          10       10
         /   \    /   \
       20     20 20    20
 */

/*
 * if root null return true
 * callUtil(riit.left, root.right)
 * util
 * 		both left and right null return true
 * 		either null return false
 * 		left.data!=right.data return false
 * 		util(left.left,right.right)&&(left.right,right.left)
 */
class Tree9 {
	// return true/false denoting whether the tree is Symmetric or not
	public static boolean isSymmetric(Node root) {
		if (root == null)
			return true;
		return isSymmetricUti(root.left, root.right);

	}

	private static boolean isSymmetricUti(Node node1, Node node2) {
		if (node1 == null && node2 == null)
			return true;
		if (node1 == null || node2 == null)
			return false;
		if (node1.data != node2.data)
			return false;
		return isSymmetricUti(node1.left, node2.right) && isSymmetricUti(node1.right, node2.left);
	}
}