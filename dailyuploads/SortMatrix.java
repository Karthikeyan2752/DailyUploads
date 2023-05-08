package com.dailyuploads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortMatrix {

	public static void sortVertical(int[][] matrix) {

		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				for (int k = j + 1; k < matrix.length; k++) {
					if (matrix[j][i] > matrix[k][i]) {
						int temp = matrix[j][i];
						matrix[j][i] = matrix[k][i];
						matrix[k][i] = temp;
					}
				}
			}
		}
	}

	public static void sortHorizontal(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				for (int k = j + 1; k < matrix[0].length; k++) {
					if (matrix[i][j] > matrix[i][k]) {
						int temp = matrix[i][j];
						matrix[i][j] = matrix[i][k];
						matrix[i][k] = temp;
					}
				}
			}
		}
	}

	public int[][] diagonalSort(int[][] mat) {

		for (int r = 0; r < mat.length; r++) {
			sort(mat, r, 0);
		}
		for (int c = 0; c < mat[0].length; c++) {
			sort(mat, 0, c);
		}
		return mat;
	}

	void sort(int[][] mat, int r, int c) {
		int i = r;
		int j = c;
		int index = 0;
		List<Integer> diag = new ArrayList<Integer>();
		while (r < mat.length && c < mat[0].length) {
			diag.add(mat[r++][c++]);
		}
		Collections.sort(diag);
		while (i < mat.length && j < mat[0].length) {
			mat[i++][j++] = diag.get(index++);
		}
	}

	public static void main(String[] args) {

		int[][] matrix = { { 5, 6, 9, 4 }, { 4, 1, 6, 5 }, { 2, 3, 3, 1 } };

		// sort vertically
		sortVertical(matrix);
		System.out.println("Sorted vertically:");
		for (int[] a : matrix) {
			System.out.println(Arrays.toString(a));
		}
	}
}
