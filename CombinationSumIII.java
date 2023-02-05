/*
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
 */
package com.leetcodes1;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {

	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		if (k > n) {
			return result;
		}
		List<Integer> list = new ArrayList<>();
		helper(result, k, n, list, 1);
		return result;
	}

	public static void helper(List<List<Integer>> result, int k, int n, List<Integer> list, int start) {
		if (n == 0 && k == list.size()) {
			result.add(new ArrayList<>(list));
			return;
		} else if (n == 0 || k == list.size() || n < 0) {
			return;
		}

		for (int i = start; i <= 9; i++) {
			list.add(i);
			helper(result, k, n - i, list, i + 1);
			list.remove(list.size() - 1);
		}

	}




	public static void main(String[] args) {
		System.out.println(combinationSum3(3, 9));
	}

}
