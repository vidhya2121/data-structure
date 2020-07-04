package com.amaze.array;

public class Equilibrium {

	public static void main(String[] args) {

		int arr[] = { 1,3,5,2,2};
		optEqil(arr);

	}
	
	private static int sum (int a[],int start,int end) {
		int s=0;
		for (int i = start; i < end; i++) {
			s+=a[i];
		}
		return s;
	}

	private static void optEqil(int arr[]) {
		int f_sum = 0;
		int r_sum = sum(arr, 0, arr.length);
		
		for(int i=0;i<arr.length;i++) {
			r_sum = r_sum - arr[i];
			if(f_sum==r_sum) {
				System.out.println(i+1);
				return;
			}
			f_sum=f_sum+arr[i];
		}
		System.out.println(-1);
	}

	private static void eqil(int[] arr) {
		int curr_f_sum = 0;
		int curr_r_sum = 0;
		int flag = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			curr_r_sum = 0;
			curr_f_sum += arr[i];
			for (int j = i + 2; j < arr.length; j++) {
				curr_r_sum += arr[j];
			}
			if (curr_f_sum == curr_r_sum) {
				flag = 1;
				System.out.println(i + 2);
				break;
			}
		}
		if (flag == 0) {
			System.out.println(-1);
		}
	}

}


//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
//while(t-->0){
//    int n = Integer.parseInt(br.readLine().trim());
//    int arr[] = new int[n];
//    String inputLine[] = br.readLine().trim().split(" ");
//    for(int i=0; i<n; i++){
//        arr[i]=Integer.parseInt(inputLine[i]);
//    }
//    System.out.println(getEquilibriamPoint(arr, n));
//}
