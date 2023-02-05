/*
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
 */
package com.leetcodes1;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;
		s = s.trim().toLowerCase();
		while (i < j) {
			if (s.charAt(i) < 'a' || s.charAt(i) > 'z') {
				i++;
				continue;
			} else if (s.charAt(j) < 'a' || s.charAt(j) > 'z') {
				j--;
				continue;
			} else if (s.charAt(i) == s.charAt(j)) {
				i++;
				j--;
			} else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println(isPalindrome("0P"));

	}

}
