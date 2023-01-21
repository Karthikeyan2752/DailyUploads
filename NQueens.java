/*
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
 */

/*
 * example:
 * Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
 */

package com.recursion;

import java.util.ArrayList;
import java.util.List;

class NQueens {
	public static List<List<String>> solveNQueens(int n) {
		boolean[][] b = new boolean[n][n];
		List<List<String>> result = new ArrayList<>();
		nQueens(b, 0, result);
		return result;
	}

	static int nQueens(boolean[][] b, int row, List<List<String>> result) {
		if (row == b.length) {
			toList(b, result);
			System.out.println();
			return 1;
		}

		int count = 0;

		for (int col = 0; col < b[0].length; col++) {
			if (isSafe(b, row, col)) {
				b[row][col] = true;
				count += nQueens(b, row + 1, result);
				b[row][col] = false;
			}
			}
		return count;
		}

	private static boolean isSafe(boolean[][] b, int row, int col) {

		// vertical
		for (int i = 0; i < row; i++) {
			if (b[i][col]) {
				return false;
			}
		}

		// left diagonal
		int maxLeft = Math.min(row, col);
		for (int j = 1; j <= maxLeft; j++) {
			if (b[row - j][col - j]) {
				return false;
			}
		}

		// right diagonal
		int maxRight = Math.min(row, b.length - col - 1);
		for (int k = 1; k <= maxRight; k++) {
			if (b[row - k][col + k]) {
				return false;
			}
		}
		return true;
	}

	private static void toList(boolean[][] b, List<List<String>> result) {
		List<String> list = new ArrayList<>();
		for (boolean[] row : b) {
			StringBuilder sb = new StringBuilder();
			for (boolean element : row) {
				if (element) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
				}
			list.add(sb.toString());
			}
		result.add(list);
		}

	public static void main(String[] args) {
		System.out.println(solveNQueens(4));
	}
}