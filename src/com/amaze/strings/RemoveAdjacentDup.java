package com.amaze.strings;

public class RemoveAdjacentDup {

	public static void main(String[] args) {
		String str = "mississipie";
		String res = "";
		res = remove(str, res);
		System.out.println(res);
	}

	private static String remove(String str, String res) {
		int flag = 0;
		for (int i = 0; i < str.length(); i++) {
			int prev = i - 1;
			int next = i + 1;
			int curr = i;

			if (prev >= 0) {
				if (str.charAt(prev) == str.charAt(curr)) {
					flag = 1;
					continue;
				}
			}
			if (next < str.length()) {
				if (str.charAt(next) == str.charAt(curr)) {
					flag = 1;
					continue;
				}
			}
			res += str.charAt(curr);
		}
		if (flag == 0) {
			return str;
		}
		return remove(res, "");
	}

}