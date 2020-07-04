package com.amaze.array;

public class LastOne {

	public static void main(String[] args) {

		String str = "01000001";
		char c[] = str.toCharArray();
		for(int i = c.length-1;i>=0;i--) {
			if(c[i]=='1') {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}

}
