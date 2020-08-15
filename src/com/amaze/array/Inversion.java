package com.amaze.array;

import java.util.Scanner;

public class Inversion {

	public static void main(String[] args) {
		/*
		 * Given an array of positive integers. The task is to find inversion count of array.
			Inversion Count : For an array, inversion count indicates how far (or close) 
			the array is from being sorted. If array is already sorted then inversion count is 0. 
			If array is sorted in reverse order that inversion count is the maximum. 
			Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
		 */
		/*
		 * Input:
				1
				5
				2 4 1 3 5
				
			Output:
				3
		 */
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		while (x-- > 0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = sc.nextInt();
			/*
			 *  Perform merge sort and return count
			 *  Count is incremented in merge function when a[i] > b[j] as count + ( n1 - i)
			 */
			int c = mergeSort(a, 0, a.length - 1);
			System.out.println(c);
		}
	}

	private static int mergeSort(int[] a, int l, int r) {
		int count = 0;
		if (l < r) {
			int mid = (l + r) / 2;
			count = mergeSort(a, l, mid);
			count += mergeSort(a, mid + 1, r);
			count += merge(a, l, mid, r);
		}
		return count;
	}

	private static int merge(int[] a, int l, int mid, int r) {
		int count = 0;
		int n1 = mid - l + 1;
		int n2 = r - mid;
		int temp1[] = new int[n1];
		int temp2[] = new int[n2];
		for (int i = 0; i < n1; i++) {
			temp1[i] = a[i + l];
		}
		for (int i = 0; i < n2; i++) {
			temp2[i] = a[i + mid + 1];
		}
		int i = 0;
		int j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (temp1[i] <= temp2[j]) {
				a[k] = temp1[i];
				i++;
			} else {
				a[k] = temp2[j];
				j++;
				count = count + (n1 - i);
			}
			k++;
		}
		while (i < n1) {
			a[k] = temp1[i];
			i++;
			k++;
		}
		while (j < n2) {
			a[k] = temp2[j];
			j++;
			k++;
		}
		return count;
	}

}