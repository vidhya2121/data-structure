package com.amaze.strings;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class ReverseWords {

	public static void main(String[] args) {
		String str = "i.like.this.program.very.much";
		// System.out.println(Arrays.toString(str.split("\\.")));
		// StringBuffer rev = new StringBuffer();
		//
		// for(String s : str.split("\\.")) {
		// String revEach = "";
		// for(char c : s.toCharArray()) {
		// revEach = c + revEach;
		// }
		// rev.append(revEach+".");
		// }
		// System.out.println(rev);
		// String finalRes = "";
		// for(char ch : rev.toString().toCharArray()) {
		// finalRes = ch + finalRes;
		// }
		// System.out.println(finalRes.substring(1));

		String[] strArr = str.split("\\.");
		StringBuilder sb = new StringBuilder();
		for (int i = strArr.length - 1; i >= 0; i--) {
			if (i == 0) {
				sb.append(strArr[i]);
			} else {
				sb.append(strArr[i] + ".");
			}
		}
		System.out.println(sb);
	}

}
