package com.app;

import java.util.Scanner;
import com.entity.*;
import com.dao.CustmorDao;
import com.daoimpl.CustmorDaoImpl;

public class CustmorPanel {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		CustmorDao cd = new CustmorDaoImpl();
		int ch;
		do {

			System.out.println("................................CustmorPanel.....................................");
			System.out.println("enter your choice............");

			System.out.println(
					"1.Add Custmor\n2.DeleteCustmor\n3.Update Custmor mobile_number\n4. Display AllCustmor\n5.SerachCustmor By Id\n6.Exit");

			int choice = sc.nextInt();
			Custmor c = new Custmor();

			switch (choice) {

			case 1:
				System.out.println("enter the Custmor id");
				c.setCid(sc.nextInt());
				System.out.println("enter the FirstName");
				c.setFname(sc.next());
				System.out.println("enter the LastName");
				c.setLname(sc.next());
				System.out.println("enter the mobile number");
				c.setMno(sc.nextLong());
				System.out.println("enter the email");
				c.setEmail(sc.next());
				System.out.println("enter the Address");
				c.setAddress(sc.next());
				cd.AddCustmor(c);
				break;

			case 2:
				System.out.println(" enter the custmor id to be deleted");
				int id = sc.nextInt();
				cd.DeleteCustmor(id);
				break;

			case 3:
				System.out.println("enter custmor id to be update");
				id = sc.nextInt();
				cd.UpdateCustmor(id);
				break;

			case 4:
				cd.DisplayAllCustmor();
				break;

			case 5:
				System.out.println("enter custmor id to be displayed");
				id = sc.nextInt();
				c = cd.GetCustmorByID(id);
				System.out.println(
						".......................................................................................................");
				if (c != null) {
					System.out.println(c);
				} else {
					System.out.println(" no custmor with this id exist");
				}
				System.out.println(
						".......................................................................................................");
				break;

			case 6:
				MyApp.main(null);
				break;
			default:
				System.out.println("invalid choice");

			}
			System.out.println("do you want to continue.............");
			ch = sc.nextInt();

		} while (ch != 6);

	}

}
