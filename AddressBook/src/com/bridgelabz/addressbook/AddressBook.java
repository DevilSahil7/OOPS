package com.bridgelabz.addressbook;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.bridgelabz.addressbook.controller.Controller;
import com.bridgelabz.addressbook.model.PersonDetails;
import com.bridgelabz.addressbook.operations.Operation;
import com.bridgelabz.addressbook.utility.Utility;

/**
 * Purpose: To create address book of people
 * 
 * @author Sahil Kudake
 *
 */
public class AddressBook {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException, InputMismatchException {
		Controller controller = new Controller();	//controller object to access fields in controller
		Operation operation = new Operation();	//operation object to access fields in operation
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		do {
			System.out.println("++++++++++Welcome to Address Book++++++++++");
			System.out.println();
			System.out.println("1.Add person detail\n2.Delete person detail\n3.Edit person detail\n4.Sort by zip code\n5.Sort by last name\n6.Get details of specific person\n7.Exit\nEnter your choice: ");
			try {
			choice = sc.nextInt();
			switch(choice) {
			case 1:
				List<PersonDetails> read = controller.readFile(); //reading json file in a list
				List<PersonDetails> list = operation.addUser(read); //calling add user to perform add user operation
				controller.writeFile(list); //writing list in json file
				break;
			case 2:
				List<PersonDetails> read1 = controller.readFile(); //reading json file
				for (int i = 0; i <read1.size() ; i++) {
					System.out.println(read1.get(i).getFname()); //showing the first names of person
				}
				System.out.println("enter first name of user to delete: ");
				String name = Utility.stringInput();	//user input to delete from list
				List<PersonDetails> list1 = operation.deleteUser(read1,name);	//calling delete user to delete user from list
				controller.writeFile(list1);	//writing file in json file
				break;
			case 3:
				List<PersonDetails> read2 = controller.readFile();	//reading json file
				   List<PersonDetails> list2 = operation.editUser(read2);	//performing edit user operation
				   controller.writeFile(list2);	//writing json file
				   break;
			case 4:
				List<PersonDetails> read3=controller.readFile(); //reading json file
				   List<PersonDetails> list3=operation.sortZip(read3);	//sorting according to zip code
				   System.out.println("Sorted address book by zip code is: ");
				   for(PersonDetails pd : list3) {	//printing the sorted list according to zip code
					   System.out.println(pd.getFname()+"\t"+pd.getLname()+"\t"+pd.getAddress()+"\t"+pd.getCity()+"\t"+pd.getState()+"\t"+pd.getZip()+"\t"+pd.getPhone());		
				   }
				   break;
			case 5:
				List<PersonDetails> read4 = controller.readFile();	//reading json file
				   List<PersonDetails> list4 = operation.sortLastName(read4);	//sorting according to last name
				   System.out.println("Sorted address book by last name is: ");
				   for(PersonDetails pd : list4) {	//printing the sorted list according to last name
					   System.out.println(pd.getFname()+"\t"+pd.getLname()+"\t"+pd.getAddress()+"\t"+pd.getCity()+"\t"+pd.getState()+"\t"+pd.getZip()+"\t"+pd.getPhone());		
				   }
				   break;
			case 6:
				 List<PersonDetails> read5 = controller.readFile(); //reading json file
				 operation.getDetails(read5);  //getting all details of all person
				 break;
			case 7:
				System.out.println("Thank you!");
				return;
				default:
					System.out.println("Enter correct choice!");
			}
			}catch (InputMismatchException e) {
				System.out.println("Enter integer only!");
				sc.next();
			}
		}while(choice!=7);

	}

}
