/*
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
 

Example 1:


Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]

Output: true
 */
package com.leetcodes1;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Set<String> set = new HashSet<>();
		int n = board.length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] != '.') {
					if (!set.add(board[i][j] + "found in" + i + "row")
							|| !set.add(board[i][j] + "found in" + j + "column")
							|| !set.add(board[i][j] + "found in" + (i / 3) + "," + (j / 3) + "submatrix")) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {


	}

}
