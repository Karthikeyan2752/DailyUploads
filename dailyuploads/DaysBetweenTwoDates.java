package com.dailyuploads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class DaysBetweenTwoDates {

	static int noOfDays(int d1, int m1, int y1, int d2, int m2, int y2) {

		int yy1 = y1;
		int yy2 = y2;
		if (m1 <= 2) {
			yy1--;
		}
		if (m2 <= 2) {
			yy2--;
		}

		int monthDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int l1 = yy1 / 4 - yy1 / 100 + yy1 / 400;
		int l2 = yy2 / 4 - yy2 / 100 + yy2 / 400;

		int n1 = y1 * 365 + d1;
		int n2 = y2 * 365 + d2;

		n1 += l1;
		n2 += l2;
		for (int i = 0; i < m1 - 1; i++) {
			n1 += monthDays[i];
		}

		for (int i = 0; i < m2 - 1; i++) {
			n2 += monthDays[i];
		}

		return Math.abs(n2 - n1);

	}

	static void getDays(String d1, String d2) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date dt1 = format.parse(d1);
			Date dt2 = format.parse(d2);
			long diff = Math.abs(dt1.getTime() - dt2.getTime());
			long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
			System.out.println(days);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// int d1 = 10, m1 = 2, y1 = 2001;
		// int d2 = 10, m2 = 2, y2 = 2002;
		// System.out.println(noOfDays(d1, m1, y1, d2, m2, y2));
		Scanner scanner = new Scanner(System.in);
		String d1 = scanner.next();
		String d2 = scanner.next();
		getDays(d1, d2);

	}

}
