package com.recursion;

public class CalendarPrinter {
    public static void main(String[] args) {
		int year = 2022;
        
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        for (int month = 0; month < 12; month++) {
            System.out.println(months[month] + " " + year);
            System.out.println("Su Mo Tu We Th Fr Sa");
            
            // Determine the first day of the month
            int firstDayOfWeek = getFirstDayOfWeek(year, month);
            
            // Print the appropriate number of leading spaces
            for (int i = 1; i < firstDayOfWeek; i++) {
                System.out.print("   ");
            }
            
            int maxDays = daysInMonths[month];
            if (month == 1 && isLeapYear(year)) {
                maxDays = 29;
            }
            
            for (int day = 1; day <= maxDays; day++) {
                System.out.printf("%2d ", day);
				if ((firstDayOfWeek + day - 1) % 7 == 0) {
                    System.out.println();
                }
            }
            System.out.println();
        }
    }
    
    private static int getFirstDayOfWeek(int year, int month) {
        int day = 1;
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
		return (d + 6) % 7 + 1;
    }
    
    private static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
		} else if (year % 400 == 0) {
			return true;
		} else if (year % 100 == 0) {
			return false;
        } else {
            return true;
        }
    }
}