package com.amaze.binary_trees;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class VerticalTraversal {

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
			BinaryTree obj = new BinaryTree();
			ArrayList<Integer> res = obj.verticalOrder(root);
			for (Integer num : res)
				System.out.print(num + " ");
			System.out.println();

		}
	}
}
/*
 * Input:
       1
    /    \
   2      3
 /   \      \
4     5      6
Output: 4 2 1 5 3 6
 */
/*
 * have a treemap<int,list> \ arraylist for result
 * call printVerticalHelper(root, 0, map)
 * helper
 * 		if root is null return
 * 		addtomap(root.data, d, map)
 * 		printVerticalHelper(root.left, d-1, map)
 * 		printVerticalHelper(root.right, d+1, map)
 * addtomap -> this will add an array for every d
 */
class BinaryTree {

	static ArrayList<Integer> verticalOrder(Node root) {

		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
		ArrayList<Integer> res = new ArrayList<>();

		printVertical(root, 0, map);
		
		for(Entry<Integer, ArrayList<Integer>> it : map.entrySet()) {
			for (int i : it.getValue()) {
				res.add(i);
			}
		}
		return res;
	}

	private static void printVertical(Node root, int d, Map<Integer, ArrayList<Integer>> map) {
		if (root == null)
			return;

		addToMap(root.data, d, map);
		printVertical(root.left, d - 1, map);
		printVertical(root.right, d + 1, map);
	}

	private static void addToMap(int data, int d, Map<Integer, ArrayList<Integer>> map) {
		if(!map.containsKey(d)) {
			map.put(d, new ArrayList<>());
		}
		map.get(d).add(data);
	}

}