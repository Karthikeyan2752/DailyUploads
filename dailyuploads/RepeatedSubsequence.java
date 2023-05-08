package com.dailyuploads;

public class RepeatedSubsequence {

	public static boolean repeatedSubsequence(String s) {
		int[] frequency = new int[26];
		for (char c : s.toCharArray()) {
			frequency[c - 'A']++;

			if (frequency[c - 'A'] > 2) {
				return true;
			}
		}
		s = "";
		for (int i = 0; i < 26; i++) {
			if (frequency[i] > 1) {
				for (int j = 0; j < frequency[i]; j++) {
					char c = (char) (i - 'A');
					s += c;
				}
			}
		}
		if (s.length() > 2 && !isPalindrome(s)) {
			return true;
		} else if (isPalindrome(s)) {
			if (s.length() % 2 != 0) {
				if (s.length() / 2 >= 1) {
					return s.charAt(s.length() / 2) == s.charAt((s.length() / 2) - 1);
				}
			}
			return false;
		}
		return true;

	}

	public static boolean isPalindrome(String s) {
		int i = 0, j = s.length() - 1;

		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		System.out.println(repeatedSubsequence("ABCD"));
	}

}
