package com.dailyuploads;

import java.util.Scanner;

public class SeatingArrangement {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

			int currentSeat = scanner.nextInt();

			int bank = (currentSeat - 1) / 12;
			System.out.println(bank);
			System.out.println(bank * 12);
			int bankSeat = currentSeat - bank * 12;
			System.out.println(bankSeat);
			switch (bankSeat) {
			case 1:
			case 6:
			case 7:
			case 12:
				System.out.println("WS");
				break;
			case 2:
			case 5:
			case 8:
			case 11:
				System.out.println("MS");
				break;
			default:
				System.out.println("AS");
				break;
			}
	}
}

