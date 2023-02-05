/*
 * Given an integer array of size n, find all elements that appear more than  n/3  times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
 */
package com.leetcodes1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {

	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<>();

		Map<Integer, Integer> map = new HashMap<>();

		
		int count = nums.length / 3;

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i]) + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		for (Map.Entry<Integer, Integer> i : map.entrySet()) {
			if (i.getValue() > count) {
				result.add(i.getKey());
			}
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(Integer.sum(0, 0));

	}

}
