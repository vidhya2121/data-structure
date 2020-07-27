package com.amaze.matrix;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class CommonRowElement {

	public static void main(String[] args) {
		int mat[][] = { { 1, 2, 3, 4, 5 }, { 2, 3, 4, 5, 6 }, { 3, 4, 5, 6, 7 }, { 4, 7, 9, 10, 11 } };
		int result = findCommon(mat);
		if (result == -1)
			System.out.print("No common element");
		else
			System.out.print("Common element is " + result);
	}

	private static int findCommon(int[][] mat) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<mat.length;i++) {
			for(int j=0;j<mat[0].length;j++) {
				if(map.containsKey(mat[i][j])) {
					map.put(mat[i][j], map.get(mat[i][j])+1);
				}else {
					map.put(mat[i][j], 1);
				}
			}
		}
		for(Entry<Integer, Integer> e : map.entrySet()) {
			if(e.getValue()==mat.length) {
				return e.getKey();
			}
		}
		return -1;
	}

}
