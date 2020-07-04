package com.amaze.array;

import java.util.Arrays;

public class PowerOf {

	public static void main(String[] args) {

		long a[] = { 335,1,170,225,479,359,463,465,206,146,282,328,462,492,496,443,328,437,392,105,403,154,293,383,422,217,219,396,448,227,272,39,370,413,168,300,36,395,204,312,323,334};
		long b[] = { 174,165,142,212,254,369,48,145,163,258,38,360,224,242,30,279,317,36,191,343,289,107,41,443,265,149,447,306,391,230,371,351,7,102,394,49,130,124,85,455,257,341,467,377,432,309,445,440,127,324,38,39,119,83,430,42,334,116,140,159,205,431,478,307,174,387,22,246};
		long count = optPowerOfG(a, b);
		System.out.println(count);
	}

	public static int countPairsBruteForce(double X[], double Y[], int m, int n) {
		int ans = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (Math.pow(X[i], Y[j]) > Math.pow(Y[j], X[i])) {
					System.out.println(X[i] + " \t" + Y[j] + " \tyes");
					ans++;
				}
			}
		}
		return ans;
	}

	private static long optPowerOfG(long[] a, long[] b) {
		Arrays.sort(b);
		long freq[] = new long[5];
		for (int j = 0; j < b.length; j++) {
			if (b[j] < 5) {
				freq[(int) b[j]]++;
			}
		}
		long count = 0;
		for (int i = 0; i < a.length; i++) {
			int idx = -1;
			if (a[i] == 0) {
				continue;
			}
			if (a[i] == 1) {
				count = count + freq[0];
				continue;
			}
			int j;
			for (j = 0; j < b.length; j++) {
				if (b[j] > a[i]) {
					idx = j;
					System.out.println(idx + "----------");
					break;
				}
			}
			if (idx==-1) idx=j;
			count = count + (b.length - idx) + freq[0] + freq[1];
			if (a[i] == 2) {
				count = count - freq[3] - freq[4];
			}
			if (a[i] == 3) {
				count = count + freq[2];

			}

		}
		return count;
	}

	private static long xeros(long[] b) {
		int c = 0;
		for (int j = 0; j < b.length; j++) {
			if (b[j] == 0) {
				c++;
			}
		}
		return c;
	}

}
