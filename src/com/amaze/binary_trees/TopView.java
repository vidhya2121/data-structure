package com.amaze.binary_trees;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class TopView {

	public static void main(String[] args) throws IOException {
		// Scanner sc=new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			Queue<Node> q = new LinkedList<>();

			int n = Integer.parseInt(br.readLine());
			String input[] = br.readLine().trim().split(" ");

			Node root = null;
			int j = 0;
			while (n > 0) {
				int a1 = Integer.parseInt(input[j]);
				int a2 = Integer.parseInt(input[j + 1]);
				char lr = input[j + 2].charAt(0);
				j += 3;

				if (root == null) {
					root = new Node(a1);
					q.add(root);
				}

				Node pick = q.peek();

				q.remove();

				if (lr == 'L') {
					pick.left = new Node(a2);
					q.add(pick.left);
				}
				a1 = Integer.parseInt(input[j]);
				a2 = Integer.parseInt(input[j + 1]);
				lr = input[j + 2].charAt(0);
				j += 3;

				if (lr == 'R') {
					pick.right = new Node(a2);
					q.add(pick.right);
				}

				n -= 2;
			}
			new View().topView(root);
			System.out.println();
			t--;
		}
	}
}

class View {
	// function should print the topView of the binary tree
	static void topView(Node root) {
		// add your code
		class HNode {
			Node node;
			int hd;

			HNode(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}
		}
		Queue<HNode> tq = new LinkedList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		ArrayList<Integer> res = new ArrayList<>();
		tq.add(new HNode(root, 0));

		while (!tq.isEmpty()) {
			HNode temp = tq.remove();
			int horizontal = temp.hd;

			if (!map.containsKey(temp.hd)) {
				map.put(horizontal, temp.node.data);
			}

			if (temp.node.left != null) {
				tq.add(new HNode(temp.node.left, horizontal - 1));
			}
			if (temp.node.right != null) {
				tq.add(new HNode(temp.node.right, horizontal + 1));
			}
		}
		for (Entry<Integer, Integer> it : map.entrySet()) {
			System.out.print(it.getValue() + " ");
		}
		System.out.println();
	}
}