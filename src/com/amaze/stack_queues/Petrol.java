package com.amaze.stack_queues;

import java.util.*;

public class Petrol {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			sc.nextLine();
			String str = sc.nextLine();
			String arr[] = str.split(" ");
			int p[] = new int[n];
			int d[] = new int[n];
			int j = 0;
			int k = 0;
			for (int i = 0; i < 2 * n; i++) {
				if (i % 2 == 0) {
					p[j] = Integer.parseInt(arr[i]);
					j++;
				} else {
					d[k] = Integer.parseInt(arr[i]);
					k++;
				}
			}

			System.out.println(new GfG().tour(p, d));
			t--;
		}
	}
}// } Driver Code Ends

// In java function tour() takes two arguments array of petrol
// and array of distance
class GfG {
	int tour(int petrol[], int distance[]) {
		int currPetrol = petrol[0] - distance[0];
		int start = 0;
		int end = 1;
		if (petrol.length == 1) {
			if (petrol[0] - distance[0] < 0)
				return -1;
			else
				return 0;
		}
		while (start != end || currPetrol < 0) {
			while (currPetrol < 0 && start != end) {
				currPetrol -= petrol[start] - distance[start];
				start = (start + 1) % petrol.length;
				if (start == 0)
					return -1;
			}
			currPetrol += petrol[end] - distance[end];
			end = (end + 1) % petrol.length;
		}
		return start;
	}
}