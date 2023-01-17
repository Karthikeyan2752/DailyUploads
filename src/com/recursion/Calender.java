package com.recursion;

import java.util.Scanner;

public class Calender {

	/*
	 * how to find the day with month and date : https://youtu.be/mLD41elDRTE
	 * 
	 */

	private static String[] days = { "Sun", "Mon", "Tue", "Ted", "Thu", "Fri", "Sat" };
	private static int[] monthNumbers = {0,3,3,6,1,4,6,2,5,0,3,5};
	private static int firstDayOfMonth;

	public static void printWeeks() {
		for (int i = 0; i < days.length; i++) {
			System.out.printf(days[i] + "\t");
		}
		System.out.println();
	}
	
	/*
	 * find year number is used to return the specific number of the year in a
	 * range, which is used to calculate the first day of the month.
	 */

	public static int findYearNumber(int year) {

		if (year >= 1600 && year <= 1699) {
			return 6;
		}
		if (year >= 1700 && year <= 1799) {
			return 4;
		}
		if (year >= 1800 && year <= 1899) {
			return 2;
		}
		if (year >= 1900 && year <= 1999) {
			return 0;
		}
		if (year >= 2000 && year <= 2099) {
			return 6;
		}
		return -1;

	}

	/*
	 * formula to calculate the first day with month with month and year:
	 *
	 * => take last 2 digit of the year => divide it by four => take the date =>
	 * take the month number (refer monthNumbers[] Array) => take the year number
	 * (from findYearNumber() function )
	 * 
	 * => add all the 5 answers from the above five lines => modulo it by 7
	 * 
	 * => the remainder is the week number (0 = Sun, 1=Mon, ....6=Sat)
	 * 
	 */

	public static int firstDay(int year, int i) {


		int last2Digit = year % 100;
		int quotientBy4 = last2Digit / 4;
		int date = 1;

		int yearNumber = findYearNumber(year);
		int sum = last2Digit + quotientBy4 + date + monthNumbers[i] + yearNumber;
		firstDayOfMonth = sum % 7;
		return firstDayOfMonth;
	}

	public static void printDays(int max, int year) {

		int number = 1;

		for (int i = 0; i < 6; i++) {

			if (i == 0) {
				for (int j = 0; j < firstDayOfMonth; j++) {
					System.out.printf("\t");
				}

				for (int k = firstDayOfMonth; k <= 6; k++) {
					System.out.print(number++ + "\t");
				}
				System.out.println();
			}

			for (int k = 0; k <= 6; k++) {
				if (number == max + 1) {
					break;

				}
				System.out.print(number++ + "\t");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter the year: ");
		int year = sc.nextInt();
		System.out.println("calnder for " + year);
		boolean leap = false;
		if(year<1600||year>2099) {
			System.out.println("please enter the year between 1600 - 2099");
			return;
		}
		if (year % 4 == 0) {
			leap = true;
		}

		String[] months = { "January", "Febraury", "March", "April", "May", "June", "July", "August", "September",
				"October", "November", "December" };

		for (int i = 0; i < 12; i++) {
			System.out.println("\t\t" + months[i] + " " + year);
			System.out.println();
			if (i == 1) {
				if (leap) {
					firstDayOfMonth = firstDay(year, i);
					printWeeks();
					printDays(29, year);
				} else {
					firstDayOfMonth = firstDay(year, i);
					printWeeks();
					printDays(28, year);
				}
			} else {
				if(i<=6) {
					if(i%2==0) {
						firstDayOfMonth = firstDay(year, i);
						printWeeks();
						printDays(31, year);
					}else {
						firstDayOfMonth = firstDay(year, i);
						printWeeks();
						printDays(30, year);
					}
				}else {
					if(i>6) {
						if(i%2==0) {
							firstDayOfMonth = firstDay(year, i);
							printWeeks();
							printDays(30, year);
						}else {
							firstDayOfMonth = firstDay(year, i);
							printWeeks();
							printDays(31, year);
						}
				}

			}

		}
	}
		}
}

