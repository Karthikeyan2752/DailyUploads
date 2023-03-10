/*
 * Given an integer array nums, find a 
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

 

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
 */
package com.leetcodes1;

public class MaximumProductSubArray {

	public static int maxProduct(int[] nums) {
		int result = nums[0];
		int max = 1, min = 1;
		for (int i : nums) {
			int temp = i * max;
			max = Math.max(temp, Math.max(min * i, i));
			min = Math.min(temp, Math.min(min * i, i));
			result = Math.max(result, max);
		}
		return result;
	}

	public static void main(String[] args) {
		int a[] = { -3, -1, -1 };
		System.out.println(maxProduct(a));

	}

}
