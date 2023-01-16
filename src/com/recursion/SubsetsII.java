/*
 * Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
 */

package com.recursion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		helper(result, new ArrayList<>(), 0, nums);
		return result;
	}

	private void helper(List<List<Integer>> result, List<Integer> list, int index, int[] nums) {
		result.add(new ArrayList<>(list));
		for (int i = index; i < nums.length; i++) {
			if (i > index && nums[i] == nums[i - 1]) {
				continue;
			}
			list.add(nums[i]);
			helper(result, list, i + 1, nums);
			list.remove(list.size() - 1);

		}
	}
}
