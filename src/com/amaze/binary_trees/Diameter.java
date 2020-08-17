package com.amaze.binary_trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Diameter {

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
			Tree55 g = new Tree55();
			System.out.println(g.diameter(root));
			t--;
		}
	}
}
// } Driver Code Ends

// User function Template for Java
/*
 * Given a Binary Tree, find diameter of it.
+The diameter of a tree is the number of nodes on the longest path between two leaves in the tree.
Input:
         10
        /   \
      20    30
    /   \ 
   40   60
Output: 4 */
/*
 * call util(root)
 * util
 * 		if root is null return null
 * 		find heightLeft and heightRight
 * 		diaLeft = util(root.left)
 * 		diaRight = util(root.right)
 * 		return max(max(diaLeft, diaRight), hA+hB+1)
 */
class Tree55 {
	/* Complete the function to get diameter of a binary tree */
	int diameter(Node root) {
		return diameterUtil(root);
		// Your code here
	}

	private int diameterUtil(Node root) {
		if (root == null) {
			return 0;
		}
		int hA = height(root.left);
		int hB = height(root.right);
		int dA = diameterUtil(root.left);
		int dB = diameterUtil(root.right);
		return Math.max(Math.max(dA, dB), hA + hB + 1);
	}

	int height(Node node) {
		if (node == null)
			return 0;
		int lHeight = height(node.left);
		int rHeight = height(node.right);
		return lHeight > rHeight ? lHeight + 1 : rHeight + 1;
	}

}
