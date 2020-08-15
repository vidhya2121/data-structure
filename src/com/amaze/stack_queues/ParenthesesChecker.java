package com.amaze.stack_queues;

import java.util.Stack;

public class ParenthesesChecker {

	public static void main(String[] args) {

		String str = "{([])}";

		check(str);
	}
	
	/*
	 * Input:
			3
			{([])}
			()
			([]
			
		Output:
			balanced
			balanced
			not balanced
	 */
	/*
	 * initialize a stack
	 * for each char in string
	 * 		if char equals open brackets push it
	 * 		else
	 * 			if stack empty then not balanced
	 * 			pop from stack
	 * 			if curr char equals } then poped not equals { then not balanced
	 * 			same for else if's
	 * if stack not empty then not balanced
	 * balanced
	 */
	private static void check(String str) {
		Stack<String> stack = new Stack<String>();

		for (String s : str.split("")) {
			if (s.equals("{") || s.equals("[") || s.equals("(") || s.equals("<")) {
				stack.push(s);
			} else {
				if(stack.empty()) {
					System.out.println("not balanced");
					return;
				}
				String d = stack.pop();
				if (s.equals("}") && !d.equals("{")) {
					System.out.println("not balanced");
					return;
				} else if (s.equals("]") && !d.equals("[")) {
					System.out.println("not balanced");
					return;
				} else if (s.equals(")") && !d.equals("(")) {
					System.out.println("not balanced");
					return;
				} else if (s.equals(">") && !d.equals("<")) {
					System.out.println("not balanced");
					return;
				}
			}
		}
		if (!stack.empty()) {
			System.out.println("not balanced");
			return;
		}
		System.out.println("balanced");
	}

}
