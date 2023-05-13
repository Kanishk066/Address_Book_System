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

     static void operateOnAddressBook(AddressBookClass addressBook) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Enter your choice:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contact");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Search City or State");
            System.out.println("6. View by the Name of the City ");
            System.out.println("7. View by the Name of the State");
            System.out.println("8. Display Count by City or State ");
            System.out.println("9.Sort by Person's Name ");
            System.out.println("10.Sort by Zip Code ");
            System.out.println("11.Sort by City ");
            System.out.println("12.Sort by State ");
            System.out.println("13. Exit");

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
                case 5 -> {
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
                case 6 -> {
                    System.out.println("Enter the name of the city:");
                    String city = sc.next();
                    List<Contacts> contactsInCity = addressBook.getContactsByCity(city).stream().filter(contact -> contact.getCity().equalsIgnoreCase(city)).toList();
                    if (contactsInCity.isEmpty()) {
                        System.out.println("No contacts found in " + city);
                    } else {
                        System.out.println("Contacts in " + city + ":");
                        contactsInCity.forEach(contact -> System.out.println(contact.toString()));
                    }
                }
                case 7 -> {
                    System.out.println("Enter the name of the state:");
                    String state = sc.next();
                    List<Contacts> result = addressBook.getContactsByState(state);
                    if (result.isEmpty()) {
                        System.out.println("No contacts found in " + state);
                    } else {
                        System.out.println("Contacts in " + state + ":");
                        for (Contacts contact : result) {
                            System.out.println(contact.toString());
                        }
                    }
                }
                case 8 -> addressBook.displayCountByCityAndState();
                case 9 -> {
                    List<Contacts> sortedContactsByName = addressBook.sortContactsByName();
                    System.out.println("Contacts sorted by name:");
                    sortedContactsByName.forEach(System.out::println);
                }
                case 10 -> {
                    List<Contacts> sortedByZip = addressBook.sortContactsByZip();
                    System.out.println("Sorted by zip code:");
                    for (Contacts c : sortedByZip) {
                        System.out.println(c);
                    }
                }
                case 11 -> {
                    // Sort by city
                    List<Contacts> sortedByCity = addressBook.sortContactsByCity();
                    System.out.println("\nSorted by city:");
                    for (Contacts c : sortedByCity) {
                        System.out.println(c);
                    }
                }
                case 12 -> {
                    // Sort by state
                    List<Contacts> sortedByState = addressBook.sortContactsByState();
                    System.out.println("\nSorted by state:");
                    for (Contacts c : sortedByState) {
                        System.out.println(c);
                    }
                }
                case 13 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        } while (choice != 13);
    }
    }

