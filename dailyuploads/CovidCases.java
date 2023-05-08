package com.dailyuploads;

import java.util.Arrays;
import java.util.Stack;

public class CovidCases {

	public static int[] covidCases(int[] cases) {
		int[] result = new int[cases.length];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < cases.length; i++) {
			while (!stack.isEmpty() && cases[stack.peek()] > cases[i]) {
				int day1 = stack.pop();
				result[day1] = i - day1;
			}
			stack.push(i);
		}

		return result;
	}

	public static void main(String[] args) {
		int[] cases = { 1273, 1274, 1275, 1271, 1269, 1272, 1276, 1273 };
		System.out.println(Arrays.toString(covidCases(cases)));
	}
}
