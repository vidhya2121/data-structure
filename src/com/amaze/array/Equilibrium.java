package com.amaze.array;

public class Equilibrium {

	public static void main(String[] args) {
		/*
		 * Given an array A of N positive numbers. The task is to find the position where equilibrium first occurs in the array. 
		 * Equilibrium position in an array is a position such that the sum of elements before it is equal 
		 * to the sum of elements after it.
		 */
		/*
		 * Input:
				2
				1
				1
				5
				1 3 5 2 2
				
			Output:
				1
				3
		 */
		int arr[] = { 1, 3, 5, 2, 2 };
		/*
		 * Have a utility method to return sum of elements from start to end index
		 * initialize f_sum as 0 and r_sum ad sum of elements from 0 to length
		 * loop from 0 to n
		 * 		update r_sum as r_sum - current element
		 *      if both sums are equal result is index+1
		 *      add current element to f_sum
		 */
		optEqil(arr);

	}

	private static int sum(int a[], int start, int end) {
		int s = 0;
		for (int i = start; i < end; i++) {
			s += a[i];
		}
		return s;
	}

	private static void optEqil(int arr[]) {
		int f_sum = 0;
		int r_sum = sum(arr, 0, arr.length);

		for (int i = 0; i < arr.length; i++) {
			r_sum = r_sum - arr[i];
			if (f_sum == r_sum) {
				System.out.println(i + 1);
				return;
			}
			f_sum = f_sum + arr[i];
		}
		System.out.println(-1);
	}

}

// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
// while(t-->0){
// int n = Integer.parseInt(br.readLine().trim());
// int arr[] = new int[n];
// String inputLine[] = br.readLine().trim().split(" ");
// for(int i=0; i<n; i++){
// arr[i]=Integer.parseInt(inputLine[i]);
// }
// System.out.println(getEquilibriamPoint(arr, n));
// }
