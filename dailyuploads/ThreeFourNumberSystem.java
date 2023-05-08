package com.dailyuploads;

import java.util.Scanner;

public class ThreeFourNumberSystem {

	public static void printNthNumber(int n) {
		int i = 1;
		while (n != 0) {
			int a = i;
			int count = 0;
			
			while (a > 0) {
				int r = a % 10;
				a = a / 10;
				count++;
				if ((r == 3 || r == 4) && count == 0) {
					count--;
				}
			}

			if (count == 0) {
				System.out.println(i);
				n--;
			}
			i++;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int n = sc.nextInt();
		printNthNumber(n);

		sc.close();
	}
}
