package com.amaze.heap;

import java.util.Scanner;

public class MinHeapDefiniton {
	// { Driver Code Starts
	// Initial Template for Java

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int a = sc.nextInt();
			MinHeap h = new MinHeap(a);
			for (int i = 0; i < a; i++) {
				int c = sc.nextInt();
				int n;
				if (c == 1) {
					n = sc.nextInt();

					h.insertKey(n);
				}
				if (c == 2) {
					n = sc.nextInt();
					h.deleteKey(n);
				}
				if (c == 3) {
					System.out.print(h.extractMin() + " ");
				}
			}
			System.out.println();
		}
	}
}
/*
 * You are given an empty Binary Min Heap and some queries and your task is to implement the three methods insertKey,  deleteKey,  and extractMin on the Binary Min Heap and call them as per the query given below:
1) 1  x  (a query of this type means to insert an element in the min-heap with value x )
2) 2  x  (a query of this type means to remove an element at position x from the min-heap)
3) 3  (a query like this removes the min element from the min-heap and prints it ).

Example 1:

Input:
Q = 7
Queries = 1 4 1 2 3 1 6 2 0 3 3
Output: 2 6 - 1
Explanation: In the first test case for
query 
1 4 the heap will have  {4}  
1 2 the heap will be {2 4}
3   removes min element from heap ie
    2 and prints it now heap is {4} 
1 6 inserts 6 to heap now heap is {4 6}
2 0 delete element at position 0 of the
    heap,now heap is {6}
3   remove min element from heap ie 6
    and prints it  now the heap is empty
3   since the heap is empty thus no min
    element exist so -1 is printed.
 */
/*
 * class member variables harr[] capacity size
 parent
 * 		return (i-1)/2
 left
 * 		return 2*i + 1
 right 
 * 		return 2*i + 2
 delete(index)
 * 		if index >= sizr then return;
 * 		decreaseKey(index, MIN)
 * 		extractMin()
 decreaseKey(index, val) // usage, when we need to delete element in given index then set element of that index as MIN 
 * 							//	and iteratively bring this to first. call etractMin
 * 		harr[index] =  val
 * 		loop index!=0 and parent(index) element > index element 
 * 			swap
 * 			index = parent(index) 
 extractMin() //remove first element and set last as first and call heapify, reduces heap size by 1
 * 		if size = 0 return -1
 * 		if size is 1 then size-- and return harr[0]
 * 		min = harr[0]
 * 		harr[0] = harr[size-1]
 * 		size--
 * 		heapify(0)
 * 		return min
 heapify(index)
 * 		l = left(index) r = right(index)
 * 		if l < size and lth element < indexth element
 * 			smallest = l
 * 		if r < size and rth element < smallestth element
 * 			smallest = r
 * 		if index!= smallest swap
 * 		heapify(smallest)
 insert
 		if size reached return
 		harr[size] = key
 		i = size
 		size--
 		loop i!=0 and harr[parent(i)] > harr[i]
 			swap
 			i = parent(i)
 */
class MinHeap {
	int[] harr;
	int capacity;
	int heap_size;

	MinHeap(int cap) {
		heap_size = 0;
		capacity = cap;
		harr = new int[cap];
	}

	int parent(int i) {
		return (i - 1) / 2;
	}

	int left(int i) {
		return (2 * i + 1);
	}

	int right(int i) {
		return (2 * i + 2);
	}

	// You need to write code for below three functions
	int extractMin() {
		if (heap_size == 0)
			return -1;
		if (heap_size == 1) {
			heap_size--;
			return harr[0];
		}
		int min = harr[0];
		harr[0] = harr[heap_size - 1];
		heap_size--;
		MinHeapify(0);
		return min;
		// Your code here.
	}

	void insertKey(int k) {
		// Your code here.
		if (heap_size == capacity) {
			return;
		}
		harr[heap_size] = k;
		heap_size++;
		int i = heap_size - 1;
		while (harr[i] < harr[parent(i)] && i != 0) {
			int t = harr[i];
			harr[i] = harr[(parent(i))];
			harr[(parent(i))] = t;
			i = parent(i);
		}
	}

	void deleteKey(int i) {
		if (i >= heap_size)
			return;
		decreaseKey(i, Integer.MIN_VALUE);
		extractMin();
	}

	// Decrease key operation, helps in deleting the element
	void decreaseKey(int i, int new_val) {
		harr[i] = new_val;
		while (i != 0 && harr[parent(i)] > harr[i]) {
			int temp = harr[i];
			harr[i] = harr[parent(i)];
			harr[parent(i)] = temp;
			i = parent(i);
		}
	}

	/*
	 * You may call below MinHeapify function in above codes. Please do not delete
	 * this code if you are not writing your own MinHeapify
	 */
	void MinHeapify(int i) {
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if (l < heap_size && harr[l] < harr[i])
			smallest = l;
		if (r < heap_size && harr[r] < harr[smallest])
			smallest = r;
		if (smallest != i) {
			int temp = harr[i];
			harr[i] = harr[smallest];
			harr[smallest] = temp;
			MinHeapify(smallest);
		}
	}
}
