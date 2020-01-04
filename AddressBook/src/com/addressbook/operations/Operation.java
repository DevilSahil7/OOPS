package com.addressbook.operations;

import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

import com.addressbook.model.PersonDetails;
import com.addressbook.utility.Utility;

public class Operation {

	public List<PersonDetails> addUser(List<PersonDetails> listOfPerson) {
		PersonDetails pd = new PersonDetails();
		do {
			System.out.println("Enter first name: ");
			pd.setFname(Utility.stringInput());
			System.out.println("Enter last name: ");
			pd.setLname(Utility.stringInput());
			System.out.print("Enter address: ");
			pd.setAddress(Utility.stringInput());
			System.out.print("Enter city: ");
			pd.setCity(Utility.stringInput());
			System.out.print("Enter state: ");
			pd.setState(Utility.stringInput());
			System.out.print("Enter zip: ");
			pd.setZip(Utility.integerInput());
			System.out.println("Enter phone: ");
			pd.setPhone(Utility.longInput());
			listOfPerson.add(pd);
			System.out.println("Person added successfully!");
			System.out.println("To add more person type true");
			return listOfPerson;
		} while (Utility.booleanInput());
	}

	public List<PersonDetails> deleteUser(List<PersonDetails> listOfPerson, String name) {
		boolean find=false;
		do {
//			System.out.print("Enter first name to delete: ");
//			String firstName = Utility.stringInput();
			
			for (int i = 0; i < listOfPerson.size(); i++) {
				if (listOfPerson.get(i).getFname().equals(name)) {
					listOfPerson.remove(i);
					find=true;
					System.out.println("Person details deleted successfully1");
					System.out.println("To delete more type true: ");
					break;
				}
			}
			if(!find) {
				System.out.println("not in list");
			}
			return listOfPerson;
		} while (Utility.booleanInput());
		
		
	}

	public List<PersonDetails> editUser(List<PersonDetails> listOfPerson) throws IOException {
		System.out.println("Enter first name you want to change: ");
		String firstName = Utility.stringInput();
		for (int i = 0; i < listOfPerson.size(); i++) {
			if (listOfPerson.get(i).getFname().equals(firstName)) {
				PersonDetails temp = listOfPerson.get(i);
				deleteUser(listOfPerson, firstName);
				do {
					System.out.println("1.Last Name");
					System.out.println("2.Address");
					System.out.println("3.City");
					System.out.println("4.State");
					System.out.println("5.Zip");
					System.out.println("6.Phone");
					System.out.print("Enter no of field you want to edit: ");
					int num = Utility.integerInput();
					switch (num) {
					case 1:
						System.out.print("Enter the new Last name: ");
						temp.setLname(Utility.stringInput());
						System.out.println("Details saved successfully!");
						break;
					case 2:
						System.out.print("Enter the new Address: ");
						temp.setAddress(Utility.stringInput());
						System.out.println("Details saved successfully!");
						break;
					case 3:
						System.out.print("Enter the new City: ");
						temp.setCity(Utility.stringInput());
						System.out.println("Details saved successfully!");
						break;
					case 4:
						System.out.print("Enter the new State: ");
						temp.setState(Utility.stringInput());
						System.out.println("Details saved successfully!");
						break;
					case 5:
						System.out.print("Enter the new Zip: ");
						temp.setZip(Utility.integerInput());
						System.out.println("Details saved successfully!");
						break;
					case 6:
						System.out.print("Enter the new Phone: ");
						temp.setPhone(Utility.longInput());
						System.out.println("Details saved successfully!");
						break;
					default:
						System.out.println("Invalid choice\n Select proper choice: ");
						editUser(listOfPerson);
					}
					System.out.println("1.Save\n2.Save As..");
					int save = Utility.integerInput();
					switch(save) {
					case 1:
						listOfPerson.add(temp);
						break;
					case 2:
						
						System.out.println("Enter new name of the file: ");
						String name = Utility.stringInput();
						File file = new File(name+".json");
						file.createNewFile();
						FileWriter fw = new FileWriter(file);
						listOfPerson.add(temp);
						for(PersonDetails pd: listOfPerson) {
						fw.write(pd.getFname()+"\n"+pd.getLname()+"\n"+pd.getAddress()+"\n"+pd.getCity()+"\n"+pd.getState()+"\n"+pd.getZip()+"\n"+pd.getPhone()+"\n");
						}
						
						fw.flush();
					}
					
					return listOfPerson;
				} while (Utility.booleanInput());
			}
		}
		return listOfPerson;
	}

	public List<PersonDetails> sortZip(List<PersonDetails> listOfPerson) {
		for (int i = 0; i < listOfPerson.size(); i++) {
			for (int j = 0; j < listOfPerson.size(); j++) {
				if (listOfPerson.get(i).getZip() > listOfPerson.get(j).getZip()) {
					PersonDetails temp = listOfPerson.get(i);
					listOfPerson.set(i, listOfPerson.get(j));
					listOfPerson.set(j, temp);
				}
			}
		}
		return listOfPerson;
	}

	public List<PersonDetails> sortLastName(List<PersonDetails> listOfPerson) {
		for (int i = 0; i < listOfPerson.size(); i++) {
			for (int j = 0; j < listOfPerson.size(); j++) {
				if (listOfPerson.get(i).getLname().compareTo(listOfPerson.get(j).getLname()) > 0) {
					PersonDetails temp = listOfPerson.get(i);
					listOfPerson.set(i, listOfPerson.get(j));
					listOfPerson.set(j, temp);
				}
			}
		}
		return listOfPerson;
	}

	public List<PersonDetails> getDetails(List<PersonDetails> listOfPerson) {
		System.out.print("Enter first name of user to get details: ");
		String firstName = Utility.stringInput();
		for (int i = 0; i < listOfPerson.size(); i++) {
			if (listOfPerson.get(i).getFname().equalsIgnoreCase(firstName)) {
				PersonDetails temp = listOfPerson.get(i);
				System.out.println(temp.toStirng());
			} 
			
		}
		return listOfPerson;
	}

}