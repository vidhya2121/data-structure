package com.amaze.array;

public class SubarraySum {

	public static void main(String[] args) {

		// Input:
		// 2
		// 5 12
		// 1 2 3 7 5
		// 10 15
		// 1 2 3 4 5 6 7 8 9 10
		// Output:
		// 2 4
		// 1 5
		int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		osubarray(arr1, 10, 15);
	}


	public static void osubarray(int a[], int n, int sum) {
		int start = 0;
		int end = 0;
		int curr_sum = 0;
		int flag = 0;
		for (int i = 0; i < n; i++) {
			curr_sum += a[i];
			end++;
			while (curr_sum > sum) {
				curr_sum -= a[start];
				start++;
			}
			if (curr_sum == sum) {
				System.out.println(start + 1 + " " + (end));
				flag = 1;
				break;
			} 
		}
		if(flag==0) {
			System.out.println(-1);
		}
	}
	// Scanner sc = new Scanner(System.in);
	// int x = sc.nextInt();
	// while(x > 0)
	// {
	// int n = sc.nextInt();
	// int sum = sc.nextInt();
	// int[] arr = new int[n];
	// for(int i=0;i<n;i++)
	// arr[i]= sc.nextInt();
	// subarray(arr, n, sum);
	// x--;
	// }
}
