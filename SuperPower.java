/*
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

 

Example 1:

Input: a = 2, b = [3]
Output: 8
 */
package com.leetcodes1;

public class SuperPower {
	public final int M = 1337;

	public int superPow(int a, int[] b) {
		int result = 1;
		a %= M;
		int l = b.length - 1;
		for (int i = l; i >= 0; i--) {
			result = result * power(a, b[i]) % M;
			a = power(a, 10);
		}
		return result;
	}

	public int power(int a, int b) {
		int result = 1;
		while (b != 0) {
			if (b % 2 != 0) {
				result = result * a % M;
			}
			a = a * a % M;
			b /= 2;
		}
		return result;
	}
	public static void main(String[] args) {


	}

}
