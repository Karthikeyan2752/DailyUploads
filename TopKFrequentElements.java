/*
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
 */
package com.leetcodes1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TopKFrequentElements {
	public static int[] topKFrequent(int[] nums, int k) {
		List<Integer>[] bucket = new ArrayList[nums.length + 1];
		Map<Integer, Integer> map = new TreeMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		for (int key : map.keySet()) {
			int frequency = map.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList();
			}
			bucket[frequency].add(key);
		}
		int[] result = new int[k];
		int count = 0;

		for (int i = bucket.length - 1; i >= 0 && count < k; i++) {
			if (bucket[i] != null) {
				for (int j : bucket[i]) {
					result[count++] = j;
				}
			}
		}


		return result;
	}
	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = 2;
		System.out.println(topKFrequent(nums, k));

	}

}
