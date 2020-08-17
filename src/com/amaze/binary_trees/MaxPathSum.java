package com.amaze.binary_trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class MaxPathSum {

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

			Tree88 g = new Tree88();
			System.out.println(g.maxPathSum(root));
			t--;
		}
	}
}
/*
 * Given a binary tree in which each node element contains a number. Find the maximum possible sum from one leaf node to another.
 */
/*
 * Input:
		2
		3 4 5 -10 4
		-15 5 6 -8 1 3 9 2 -3 N N N N N 0 N N N N 4 -1 N N 10 N
		
	Output:
		16
		27
 */
/*
 * have sum as class variable and initialize it to MIN
 * maxPathSum
 * 		if root is null return 0
 * 		call maxUtil
 * 		return sum
 * maxUtil
 * 		if root is null return 0
 * 		if both left and right of root is null return root.data
 * 		ls = maxUtil(root.left)
 * 		rs = maxUtil(root.right)
 * 		if both left and right of root is not null
 * 			sum = max(sum, ls+rs+root.data)
 * 			return max(ls,rs) + root.data
 * 			if root.left is not null
 * 				return ls + root.data
 * 			if root.right is not null
 * 				return rs + root.data
 * 
 */
class Tree88 {
	int sum = Integer.MIN_VALUE;

	int maxPathSum(Node root) {
		if (root == null)
			return 0;
		maxUtil(root);
		return sum;
	}

	int maxUtil(Node root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.data;

		int ls = maxUtil(root.left);
		int rs = maxUtil(root.right);

		if (root.left != null && root.right != null) {
			sum = Math.max(sum, ls + rs + root.data);
			return Math.max(ls, rs) + root.data;
		}
		if (root.left != null) {
			return ls + root.data;
		} else {
			return rs + root.data;
		}

	}
}