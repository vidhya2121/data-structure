package com.array;
import java.io.*;
import java.util.*;

public class FFFF {
	public static int binary(int n, int m, int x, int[] y) {
		int high = m - 1, low = 0;
		int ans = high + 1;
		while (high >= low) {
			int mid = (high + low) / 2;
			if (y[mid] > x) {
				ans = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int t = Integer.parseInt(br.readLine());
//		for (int g = 0; g < t; g++) {
//			String[] str = (br.readLine()).trim().split(" ");
			int n = 3;//Integer.parseInt(str[0]);
			int m = 2;//Integer.parseInt(str[1]);
			int[] x = { 2, 1 ,6};// new int[n];
//			str = (br.readLine()).trim().split(" ");
//			for (int i = 0; i < n; i++)
//				x[i] = Integer.parseInt(str[i]);
//			str = (br.readLine()).trim().split(" ");
			int[] y = { 1 ,5};//new int[m];
			int[] freq = new int[5];
			for (int i = 0; i < m; i++) {
//				y[i] = Integer.parseInt(str[i]);
				if (y[i] < 5)
					freq[y[i]]++;
			}
			Arrays.sort(y);
			long ans = 0;
			for (int i = 0; i < n; i++) {
				if (x[i] == 0)
					continue;
				if (x[i] == 1) {
					ans = ans + (long) freq[0];
					continue;
				}
				int ind = binary(n, m, x[i], y);
				System.out.println(ind);
				ans = ans + (long) (m - ind) + (long) freq[0] + (long) freq[1];
				if (x[i] == 2)
					ans = ans - (long) freq[3] - (long) freq[4];
				if (x[i] == 3)
					ans = ans + (long) freq[2];
			}
			System.out.println("####################");
			System.out.println(ans);
		}
}
