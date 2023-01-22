/*
 * Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */
package com.leetcodes1;

public class MaximumSumSubArray {
	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		int sum = 0;
		for (int i : nums) {
			sum += i;
			if (sum > max) {
				max = sum;
			}
			if (sum < 0) {
				sum = 0;
			}

		}
		return max;
	}
	public static void main(String[] args) {
		int[] a = { -3, -1, -1 };
		System.out.println(maxSubArray(a));

	}

}
