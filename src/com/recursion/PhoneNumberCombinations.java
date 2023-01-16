/*
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 */

package com.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PhoneNumberCombinations {
	public List<String> letterCombinations(String up) {
		if (up.isEmpty()) {
			return new ArrayList<>();
		}
		Map<Character, String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl", '6', "mno", '7', "pqrs",
				'8', "tuv", '9', "wxyz");
		List<String> result = new ArrayList<>();
		backtrack(up, "", 0, result, map);
		return result;
	}

	private void backtrack(String up, String p, int index, List<String> result, Map<Character, String> map) {
		if (p.length() == up.length()) {
			result.add(p);
			return;
		} else if (index >= up.length()) {
			return;
		} else {
			String s = map.get(up.charAt(index));
			for (char c : s.toCharArray()) {
				backtrack(up, p + c, index + 1, result, map);
			}
		}

	}
}
