package com.recursion;

/*
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 package com.recursion;
 
 Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public static List<List<Integer>> combinationSum2(int[] a, int target) {
		Arrays.sort(a);
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		backtrack(result, list, a, target, 0);
		return result;
	}

	private static void backtrack(List<List<Integer>> result, List<Integer> list, int[] a, int target, int index) {
		if (target == 0) {
			result.add(new ArrayList<>(list));
		} else if (target <= 0) {
			return;
		} else {
			for (int i = index; i < a.length; i++) {
				if (i > index && a[i] == a[i - 1]) {
					continue;
				}
				list.add(a[i]);
				backtrack(result, list, a, target - a[i], index + 1);
				list.remove(list.size() - 1);
			}
		}

	}
	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[] { 2, 2, 2, 3, 7 }, 7));

	}

}
