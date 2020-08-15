package com.amaze.array;

import java.util.Arrays;

public class RearrangeMaxMin {

	public static void main(String[] args) {
		/*
		 * Given a sorted array of positive integers. Your task is to rearrange  the array elements alternatively 
		 * i.e first element should be max value, second should be min value, 
		 * third should be second max, fourth should be second min and so on
		 */
		/*
		 * Input:
			2
			6
			1 2 3 4 5 6
			11 
			10 20 30 40 50 60 70 80 90 100 110
			
		   Output:
			6 1 5 2 4 3
			110 10 100 20 90 30 80 40 70 50 60
		 */
		int arr[] = { 12, 23, 28, 43, 44, 59, 60, 68, 70, 85, 88, 92, 124, 125, 136, 168, 171, 173, 179, 199, 212, 230,
				277, 282, 306, 314, 316, 325, 328, 336, 337, 363, 365, 368, 369, 371, 374, 387, 394, 414, 422, 427, 430,
				435, 457, 493, 506, 527, 531, 538, 541, 546, 568, 583, 650, 691, 730, 737, 751, 764, 778, 783, 785, 789,
				794, 803, 809, 815, 847, 858, 863, 874, 887, 896, 916, 920, 926, 927, 930, 957, 981, 997 };

		rearrange(arr);
		/*
		 * arr[i] += arr[max_index] % max_element * max_element will be used
		 * initilize min and max index
		 * initialize maxElement as one greater than the original max
		 * loop from 0 to n
		 * 		if i is even
		 * 			arr[i] = maxEl * (arr[max] % maxEl) + arr[i];
		 * 			max--
		 * 		else
		 * 			arr[i] = maxEl * (arr[min] % maxEl) + arr[i];
		 * 			min++
		 * print array -> each element /maxElement
		 */		 
			 	
	}

	public static void rearrange(int arr[]) {
		int min = 0;
		int max = arr.length - 1;
		int maxEl = arr[arr.length - 1] + 1;

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0) {
				arr[i] = maxEl * (arr[max] % maxEl) + arr[i];
				max--;
			} else {
				arr[i] = maxEl * (arr[min] % maxEl) + arr[i];
				min++;
			}
		}
		for (int i = 0; i < arr.length; i++)
			arr[i] = arr[i] / maxEl;
		System.out.println(Arrays.toString(arr));
	}

}

//997 12 981 23 957 28 930 43 927 44 926 59 920 60 916 68 896 70 887 85 874 88 863 92 858 124 847 125 815 136 809 168 803 171 794 173 789 179 785 199 783 212 778 230 764 277 751 282 737 306 730 314 691 316 650 325 583 328 568 336 546 337 541 363 538 365 531 368 527 369 506 371 493 374 457 387 435 394 430 414 427 422
//997 12 981 23 957 28 930 43 927 44 926 59,920,60,916,68,896,70,887,85,874 88,863,92,858,124,847,125,815,136,809,168,803,171,794,173,789,179,785,199,783,212,778,230,764,277,751,282,737,306,730,314,691,316,650,325,583,328,568,336,546,337,541,363,538,365,531,368,527,369,506,371,493,374,457,387,435,394,430,414,427,422
