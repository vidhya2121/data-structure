package com.amaze.strings;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class ReverseWords {
/*
 * Input:
		2
		i.like.this.program.very.much
		pqr.mno
		
	Output:
		much.very.program.this.like.i
		mno.pqr
 */
	public static void main(String[] args) {
		String str = "i.like.this.program.very.much";
		/*
		 * convert str to String[] using split(.)
		 * loop from length-1 to 0
		 * 		if i == 0  append i th word to res
		 * 		else
		 * 			append ith word + . to res
		 */
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
