/*
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

 

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
package com.leetcodes1;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int max = 1;
		for (int num : nums) {
			if (!set.contains(num - 1)) {
				int count = 1;
				while (set.contains(num + 1)) {
					num++;
					count++;
				}
				max = Math.max(count, max);
			}

		}
		return max;
	}
	public static void main(String[] args) {


	}

}
