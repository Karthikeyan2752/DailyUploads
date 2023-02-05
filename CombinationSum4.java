package com.leetcodes1;

public class CombinationSum4 {

	public static int combinationSum4(int[] nums, int target) {
		int[] combinations = new int[target + 1];
		combinations[0] = 1;

		for (int i = 1; i < combinations.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (i - nums[j] >= 0) {
					combinations[i] += i - nums[j];
				}
			}
		}
		return combinations[target];
	}
	public static void main(String[] args) {


	}

}
