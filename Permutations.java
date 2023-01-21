/*
 * Given an array nums of distinct integers,
 *  return all the possible permutations. You can return the answer in any order.
 */

package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		permute1(result, nums, 0);
		return result;
	}

	private static void permute1(List<List<Integer>> result, int[] nums, int index) {
		if (index == nums.length) {
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				list.add(nums[i]);
			}
			result.add(list);
			return;
		}

		for (int i = index; i < nums.length; i++) {
			swap(nums, index, i);
			permute1(result, nums, index + 1);
			swap(nums, index, i);

		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	// second approach
	static void permute(int[] nums, List<List<Integer>> result, List<Integer> ds, boolean[] freq) {
		if (ds.size() == nums.length) {
			result.add(new ArrayList<>(ds));
			return;
		}

		for (int i = 0; i < nums.length; i++) {

			if (!freq[i]) {
				freq[i] = true;
				ds.add(nums[i]);
				permute(nums, result, ds, freq);
				ds.remove(ds.size() - 1);
				freq[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(permute(new int[] { 1, 2, 3 }));
	}
}
