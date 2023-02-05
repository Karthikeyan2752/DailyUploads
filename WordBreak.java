package com.leetcodes1;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
		wordDict.sort((first, second) -> Integer.compare(first.length(), second.length()));
		System.out.println(wordDict);
		for (String str : wordDict) {
			if (s.contains(str)) {

			}
		}
		return s.length() == 0;
	}
	public static void main(String[] args) {
		List<String> wordDict = Arrays.asList("car", "ca", "rs");
		System.out.println(wordBreak("cars", wordDict));
	}

}
