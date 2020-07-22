package com.amaze.stack_queues;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		q.add(2);
		q.add(3);
		q.add(4);
		q.remove();
		System.out.println(q.toString());
	}

}
