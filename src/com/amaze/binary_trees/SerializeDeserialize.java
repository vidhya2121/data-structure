package com.amaze.binary_trees;

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

public class SerializeDeserialize {

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
			String s = br.readLine();
			Node root = buildTree(s);

			Tree33 tr = new Tree33();
			ArrayList<Integer> A = new ArrayList<Integer>();
			tr.serialize(root, A);

			Node getRoot = tr.deSerialize(A);
			printInorder(getRoot);
			System.out.println();
		}
	}
}
/*
 * Serialization is to store a tree in an array so that it can be later restored and
 *  Deserialization is reading tree back from the array.
 *   Now your task is to complete the function serialize which stores the tree into an array A[ ] 
 *   and deSerialize which deserializes the array to tree and returns it.
Note: The structure of tree must be maintained.
 */
/*
 * Input:
         10
       /    \
      20    30
    /   \
   40  60
Output: 40 20 60 10 30
 */
/*
 * serialize
 * 		preorder traversal with array.add instead of sysout
 * deserialize
 * 		have index at class level
 * 		if index == array.size return null
 * 		val = array.get(index) index++
 * 		if val is -1 return null
 * 		create newnode with val
 * 		root.left = deseialize(array)
 * 		root.right = deserialize(array)
 * 		return root
 */
class Tree33 {
	int index = 0;

	public void serialize(Node root, ArrayList<Integer> A) {
		if (root == null) {
			A.add(-1);
			return;
		}
		A.add(root.data);
		serialize(root.left, A);
		serialize(root.right, A);
	}

	public Node deSerialize(ArrayList<Integer> A) {
		return deSer(A);

	}

	private Node deSer(ArrayList<Integer> A) {
		if (index == A.size())
			return null;
		int val = A.get(index);
		index++;
		if (val == -1)
			return null;
		Node root = new Node(val);
		root.left = deSer(A);
		root.right = deSer(A);
		return root;
	}
}