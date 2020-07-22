package com.amaze.stack_queues;

// { Driver Code Starts
import java.util.*;

public class QueueUsingStacks {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			Queues g = new Queues();

			int q = sc.nextInt();
			while (q > 0) {
				int QueryType = sc.nextInt();
				if (QueryType == 1) {
					int a = sc.nextInt();
					g.push(a);
				} else if (QueryType == 2)
					System.out.print(g.pop() + " ");
				q--;
			}
			System.out.println();

			t--;
		}
	}
}

// } Driver Code Ends

class Queues {
	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();

	/* The method pop which return the element poped out of the stack */
	int pop() {
		// Your code here
		if (q1.isEmpty())
			return -1;
		int res = 0;
		int c = 0;
		while(!q1.isEmpty()) {
			res = q1.remove();
			q2.add(res);
			c++;
		}
		while(!q2.isEmpty() && c > 1) {
			q1.add(q2.remove());
			c--;
		}
		q2.remove();
		return res;
	}

	/* The method push to push element into the stack */
	void push(int a) {
		// Your code here
		q1.add(a);
	}
}
