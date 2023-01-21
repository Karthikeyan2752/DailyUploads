/*
 * Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

example:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 */
package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	static List<List<Integer>> permutation0(int[] a) {
		List<List<Integer>> result = new ArrayList<>();

		result.add(new ArrayList<>());

		for (int num : a) {
			int n = result.size();
			for (int i = 0; i < n; i++) {
				List<Integer> list = new ArrayList<>(result.get(i));
				list.add(num);
				result.add(list);

			}
		}
		return result;
	}

	public static void main(String[] args) {

	}
}
