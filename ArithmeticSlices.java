/*
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.

A subarray is a contiguous subsequence of the array.

Input: nums = [1,2,3,4]
Output: 3
Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 */
package com.leetcodes1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArithmeticSlices {

	public int numberOfArithmeticSlices(int[] nums) {
		int count = 0;
		if (nums.length < 3) {
			return 0;
		}
		for (int i = 0; i < nums.length - 2; i++) {
			int diff = nums[i + 1] - nums[i];
			for (int j = i + 2; j < nums.length; j++) {
				if (nums[j] == nums[j - 1] + diff) {
					count++;
				} else {
					break;
				}
			}
		}

		return count;
	}

	public static int[] separateDigits(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int num : nums) {
			int digit = (int) Math.log10(num);
			while (digit >= 0) {
				list.add(num / (int) (Math.pow(10, digit)));
				digit--;
			}
		}

		int[] result = new int[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(separateDigits(new int[] { 1, 23, 34, 3 })));
	}
}
