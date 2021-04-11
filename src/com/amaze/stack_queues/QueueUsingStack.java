package com.amaze.stack_queues;

import java.util.*;
import java.util.Stack;
import java.util.LinkedList;

public class QueueUsingStack {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			StackQueue g = new StackQueue();
			int q = sc.nextInt();
			while (q > 0) {
				int QueryTyoe = sc.nextInt();
				if (QueryTyoe == 1) {
					int a = sc.nextInt();
					g.Push(a);
				} else if (QueryTyoe == 2)
					System.out.print(g.Pop() + " ");
				q--;

			}
			System.out.println();
			t--;
		}
	}
}

// } Driver Code Ends

class StackQueue {
	Stack<Integer> s1 = new Stack<Integer>();
	Stack<Integer> s2 = new Stack<Integer>();

	/*
	 * The method insert to push element into the queue
	 */
	void Push(int x) {
		s1.push(x);
	}

	/*
	 * The method remove which return the element popped out of the queue
	 */
	int Pop() {
		if(s1.empty())return -1;
		int res;
		while(!s1.empty()) {
			s2.push(s1.pop());
		}
		res = s2.pop();
		while(!s2.empty()) {
			s1.push(s2.pop());
		}
		return res;
	}
}
