package com.dailyuploads;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakeDuplicatesZero {
	public static void makeZero(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (!set.add(arr[i])) {
				arr[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 5, 6, 9, 5 };
		makeZero(arr);
		System.out.println(Arrays.toString(arr));
	}
}
