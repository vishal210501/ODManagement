package com.app;

import java.util.Scanner;

public class MyApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int ch;
		do {
			System.out
					.println(".......................................................................................");
			System.out.println("........................Welcome To Management System.............................");
			System.out
					.println(".......................................................................................");

			System.out.println("1. Item Panel");
			System.out.println("2. Custmor Panel");
			System.out.println("3.Order Panel");
			System.out.println("4. Exit");

			System.out.println("Enter your choice");
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				ItemPanel.main(null);
				break;
			case 2:
				CustmorPanel.main(null);
				break;
			case 3:
				OrderPanel.main(null);
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("invalid choice ");
			}

		} while (ch != 4);
		System.out.println(" Thank you..........................................");

	}

}
