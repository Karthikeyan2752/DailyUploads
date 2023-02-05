package com.leetcodes1;

public class BattleShipsInABoard {
	public static int countBattleships(char[][] board) {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 'X') {
					count++;
					helper(board, i, j);
				}
			}
		}
		return count;
	}

	public static void helper(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') {
			return;
		}
		board[i][j] = '.';
		helper(board, i + 1, j);
		helper(board, i - 1, j);
		helper(board, i, j + 1);
		helper(board, i, j - 1);
	}
	public static void main(String[] args) {
		char[][] board = { { 'X', '.', '.', '.' }, { '.', '.', '.', 'X' }, { '.', '.', '.', 'X' } };
		System.out.println(countBattleships(board));
	}

}
