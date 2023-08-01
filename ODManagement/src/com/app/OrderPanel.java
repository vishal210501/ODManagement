package com.app;

import java.util.Scanner;
import com.dao.*;
import com.daoimpl.*;
import com.entity.*;

public class OrderPanel {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		OrderDao od = new OrderDaoImpl();
		int ch;
		do {

			System.out.println(
					".....................................................................OrderPanel.........................................................");
			System.out.println(
					"enter your choice...................................................................................................................");

			System.out.println(
					"1.AddOrder\n2.DeleteOrder\n3.Update Item Quantity\n4. Display AllOrder\n5.SerachOrder By Id\n6.Exit");

			ch = sc.nextInt();
			Order o = new Order();
			switch (ch) {

			case 1:
				System.out.println(" enter order id");
				o.setOid(sc.nextInt());
				System.out.println("enter custmor id");
				o.setCid(sc.nextInt());
				System.out.println("enter the item id");
				o.setItem_id(sc.nextInt());
				System.out.println("enter the quantity");
				o.setQty(sc.nextInt());
//				System.out.println("enter the total cost");
//				o.setTotalCost(sc.nextFloat());
				System.out.println("enter order status");
				o.setOstatus(sc.next());
				System.out.println("enter PayStatus");
				o.setPayStatus(sc.next());
				od.AddOrder(o);
				break;

			case 2:
				System.out.println(" enter the order id to be deleted");
				int odid = sc.nextInt();
				od.DeleteOrder(odid);
				break;

			case 3:
				System.out.println("enter the order id to be updated");
				odid = sc.nextInt();
				od.UpdateOrder(odid);

			case 4:
				od.DisplayAllOrder();
				break;

			case 5:
				System.out.println("enter the order id to be displayed");
				odid = sc.nextInt();
				o = od.GetOrderByID(odid);
				System.out.println(
						".........................................................................................................................................................................");
				if (o != null) {
					System.out.println(o);
				} else {
					System.out.println(" no order with this id exist");
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
					"do you want to continue........................................................................................................");
			System.out.println("if yes then press 1 ");
			System.out.println("for exit press 6");
			ch = sc.nextInt();

		} while (ch != 6);
		System.out.println(
				"thank you for using Order panel.............................................................................................");
	}

}
