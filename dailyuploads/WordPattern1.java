package com.dailyuploads;

public class WordPattern1 {

	public static void main(String[] args) {
		String s = "gunasekar";
		int n = s.length();

		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				if (r == c || r + c == n - 1 || c == n / 2) {
					System.out.print(s.charAt(r) + " ");
				} else if (r == n / 2) {
					System.out.print(s.charAt(c) + " ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

	}

}
