/*
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 Input: board = [["A","B","C","E"],
 				 ["S","F","C","S"],
 				 ["A","D","E","E"]], 
word = "ABCCED"
Output: true
 */

package com.recursion;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, i, j, 0, word)) {
					return true;
				}

			}
		}
		return false;
	}

	public boolean dfs(char[][] board, int r, int c, int i, String word) {
		if (i >= word.length()) {
			return true;
		}
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || word.charAt(i) != board[r][c]) {
			return false;
		}

		boolean exist = false;
		if (board[r][c] == word.charAt(i)) {
			board[r][c] += 100;
			exist = dfs(board, r + 1, c, i + 1, word) || dfs(board, r - 1, c, i + 1, word)
					|| dfs(board, r, c + 1, i + 1, word) || dfs(board, r, c - 1, i + 1, word);

			board[r][c] -= 100;
		}
		return exist;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
