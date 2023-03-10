/*
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
 */
package com.leetcodes1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsII {

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}
		backtrack(map, result, new ArrayList<>(), nums);
		return result;
	}

	public void backtrack(Map<Integer, Integer> map, List<List<Integer>> result, ArrayList<Integer> list, int[] nums) {
		if (list.size() == nums.length) {
			result.add(new ArrayList<>(list));
			return;
		}

		for (int key : map.keySet()) {
			if (map.get(key) > 0) {
				list.add(key);
				map.put(key, map.get(key) - 1);
				backtrack(map, result, list, nums);
				map.put(key, map.get(key) + 1);
				list.remove(list.size() - 1);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
