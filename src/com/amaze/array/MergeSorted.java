package com.amaze.array;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MergeSorted {

	public static void main(String[] args) {
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
		int a[] = { 1, 3, 5, 7, 9 };
		int b[] = { 2, 4, 6, 8 };
		int i, j;
		for (i = 0, j = 0; i < a.length && j < b.length;) {
			if (a[i] <= b[j]) {
				System.out.print(a[i] + " ");
				i++;
			} else {
				System.out.print(b[j] + " ");
				j++;
			}
		}
		while (i < a.length) {
			System.out.print(a[i] + " ");
			i++;
		}
		while (j < b.length) {
			System.out.print(b[j] + " ");
			j++;
		}
		System.out.println();
		SimpleDateFormat formatter2= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date2 = new Date(System.currentTimeMillis());
		System.out.println(formatter2.format(date2));
	}
	

}
