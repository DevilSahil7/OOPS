package com.inventorymanagement.operations;

import java.util.List;

import com.inventorymanagement.model.Properties;
import com.inventorymanagement.utility.Utility;

public class Operations {

	public List<Properties> addInventory(List<Properties> list) {
		Properties properties = new Properties();

		System.out.println("Enter name of inventory: ");
		properties.setName(Utility.stringInput());
		System.out.println("Enter weight of inventory: ");
		properties.setWeight(Utility.integerInput());
		System.out.println("Enter price of inventory: ");
		properties.setPrice(Utility.floatInput());

		list.add(properties);
		System.out.println("Inventory added successfully!!\nTo add more press 1\nTo exit press 0 ");
		int a = Utility.integerInput();
		if (a == 1)
			addInventory(list);
		return list;
	}

	public List<Properties> removeInventory(List<Properties> list) {
		boolean find = false;
		System.out.println("Enter Inventory to be removed: ");
		String name = Utility.stringInput();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equalsIgnoreCase(name)) {
				list.remove(i);
				find = true;
				System.out.println("Inventory removed!!");
				break;
			}
		}
		if (!find)
			System.out.println("Inventory not found!");
		System.out.println("To remove more press 1\nTo exit press 0 ");
		int a = Utility.integerInput();
		if (a == 1)
			removeInventory(list);
		return list;

	}
	
	public List<Properties> calculations(List<Properties> list){
		System.out.println("Enter inventory to calculate total: ");
		String inventoryName = Utility.stringInput();
		
		for(int i = 0; i<list.size(); i++) {
			if(list.get(i).getName().equalsIgnoreCase(inventoryName)) {
				float total = list.get(i).getWeight()*list.get(i).getPrice();
				System.out.println("Total price is: "+total);
				
			}
		}
		System.out.println("To calculate more press 1\nTo exit press 0 ");
		int a = Utility.integerInput();
		if (a == 1)
			calculations(list);
		return list;
		
	}
}
