/*
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
 */
package com.leetcodes1;

public class NumberOfIsland {
	public static int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					makeZero(i, j, grid);
					count++;
				}
			}
		}
		return count;
	}

	public static void makeZero(int r, int c, char[][] grid) {
		if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
			return;
		}
		grid[r][c] = '0';
		makeZero(r + 1, c, grid);// down
		makeZero(r, c + 1, grid);// right
		makeZero(r - 1, c, grid);// up
		makeZero(r, c - 1, grid);// left

	}

	public static void main(String[] args) {
		char[][] c = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		System.out.println(numIslands(c));
	}
}
