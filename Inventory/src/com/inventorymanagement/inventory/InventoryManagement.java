package com.inventorymanagement.inventory;

import java.io.IOException;
import java.util.List;

import com.inventorymanagement.controller.Controller;
import com.inventorymanagement.model.Properties;
import com.inventorymanagement.operations.Operations;
import com.inventorymanagement.utility.Utility;

public class InventoryManagement {

	public static void main(String[] args) throws IOException {
		Controller controller = new Controller();
		Operations operations = new Operations();
		int choice;
		System.out.println("+++++++Inventory Calculations+++++++");
		List<Properties> read = controller.readFile();
		for (Properties pr : read) {
			System.out.println(pr.getName() + " = " + pr.getWeight() * pr.getPrice());
		}
		do {
			System.out.println("+++++++Inventory Operations+++++++");
			System.out.print("1.Add Inventory\n2.Remove Inventory\n3.Calculation of Inventory\n4.Exit\nEnter your choice: ");
			choice = Utility.integerInput();
			switch (choice) {
			case 1:
				List<Properties> read1 = controller.readFile();
				List<Properties> list1 = operations.addInventory(read1);
				controller.writeFile(list1);
				break;
			case 2:
				List<Properties> read2 = controller.readFile();
				List<Properties> list2 = operations.removeInventory(read2);
				controller.writeFile(list2);
				break;
			case 3:
				List<Properties> read3 = controller.readFile();
				operations.calculations(read3);
				break;
			case 4:
				System.out.println("Thank you!");
				return;
			default:
				System.out.println("Invalid choice!");
			}
		} while (choice != 4);
	}

}
