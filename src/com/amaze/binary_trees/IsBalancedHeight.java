package com.amaze.binary_trees;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class IsBalancedHeight {

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
			Tree22 g = new Tree22();

			if (g.isBalanced(root) == true)
				System.out.println(1);
			else
				System.out.println(0);
			t--;

		}
	}

}

/*
 * Given a binary tree, find if it is height balanced or not. 
A tree is height balanced if difference between heights of left and right subtrees is not more than one for all nodes of tree. 
 */
/*
 * A height balanced tree
        1
     /     \
   10      39
  /
5

An unbalanced tree
        1
     /    
   10   
  /
5
 */
/*
 * isBal
 * 		return helper(root)==-1 then false else true
 * helper
 * 		if node is null return 0
 * 		lHeight = helper(node.left) and if it is -1 return -1
 * 		similar for rHeigth
 * 		if |lHeight-rHeight| > 1 return -1
 * 		return max of the two heights + 1
 */
class Tree22 {

	/*
	 * This function should return tree if passed tree is balanced, else false.
	 */
	boolean isBalanced(Node root) {
		return height(root) == -1 ? false : true;
	}

	int height(Node node) {
		if (node == null)
			return 0;
		int lHeight = height(node.left);
		if (lHeight == -1)
			return -1;
		int rHeight = height(node.right);
		if (rHeight == -1)
			return -1;
		if (Math.abs(lHeight - rHeight) > 1)
			return -1;
		return lHeight >= rHeight ? lHeight + 1 : rHeight + 1;
	}
}
