package com.amaze.stack_queues;

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

/*
 * You are given N elements and your task is to Implement a Stack in which you can get minimum element in O(1) time.
 * A Query Q may be of 3 Types:
    1. 1 x (a query of this type means  pushing 'x' into the stack)
    2. 2 (a query of this type means to pop element from stack and print the poped element)
    3. 3 (a query of this type means to print the minimum element from the stack)
The second line of each test case contains Q queries seperated by space.
 */
/*
 * Input:
	1
	6
	1 2 1 3 2 3 1 1 3   
	
	Output:
	3 2 1
 */
/*
 * have min as class variable
 * getMin method
 * 		just do check on stack empty and return min
 * pop
 * 		pop the element and if element > min then return
 * 		store min in temp
 * 		update min as 2*min - y
 * 		return temp
 * push
 * 		ele > min push
 * 		else push 2*ele - min and set min as ele
 */
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
		return s.isEmpty() ? -1 : s.peek();
	}

	/* returns poped element from stack */
	int pop() {
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
