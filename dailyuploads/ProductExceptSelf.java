package com.dailyuploads;

import java.util.Arrays;

public class ProductExceptSelf {

	public static int[] product(int[] a) {
		int[] result = new int[a.length];
		int prefix = 1;
		int n = a.length;
		for (int i = 0; i < n; i++) {
			result[i] = prefix;
			prefix *= a[i];
		}

		int postfix = 1;
		for (int i = n - 1; i >= 0; i--) {
			result[i] *= postfix;
			postfix *= a[i];
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(Arrays.toString(product(new int[] { 1, 2, 3, 4 })));

	}

}
