package com.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursionRunner {
	static int fibonacci(int n) {
		if (n < 2) {
			return n;
		}

		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	static int binarySearch(int[] a, int target, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = start + (end - start) / 2;

		if (a[mid] == target) {
			return mid;
		}

		if (a[mid] < target) {
			return binarySearch(a, target, mid + 1, end);
		}
		return binarySearch(a, target, start, mid - 1);
	}

	static void print(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(n);
		print(n - 1);

	}

	static int factorial(int n) {
		if (n <= 1) {
			return n;
		}
		return n * factorial(n - 1);

	}

	static int sumDigits(int n) {
		if (n % 10 == n) {
			return n;
		}
		return n % 10 + sumDigits(n / 10);

	}

	static int productDigits(int n) {
		if (n == 0) {
			return 1;
		}
		return n % 10 * productDigits(n / 10);

	}

	static int reverse(int n) {
		int digits = (int) (Math.log10(n));
		return helper(n, digits);
	}

	private static int helper(int n, int digits) {
		if (n % 10 == 0) {
			return n;
		}
		int r = n % 10;
		return r * (int) (Math.pow(10, digits)) + helper(n / 10, digits - 1);
	}

	static int countZeros(int n) {
		return count(n, 0);
	}

	private static int count(int n, int c) {
		if (n == 0) {
			return c;
		}
		if (n % 10 == 0) {
			return count(n / 10, c + 1);
		}
		return count(n / 10, c);
	}

	// arrays

	static boolean isSorted(int[] a, int index) {
		if (index == a.length - 1) {
			return true;
		}
		return a[index] < a[index + 1] && isSorted(a, index + 1);
	}

	static int search(int[] a, int target, int index) {
		if (index == a.length) {
			return -1;
		}
		if (a[index] == target) {
			return index;
		}
		return search(a, target, index + 1);
	}

	static ArrayList<Integer> findI(int[] a, int target, int index) {

		ArrayList<Integer> list = new ArrayList<>();

		if (index == a.length) {
			return list;
		}

		if (a[index] == target) {
			list.add(index);
		}

		ArrayList<Integer> result = findI(a, target, index + 1);

		list.addAll(result);

		return list;
	}

	static int BS(int[] a, int target, int s, int e) {
		if (s > e) {
			return -1;
		}

		int m = s + (e - s) / 2;

		if (a[m] == target) {
			return m;
		}

		if (target < a[m]) {
			return BS(a, target, s, m - 1);
		}
		return BS(a, target, m + 1, e);
	}

	static void printPattern(int r, int c) {
		if (r == 0) {
			return;
		}
		if (r > c) {
			printPattern(r, c + 1);
			System.out.print("*");

		} else {
			printPattern(r - 1, 0);
			System.out.println();

		}

	}

	static void bubbleSort(int[] a, int r, int c) {
		if (r == 0) {
			return;
		}

		if (r > c) {

			if (a[c] > a[c + 1]) {
				int temp = a[c];
				a[c] = a[c + 1];
				a[c + 1] = temp;

			}

			bubbleSort(a, r, c + 1);

		} else {
			bubbleSort(a, r - 1, 0);

		}

	}

	static void selectionSortI(int[] a) {
		for (int i = 0; i < a.length; i++) {

			int e = a.length - i - 1;

			int max = getMaxIndex(a, 0, e);

			swap(a, max, e);
		}
	}

	static void selectionSortR(int[] a, int r, int c, int max) {
		if (r == 0) {
			return;
		}

		if (r > c) {

			if (a[c] > a[max]) {
				selectionSortR(a, r, c + 1, c);
			} else {
				selectionSortR(a, r, c + 1, max);
			}

		} else {
			int temp = a[max];
			a[max] = a[r - 1];
			a[r - 1] = temp;
			selectionSortR(a, r - 1, 0, 0);
		}

	}

	static int getMaxIndex(int[] a, int s, int e) {
		int max = s;
		for (int i = s; i <= e; i++) {
			if (a[max] < a[i]) {
				max = i;
			}
		}
		return max;
	}

	static void swap(int a[], int s, int e) {
		int temp = a[s];
		a[s] = a[e];
		a[e] = temp;
	}

	public static void mergeSortR(int[] a, int s, int e) {
		if (e - s == 1) {
			return;
		}

		int m = (e + s) / 2;

		mergeSortR(a, s, m);
		mergeSortR(a, m, e);

		mergeInPlace(a, s, m, e);
	}

	private static void mergeInPlace(int[] a, int s, int m, int e) {
		int[] result = new int[e - s];
		int f = s;
		int j = m;
		int k = 0;

		while (f < m && j < e) {
			if (a[f] < a[j]) {
				result[k] = a[f];
				f++;

			} else {
				result[k] = a[j];
				j++;

			}
			k++;
		}
		while (f < m) {
			result[k] = a[f];
			f++;
			k++;
		}
		while (j < e) {
			result[k] = a[j];
			j++;
			k++;
		}

		for (int i = 0; i < result.length; i++) {
			a[s + i] = result[i];
		}
	}

	static void quickSort(int a[], int low, int high) {
		if (low >= high) {
			return;
		}
		int s = low;
		int e = high;
		int m = s + (e - s) / 2;
		int pivot = a[m];

		while (s <= e) {

			while (a[s] < pivot) {
				s++;
			}
			while (a[e] > pivot) {
				e--;
			}
			if (s <= e) {
				int temp = a[s];
				a[s] = a[e];
				a[e] = temp;
				s++;
				e--;
			}
		}
		quickSort(a, low, e);
		quickSort(a, s, high);
	}

	static String skip(String p, String up) {
		if (up.length() == 0) {
			return p;
		}
		char c = up.charAt(0);
		if (c == 'a') {
			return skip(p, up.substring(1));
		}
		return skip(p + c, up.substring(1));

	}

	static String skip1(String up) {
		if (up.length() == 0) {
			return "";
		}

		char c = up.charAt(0);

		if (c == 'a') {
			return skip1(up.substring(1));
		}
		return c + skip1(up.substring(1));
	}

	static String skipApple(String up) {
		if (up.isEmpty()) {
			return "";
		}
		if (up.startsWith("karthi")) {
			return skipApple(up.substring(6));
		}
		return up.charAt(0) + skipApple(up.substring(1));
	}

	static void subseq(String p, String up) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char c = up.charAt(0);

		subseq(p + c, up.substring(1));
		subseq(p, up.substring(1));
	}

	static ArrayList<String> subseqAL(String p, String up) {
		if (up.isEmpty()) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(p);
			return list;
		}

		char c = up.charAt(0);
		ArrayList<String> left = subseqAL(p, up.substring(1));
		ArrayList<String> right = subseqAL(p + c, up.substring(1));

		left.addAll(right);

		return left;
	}

	static void subseqAscii(String p, String up) {
		if (up.isEmpty()) {
			System.out.println(p);
			return;
		}
		char c = up.charAt(0);

		subseqAscii(p, up.substring(1));
		subseqAscii(p + c, up.substring(1));
		subseqAscii(p + (c + 0), up.substring(1));
	}



	static List<List<Integer>> permutation0WithDuplicates(int[] a) {
		Arrays.sort(a);
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (i > 0 && a[i] == a[i - 1]) {
				j = 1;
				continue;
			}
			int n = result.size();
			for (j = 0; j < n; j++) {
				List<Integer> list = new ArrayList<>(result.get(j));
				list.add(a[i]);
				result.add(list);
			}
		}

		return result;
	}

	public static void permutation1(String p, String up) {
		if (up.length() == 0) {
			System.out.println(p);
			return;
		}

		char c = up.charAt(0);

		for (int i = 0; i <= p.length(); i++) {
			String f = p.substring(0, i);
			String s = p.substring(i, p.length());
			permutation1(f + c + s, up.substring(1));
		}

	}

	public static ArrayList<String> permutation1AL(String p, String up) {
		if (up.length() == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}

		char c = up.charAt(0);
		ArrayList<String> result = new ArrayList<>();
		for (int i = 0; i <= p.length(); i++) {
			String f = p.substring(0, i);
			String s = p.substring(i, p.length());
			result.addAll(permutation1AL(f + c + s, up.substring(1)));
		}
		return result;

	}


	public static List<String> letterCombinations1(String p, String up) {

		if (up.length() == 0) {
			List<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		int digits = up.charAt(0) - '0';
		
		List<String> list = new ArrayList<>();
		for (int i = (digits - 1) * 3; i < digits * 3; i++) {
			char ch = (char) ('a' + i - 3);
			list.addAll(letterCombinations1(p + ch, up.substring(1)));
		}

		return list;
	}


	public static void setZeroes(int[][] matrix) {
		boolean isCol;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				isCol = true;
			}
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (matrix[0][0] == 0) {
			for (int j = 0; j < matrix[0].length; j++) {
				matrix[j][0] = 0;
				matrix[0][j] = 0;
			}
		}
	}

	static ArrayList<String> dice(String p, int target) {
		if (target == 0) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		ArrayList<String> list = new ArrayList<>();
		for (int i = 1; i <= 6 && i <= target; i++) {
			list.addAll(dice(p + i, target - i));
		}
		return list;
	}

	static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int countPaths(int r, int c) {
		if (r == 1 || c == 1) {
			return 1;
		}

		int left = count(r - 1, c);
		int d = count(r - 1, c - 1);
		int right = count(r, c - 1);

		return left + right + d;
	}

	static ArrayList<String> printPaths(String p, int r, int c) {
		if (r == 1 && c == 1) {
			ArrayList<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		ArrayList<String> list = new ArrayList<>();
		if (r > 1) {
			list.addAll(printPaths(p + "D", r - 1, c));
		}
		if (r > 1 && c > 1) {
			list.addAll(printPaths(p + "d", r - 1, c - 1));
		}

		if (c > 1) {

			list.addAll(printPaths(p + "R", r, c - 1));
		}

		return list;
	}

	static List<String> pathRestrictions(boolean[][] b, String p, int r, int c) {
		if (r == b.length - 1 && c == b[0].length - 1) {
			List<String> list = new ArrayList<>();
			list.add(p);
			return list;
		}
		List<String> list = new ArrayList<>();
		if (!b[r][c]) {
			return list;
		}

		if (r < b.length - 1) {
			list.addAll(pathRestrictions(b, p + 'D', r + 1, c));
		}

		if (c < b[0].length - 1) {
			list.addAll(pathRestrictions(b, p + 'R', r, c + 1));
		}
		return list;

	}

	static void printPath1(boolean[][] b, int[][] path, int step, String p, int r, int c) {
		if (r == b.length - 1 && c == b[0].length - 1) {
			path[r][c] = step;
			System.out.println(p);
			for (int[] a : path) {
				System.out.println(Arrays.toString(a));
			}
			System.out.println();

		}

		if (!b[r][c]) {
			return;
		}

		b[r][c] = false;
		path[r][c] = step;

		if (r < b.length - 1) {
			printPath1(b, path, step + 1, p + 'D', r + 1, c);
		}

		if (c < b[0].length - 1) {
			printPath1(b, path, step + 1, p + 'R', r, c + 1);
		}
		if (r > 0) {
			printPath1(b, path, step + 1, p + 'U', r - 1, c);
		}
		if (c > 0) {
			printPath1(b, path, step + 1, p + 'L', r, c - 1);
		}

		b[r][c] = true;
		path[r][c] = 0;

	}



		public static void main(String[] args) {
			System.out.println(2022 % 100);

		}

}
