package com.amaze.binary_trees;

import java.io.*;
import java.util.*;

public class SpiralLevelOrder {

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

	void inOrder(Node node) {
		if (node == null) {
			return;
		}

		inOrder(node.left);
		System.out.print(node.data + " ");

		inOrder(node.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String s = br.readLine();
			Node root = buildTree(s);
			Spiral g = new Spiral();
			g.printSpiral(root);
			System.out.println();

		}
	}
}

/*
 * Input:
           10
         /     \
        20     30
      /    \
    40     60
Output: 10 20 30 60 40 
 */
/*
 * height
 * 		if root is null return 0
 * 		leftHeight = height(root.left) rightHeight=height(root.right)
 *      return max of these + 1
 * oneLevel(root, level, tmpArrayList)
 * 		if root is null return
 * 		if level is 1 then add data to tempArrayList
 * 		else 
 * 			oneLevel(root.left, level - 1, tempArrayList);
			oneLevel(root.right, level - 1, tempArrayList);
 * spiral
 * 		loop 1 to height=
 * 			initialize tmp array list
 * 			oneLevel(root, i, tmp)
 * 			if i is even reverse the temp array list
 * 			print the list
 */
class Spiral {
	void printSpiral(Node node) {
		for (int i = 1; i <= height(node); i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
			lvl(node, i, tmp);
			if (i % 2 != 0) {
				Collections.reverse(tmp);
			}
			for (int j = 0; j < tmp.size(); j++) {
				System.out.print(tmp.get(j) + " ");
			}
		}

	}

	private void lvl(Node root, int level, ArrayList<Integer> tmp) {
		if (root == null)
			return;
		if (level == 1) {
			tmp.add(root.data);
		} else {
			lvl(root.left, level - 1, tmp);
			lvl(root.right, level - 1, tmp);
		}
	}

	int height(Node root) {
		if (root == null)
			return 0;
		int lHei = height(root.left);
		int rHei = height(root.right);
		return (lHei > rHei ? lHei + 1 : rHei + 1);
	}
}