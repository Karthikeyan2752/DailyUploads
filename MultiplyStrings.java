/*
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

 

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
 */
package com.leetcodes1;

public class MultiplyStrings {

	public static String multiply(String num1, String num2) {

		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}

		StringBuilder first = new StringBuilder(num1);
		StringBuilder second = new StringBuilder(num2);
		StringBuilder result = new StringBuilder();

		first.reverse();
		second.reverse();

		int resultLen = first.length() + second.length();

		for (int i = 0; i < resultLen; i++) {
			result.append("0");
		}

		for (int i = 0; i < second.length(); i++) {
			int digit2 = second.charAt(i) - '0';

			for (int j = 0; j < first.length(); j++) {
				int digit1 = first.charAt(j) - '0';

				int pos = i + j;
				int carry = result.charAt(pos) - '0';
				int product = digit1 * digit2 + carry;

				result.setCharAt(pos, (char) (product % 10 + '0'));
				int value = (result.charAt(pos + 1) - '0') + (product / 10);
				result.setCharAt(pos + 1, (char) (value + '0'));
			}
		}
		if (result.charAt(result.length() - 1) == '0') {
			result.deleteCharAt(result.length() - 1);
		}
		result.reverse();

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(multiply("10", "12"));

	}

}
