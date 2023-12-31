package com.app;

import com.entity.*;
import java.util.*;
import com.dao.*;
import com.daoimpl.*;

public class ItemPanel {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ItemDao id = new ItemDaoImpl();
		int ch;
		do {

			System.out.println(
					"..................................................Item-Panel.............................................................................");
			System.out.println(
					"enter your choice...................................................................................................................");

			System.out.println(
					"1. Add Item\n2.Delete Item\n3.Update Item cost\n4.Display All Item\n5.Serach Item By Id\n6..Exit");

			ch = sc.nextInt();
			Item i = new Item();
			switch (ch) {

			case 1:
				System.out.println("enter item id");
				i.setItemid(sc.nextInt());
				System.out.println("enter item name");
				i.setIname(sc.next());
				System.out.println("enter the cost of item");
				i.setCost(sc.nextFloat());
				id.AddItem(i);
				break;

			case 2:
				System.out.println("enter the item id to be deleted");
				int did = sc.nextInt();
				id.DeleteItem(did);
				break;

			case 3:
				System.out.println("enter item id to be update");
				did = sc.nextInt();
				id.UpdateItem(did);
				break;

			case 4:
				id.DisplayAllItem();
				break;

			case 5:
				System.out.println("enter the item id to be displayed");
				did = sc.nextInt();
				i = id.GetItemByID(did);
				System.out.println(
						".........................................................................................................................................................................");
				if (i != null) {
					System.out.println(i);
				} else {
					System.out.println(" no item with this id exist");
				}
				System.out.println(
						".........................................................................................................................................................................");
				break;

			case 6:
				MyApp.main(null);
				break;
			default:
				System.out.println("invalid choice");

			}
			System.out.println(
					"do you want to continue with Item panel.........................................................................");
			System.out.println("if yes then press 1 ");
			System.out.println("for exit press 6");
			ch = sc.nextInt();

		} while (ch != 6);
		System.out.println(
				"thank you for using Item panel...............................................................................................");

	}

}
