package com.stack_queues;

import java.util.Stack;

public class ParenthesesChecker {

	public static void main(String[] args) {

		String str = "{([])}";

		check(str);
	}

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
