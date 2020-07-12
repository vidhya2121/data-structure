package com.stack_queues;

import java.util.*;

public class GetMinimumFromStack {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int q = sc.nextInt();
			GfGS2 g = new GfGS2();
			while (q > 0) {
				int qt = sc.nextInt();

				if (qt == 1) {
					int att = sc.nextInt();
					g.push(att);
					// System.out.println(att);
				} else if (qt == 2) {
					System.out.print(g.pop() + " ");
				} else if (qt == 3) {
					System.out.print(g.getMin() + " ");
				}

				q--;
			}
			System.out.println();
			T--;
		}

	}
}

// } Driver Code Ends

class GfGS {
	int minEle;
	Stack<Integer> s = new Stack<Integer>();

	/* returns min element from stack */
	int getMin() {
		// Your code here
		return s.isEmpty() ? -1 : minEle;
	}

	/* returns poped element from stack */
	int pop() {
		// Your code here
		if (s.isEmpty())
			return -1;
		int y = s.pop();
		if (y >= minEle) {
			return y;
		}
		int k = minEle;
		minEle = 2 * minEle - y;
		return k;
	}

	/* push element x into the stack */
	void push(int x) {
		// Your code here
		if (s.isEmpty()) {
			s.push(x);
			minEle = x;
		} else {
			if (x > minEle) {
				s.push(x);
			} else {
				s.push(2 * x - minEle);
				minEle = x;
			}
		}
	}
}

/*
 * Another Solution Always insert element and minELement So when pop always pop
 * both, In this way previous min is never lost
 */

class GfGS2 {
	int minEle;
	Stack<Integer> s = new Stack<Integer>();

	/* returns min element from stack */
	int getMin() {
		// Your code here
		return s.isEmpty() ? -1 : s.peek();
	}

	/* returns poped element from stack */
	int pop() {
		// Your code here
		if (s.isEmpty())
			return -1;
		int oldMin = s.pop();
		int ret = s.pop();
		if(!s.isEmpty())
			minEle = s.peek();
		return ret;
	}

	/* push element x into the stack */
	void push(int x) {
		// Your code here
		if (s.isEmpty()) {
			s.push(x);
			minEle = x;
		} else {
			if (x < minEle) {
				minEle = x;
			}
			s.push(x);
			s.push(minEle);
		}
	}
}
