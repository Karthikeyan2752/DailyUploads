/*
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Please implement encode and decode

Example
Example1

Input: ["lint","code","love","you"]
Output: ["lint","code","love","you"]
Explanation:
One possible encode method is: "lint:;code:;love:;you"
 */
package com.leetcodes1;
import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {

	public static String encode(List<String> strs) {
		// write your code here
		String result = "";
		for (String s : strs) {
			result += s.length() + "#" + s;
		}
		return result;
	}

	/*
	 * @param str: A string
	 * 
	 * @return: dcodes a single string to a list of strings
	 */
	public static List<String> decode(String str) {
		// write your code here
		List<String> result = new ArrayList<>();
		int i = 0;
		while (i < str.length()) {
			int j = i;
			while (str.charAt(j) != '#') {

				j++;
			}
			int val = Integer.parseInt(str.substring(i, j));
			i = j + 1 + val;
			result.add(str.substring(j + 1, i));

		}
		return result;
	}
	public static void main(String[] args) {
		List<String> str = List.of("lint", "code", "love", "you");
		System.out.println(encode(str));
		System.out.println(decode(encode(str)));

	}

}
