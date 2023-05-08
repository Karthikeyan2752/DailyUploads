package com.dailyuploads;

public class WordSearch {
	public static boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, i, j, 0, word)) {
					return true;
				}

			}
		}
		return false;
	}

	public static boolean dfs(char[][] board, int r, int c, int i, String word) {
		if (i >= word.length()) {
			return true;
		}
		if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || word.charAt(i) != board[r][c]) {
			return false;
		}

		boolean exist = false;
		if (board[r][c] == word.charAt(i)) {
			board[r][c] += 50;
			exist = dfs(board, r + 1, c, i + 1, word) || dfs(board, r, c + 1, i + 1, word);

			board[r][c] -= 50;
		}
		return exist;
	}

	public static void main(String[] args) {

		char[][] c = { { 'a', 'z', 'o', 'l' }, { 'n', 'x', 'h', 'o' }, { 'v', 'y', 'i', 'v' }, { 'o', 'r', 's', 'e' } };
		String[] s = { "van", "zoho", "love", "are", "is" };
		for (String str : s) {
			if (exist(c, str)) {
				System.out.println(str);
			}
		}

	}

}