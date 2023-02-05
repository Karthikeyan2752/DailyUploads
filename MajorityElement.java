/*
 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than n / 2 times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
 */
package com.leetcodes1;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		int result = 0;
		int a = nums[0];
		Map<Integer, Integer> map = new HashMap<>();

		int count = nums.length / 2;

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> i : map.entrySet()) {
			if (i.getValue() > count) {
				if (result < i.getValue()) {
					result = i.getValue();
					a = i.getKey();
				}
			}
		}

		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
