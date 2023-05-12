package com.bl.addressbooksystem;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome To Address Book System Program");

        // Create a dictionary to store Address Book name to Address Book object mapping
        HashMap<String, AddressBookClass> addressBooks = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter your choice:");
            System.out.println("1. Create Address Book");
            System.out.println("2. Select Address Book");
            System.out.println("3. Display All Address Books");
            System.out.println("4. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter the name of the new Address Book:");
                    String name = sc.next();
                    // Create a new AddressBookClass object and add it to the dictionary
                    AddressBookClass newAddressBook = new AddressBookClass();
                    addressBooks.put(name, newAddressBook);
                    System.out.println("New Address Book " + name + " created successfully.");
                }
                case 2 -> {
                    System.out.println("Enter the name of the Address Book:");
                    String name = sc.next();
                    // Select the Address Book from the dictionary
                    AddressBookClass selectedAddressBook = addressBooks.get(name);
                    if (selectedAddressBook == null) {
                        System.out.println("Address Book " + name + " not found.");
                    } else {
                        // Operate on the selected Address Book
                        operateOnAddressBook(selectedAddressBook);
                    }
                }
                case 3 -> {
                    // Display the names of all Address Books
                    System.out.println("Address Books:");
                    for (String name : addressBooks.keySet()) {
                        System.out.println(name);
                    }
                }
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 4);
    }

    private static void operateOnAddressBook(AddressBookClass addressBook) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter your choice:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addressBook.addContacts();
                case 2 -> {
                    Contacts contacts = addressBook.display();
                    System.out.println(contacts.toString());
                }
                case 3 -> {
                    System.out.println("Enter the First Name of Contact to Edit:");
                    String firstName = sc.next();
                    System.out.println("Enter the Last Name of Contact to Edit:");
                    String lastName = sc.next();
                    addressBook.editContactByName(firstName, lastName);
                }
                case 4 -> {
                    System.out.println("Enter the First Name of Contact to Delete:");
                    String deleteFirstName = sc.next();
                    System.out.println("Enter the Last Name of Contact to Delete:");
                    String deleteLastName = sc.next();
                    addressBook.deleteContact(deleteFirstName, deleteLastName);
                }
                case 5 -> System.exit(0);
                case 6 -> {
                    System.out.println("Enter the name of the city or state:");
                    String cityOrState = sc.next();
                    List<Contacts> result = addressBook.searchByCityOrState(cityOrState);
                    if (result.isEmpty()) {
                        System.out.println("No contacts found in " + cityOrState);
                    } else {
                        System.out.println("Contacts in " + cityOrState + ":");
                        for (Contacts contact : result) {
                            System.out.println(contact.toString());
                        }
                    }
                }
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 5);
    }
    }

