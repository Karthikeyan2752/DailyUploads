package com.dailyuploads;

public class StringToHexadecimal {

	public static void StringToHex(String s) {
		String result = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int a = c;
			result += Integer.toHexString(a);

		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		StringToHex("hello world");
	}
}
