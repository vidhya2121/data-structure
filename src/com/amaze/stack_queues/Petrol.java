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

/*Suppose there is a circle. There are N petrol pumps on that circle. You will be given two sets of data.
1. The amount of petrol that every petrol pump has.
2. Distance from that petrol pump to the next petrol pump.
Find a starting point where the truck can start to get through the complete circle without exhausting its petrol in between.
Note :  Assume for 1 litre petrol, the truck can go 1 unit of distance.*/
/*
 * Input:
		N = 4
		Petrol = 4 6 7 4
		Distance = 6 5 3 5
	Output: 1
	Explanation: There are 4 petrol pumps with
		amount of petrol and distance to next
		petrol pump value pairs as {4, 6}, {6, 5},
		{7, 3} and {4, 5}. The first point from
		where truck can make a circular tour is
		2nd petrol pump. Output in this case is 1
		(index of 2nd petrol pump).
 */
class GfG {
	/*
	 * currPetrol = petrol[0] - distance[0]
	 * start = 0 end = 1
	 * if length is 1
	 * 		if currPetrol is < 0 then return -1
	 * 		else return 0
	 * while start!=end or currPetrol < 0
	 * 		while currPetrol < 0 and start!=end
	 * 			subtract (petrol[start]-distance[start]) from currPetrol
	 * 			start = start+1 % length
	 * 			if start = 0 return -1
	 * 		add petrol[end]-distance[end] to currPetrol
	 * 		end = end+1 % length 
	 * return start
	 */
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