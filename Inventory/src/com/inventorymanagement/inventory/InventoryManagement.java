package com.inventorymanagement.inventory;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.inventorymanagement.inventory.controller.Controller;
import com.inventorymanagement.inventory.model.Properties;
import com.inventorymanagement.inventory.operations.Operations;
import com.inventorymanagement.inventory.utility.Utility;

/**
 * Purpose: To manage inventories
 * 
 * @author Sahil Kudake
 *
 */
public class InventoryManagement {

	public static void main(String[] args) throws IOException {
		Controller controller = new Controller();
		Operations operations = new Operations();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		System.out.println("+++++++Inventory Calculations+++++++");
		List<Properties> read = controller.readFile(); //reading json file in list
		for (Properties pr : read) {
			System.out.println(pr.getName() + " = " + pr.getWeight() * pr.getPrice());	//calculating the total prices of all inventories
		}
		do {
			System.out.println("+++++++Inventory Operations+++++++");
			System.out.print("1.Add Inventory\n2.Remove Inventory\n3.Calculation of Inventory\n4.Exit\nEnter your choice: ");
			try {
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				List<Properties> read1 = controller.readFile(); // reading json file
				List<Properties> list1 = operations.addInventory(read1); //to add inventory 
				controller.writeFile(list1); //writing inventory information in json file
				break;
			case 2:
				List<Properties> read2 = controller.readFile(); // reading json file
				List<Properties> list2 = operations.removeInventory(read2); // to remove inventory
				controller.writeFile(list2); //writing inventory information in json file
				break;
			case 3:
				List<Properties> read3 = controller.readFile(); // reading json file
				operations.calculations(read3); //calculation of inventory
				break;
			case 4:
				System.out.println("Thank you!");
				return;
			default:
				System.out.println("Invalid choice!");
			}
			}catch (InputMismatchException e) {
				System.out.println("Enter valid input!");
				sc.next();
			}
		} while (choice != 4);
	}

}
