package com.amaze.binary_trees;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class Identical {

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

		while (t-- > 0) {
			String s1 = br.readLine();
			String s2 = br.readLine();
			Node root1 = buildTree(s1);
			Node root2 = buildTree(s2);
			Tree7 g = new Tree7();
			// System.out.println(g.isIdentical(root,roott));
			boolean b = g.isIdentical(root1, root2);
			if (b == true)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}

// } Driver Code Ends

// User function Template for Java

/*
 Input:
    1       1
  /  \     /  \
 2    3   3    2
Output: No
Explanation: There are two trees both
having 3 nodes and 2 edges, but both
trees are not identical.
 */
/*
 * two trees root1 root2
 * both root null return true
 * any one root null return false
 * root1.data!=root2.data	return false
 * return iden(root1.left,root2.left)&&iden(root1.right,root2.right)
 */
class Tree7 {
	boolean isIdentical(Node root1, Node root2) {

		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null && root2 != null) {
			return false;
		}
		if (root1 != null && root2 == null) {
			return false;
		}
		if (root1.data != root2.data) {
			return false;
		}
		return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
	}

}