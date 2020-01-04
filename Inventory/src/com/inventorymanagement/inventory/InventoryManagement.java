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

		System.out.println("+++++++Inventory Calculations+++++++");
		List<Properties> read = controller.readFile();
		for (Properties pr : read) {
			System.out.println(pr.getName() + " = " + pr.getWeight() * pr.getPrice());
		}

		System.out.println("+++++++Inventory Operations+++++++");
		System.out.print("1.Add Inventory\n2.Remove Inventory\n3.Calculation of Inventory\nEnter your choice: ");
		int choice = Utility.integerInput();
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
			List<Properties> list3 = operations.calculations(read3);

			break;

		default:
			System.out.println("Invalid choice!");
		}
	}

}
