package com.amaze.strings;

public class RemoveAdjacentDup {

	public static void main(String[] args) {
		String str = "mississipie";
		String res = "";
		res = remove(str, res);
		System.out.println(res);
	}
/*
 * Given a string s, recursively remove adjacent duplicate characters from the string s.
 *  The output string should not have any adjacent duplicates.
 */
	/*
	 * Input:
			2
			geeksforgeek
			acaaabbbacdddd
			
		Output:
			gksforgk
			acac
	 */
	/*remove(str, "")
	 * set flag as 0
	 * loop 0 to length
	 * 		set prev as i-1 curr as i and next as i+1
	 * 		if prev >= 0 
	 * 			if char at prev equals char at current
	 * 				flag=1 continue
	 * 		if next < length
	 * 			if char at next equals char at curr
	 * 				flag=1 continue
	 * 		res + char at curr
	 * 		if flag is 0 return str
	 * return remove(res, "")
	 */
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