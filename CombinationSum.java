/*
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
 */
package com.recursion;
import java.util.ArrayList;
import java.util.List;
public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		backtrack(nums, result, list, target, 0);
		return result;
	}

	public static void backtrack(int[] nums, List<List<Integer>> result, List<Integer> list, int target, int index) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(list));

		} else if (target < 0 || index >= nums.length) {
			return;
		} else {

			list.add(nums[index]);
			backtrack(nums, result, list, target - nums[index], index + 1);
			list.remove(list.size() - 1);
			backtrack(nums, result, list, target, index + 1);

		}
	}

	public static void main(String[] args) {
		int nums[] = { 2, 2, 3, 7 };
		System.out.println(combinationSum(nums, 7));
	}

}
