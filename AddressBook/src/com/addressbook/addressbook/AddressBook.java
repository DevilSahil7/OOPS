package com.addressbook.addressbook;

import java.io.IOException;
import java.util.List;


import com.addressbook.controller.Controller;
import com.addressbook.model.PersonDetails;
import com.addressbook.operations.Operation;
import com.addressbook.utility.Utility;

public class AddressBook {

	public static void main(String[] args) throws IOException {
		Controller controller = new Controller();
		Operation operation = new Operation();
		int choice;
		do {
			System.out.println("++++++++++Welcome to Address Book++++++++++");
			System.out.println();
			System.out.println("1.Add person detail\n2.Delete person detail\n3.Edit person detail\n4.Sort by zip code\n5.Sort by last name\n6.Get details of specific person\n7.Exit\nEnter your choice: ");
			choice = Utility.integerInput();
			switch(choice) {
			case 1:
				List<PersonDetails> read = controller.readFile();
				List<PersonDetails> list = operation.addUser(read);
				controller.writeFile(list);
				break;
			case 2:
				List<PersonDetails> read1 = controller.readFile();
				for (int i = 0; i <read1.size() ; i++) {
					System.out.println(read1.get(i).getFname());
				}
				System.out.println("enter first name of user to delete: ");
				String name = Utility.stringInput();
				List<PersonDetails> list1 = operation.deleteUser(read1,name);
				controller.writeFile(list1);
				break;
			case 3:
				List<PersonDetails> read2 = controller.readFile();
				   List<PersonDetails> list2 = operation.editUser(read2);
				   controller.writeFile(list2);
				   break;
			case 4:
				List<PersonDetails> read3=controller.readFile();
				   List<PersonDetails> list3=operation.sortZip(read3);
				   System.out.println("Sorted address book by zip code is: ");
				   for(PersonDetails pd : list3) {
					   System.out.println(pd.getFname()+"\t"+pd.getLname()+"\t"+pd.getAddress()+"\t"+pd.getCity()+"\t"+pd.getState()+"\t"+pd.getZip()+"\t"+pd.getPhone());		
				   }
				   break;
			case 5:
				List<PersonDetails> read4 = controller.readFile();
				   List<PersonDetails> list4 = operation.sortLastName(read4);
				   System.out.println("Sorted address book by last name is: ");
				   for(PersonDetails pd : list4) {
					   System.out.println(pd.getFname()+"\t"+pd.getLname()+"\t"+pd.getAddress()+"\t"+pd.getCity()+"\t"+pd.getState()+"\t"+pd.getZip()+"\t"+pd.getPhone());		
				   }
				   break;
			case 6:
				 List<PersonDetails> read5 = controller.readFile();
				 operation.getDetails(read5);
				 break;
			case 7:
				System.out.println("Thank you!");
				return;
				default:
					System.out.println("Enter correct choice!");
			}
		}while(choice!=7);

	}

}
