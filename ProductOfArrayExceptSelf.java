/*
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
 */
package com.leetcodes1;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		int prefix = 1;
		for (int i = 0; i < n; i++) {
			result[i] = prefix;
			prefix *= nums[i];
		}
		int postfix = 1;
		for (int i = n - 1; i >= 0; i--) {
			result[i] *= postfix;
			postfix *= nums[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };


		System.out.println(Arrays.toString(productExceptSelf(a)));
	}

}
