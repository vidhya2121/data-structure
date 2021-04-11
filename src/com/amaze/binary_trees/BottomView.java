package com.amaze.binary_trees;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.io.*;
import java.util.*;

class TNode {
	int data; // data of the node
	int hd; // horizontal distance of the node
	TNode left, right; // left and right references

	// Constructor of tree node
	public TNode(int key) {
		data = key;
		hd = Integer.MAX_VALUE;
		left = right = null;
	}
}

public class BottomView {

	static TNode buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		TNode root = new TNode(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<TNode> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			TNode currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new TNode(Integer.parseInt(currVal));
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
				currNode.right = new TNode(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(TNode root) {
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
			TNode root = buildTree(s);
			Tree3 g = new Tree3();
			ArrayList<Integer> res = g.bottomView(root);
			for (Integer num : res)
				System.out.print(num + " ");
			System.out.println();
		}
	}
}

/*
 *      			  20
                    /    \
                  8       22
                /   \     /   \
              5      3 4     25
                     /    \      
                 10       14

For the above tree the output should be 5 10 4 14 25.

 */
/*
 * note that node class has horizontaldist member variable
 * queue & treemap, arraylist for result
 * set hd of root to 1 and put root into q
 * loop q not empty
 * 		temp = remove from q
 * 		map.put(temp.hd, temp.data) // this ensures like it replaces the node having same hd
 * 		if temp.left is not null, set its hd as temp.hd+1 and add to q
 * 		similar for right
 * 
 */
class Tree3 {

	// Method that returns the bottom view.
	public ArrayList<Integer> bottomView(TNode root) {
		Queue<TNode> tq = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		ArrayList<Integer> res = new ArrayList<>();
		root.hd = 1;
		tq.add(root);

		while (!tq.isEmpty()) {
			TNode temp = tq.remove();
			int horizontal = temp.hd;

			map.put(horizontal, temp.data);

			if (temp.left != null) {
				temp.left.hd = horizontal - 1;
				tq.add(temp.left);
			}
			if (temp.right != null) {
				temp.right.hd = horizontal + 1;
				tq.add(temp.right);
			}
		}
		for (Entry<Integer, Integer> it : map.entrySet()) {
			res.add(it.getValue());
		}
		return res;
	}
}