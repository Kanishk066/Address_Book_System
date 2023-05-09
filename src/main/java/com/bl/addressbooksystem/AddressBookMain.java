package com.bl.addressbooksystem;

import java.util.Scanner;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome To Address Book System Program");
        AddressBookClass obj = new AddressBookClass();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter your choice:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    obj.addContacts();
                    break;
                case 2:
                    obj.displayAllContacts();
                    break;
                case 3:
                    System.out.println("Enter the First Name of Contact to Edit:");
                    String firstName = sc.next();
                    System.out.println("Enter the Last Name of Contact to Edit:");
                    String lastName = sc.next();
                    obj.editContactByName(firstName, lastName);
                    break;
                case 4:
                    System.out.println("Enter the First Name of Contact to Delete:");
                    String deleteFirstName = sc.next();
                    System.out.println("Enter the Last Name of Contact to Delete:");
                    String deleteLastName = sc.next();
                    obj.deleteContact(deleteFirstName, deleteLastName);
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 5);
    }
}

