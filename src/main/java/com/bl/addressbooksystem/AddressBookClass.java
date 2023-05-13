package com.bl.addressbooksystem;
import java.util.*;
import java.util.stream.Collectors;
public class AddressBookClass {
    List<Contacts> contactsList;
    Scanner sc = new Scanner(System.in);

    public AddressBookClass() {
        this.contactsList = new ArrayList<>();
    }

    public void addContacts() {
        System.out.println("Enter the First Name:");
        String firstName = sc.next();
        System.out.println("Enter the Last Name:");
        String lastName = sc.next();
        System.out.println("Enter the Address:");
        String address = sc.next();
        System.out.println("Enter the City:");
        String city = sc.next();
        System.out.println("Enter the State:");
        String state = sc.next();
        System.out.println("Enter the Zip Code:");
        int zip = sc.nextInt();
        System.out.println("Enter the Phone Number:");
        int phoneNo = sc.nextInt();
        System.out.println("Enter the Email:");
        String email = sc.next();

        Contacts newContact = new Contacts(firstName, lastName, address, city, state, zip, phoneNo, email);
        // Check for duplicate entry
        boolean duplicateEntry = contactsList.stream().anyMatch(contact -> contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName));
        if (duplicateEntry) {
            System.out.println("Contact already exists!");
        } else {
            contactsList.add(newContact);
            System.out.println("Contact added successfully!");
        }
    }

    public Contacts display() {
        int count = 0;
        Contacts contacts = null;
        for (Contacts c : contactsList) {
            System.out.println(c.toString());
            count++;
            contacts = c;
        }
        System.out.println("Total number of contacts: " + count);
        return contacts;
    }

    // Edit a contact by name
    public void editContactByName(String firstName, String lastName) {
        Optional<Contacts> optionalContact = contactsList.stream().filter(contact -> contact.getFirstName().equalsIgnoreCase(firstName) && contact.getLastName().equalsIgnoreCase(lastName)).findFirst();
        if (optionalContact.isPresent()) {
            Contacts contact = optionalContact.get();
            System.out.println("Enter new First Name (or press enter to skip):");
            String newFirstName = sc.nextLine().trim();
            if (!newFirstName.isEmpty()) {
                contact.setFirstName(newFirstName);
            }
            System.out.println("Enter new Last Name (or press enter to skip):");
            String newLastName = sc.nextLine().trim();
            if (!newLastName.isEmpty()) {
                contact.setLastName(newLastName);
            }
            System.out.println("Enter new Address (or press enter to skip):");
            String newAddress = sc.nextLine().trim();
            if (!newAddress.isEmpty()) {
                contact.setAddress(newAddress);
            }
            System.out.println("Enter new City (or press enter to skip):");
            String newCity = sc.nextLine().trim();
            if (!newCity.isEmpty()) {
                contact.setCity(newCity);
            }
            System.out.println("Enter new State (or press enter to skip):");
            String newState = sc.nextLine().trim();
            if (!newState.isEmpty()) {
                contact.setState(newState);
            }
            System.out.println("Enter new Zip Code (or press enter to skip):");
            String newZipCode = sc.nextLine().trim();
            if (!newZipCode.isEmpty()) {
                contact.setZip(Integer.parseInt(newZipCode));
            }
            System.out.println("Enter new Phone Number (or press enter to skip):");
            String newPhoneNumber = sc.nextLine().trim();
            if (!newPhoneNumber.isEmpty()) {
                contact.setPhoneNumber(Integer.parseInt(newPhoneNumber));
            }
            System.out.println("Enter new Email (or press enter to skip):");
            String newEmail = sc.nextLine().trim();
            if (!newEmail.isEmpty()) {
                contact.setEmailAddress(newEmail);
            }
            System.out.println("Contact edited successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

            public void deleteContact (String firstName, String lastName){
                boolean flag = false;
                for (Contacts c : contactsList) {
                    if (c.getFirstName().equalsIgnoreCase(firstName) && c.getLastName().equalsIgnoreCase(lastName)) {
                        flag = true;
                        contactsList.remove(c);
                        break;
                    }
                }
                if (!flag) {
                    System.out.println("Contact not found");
                } else {
                    System.out.println("Contact deleted successfully");
                }
            }

            // View persons by city using Java Streams
            public List<Contacts> getContactsByCity(String city) {
                return contactsList.stream().filter(contact -> contact.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
            }

            // View persons by state using Java Streams
            public List<Contacts> getContactsByState(String state) {
                return contactsList.stream().filter(contact -> contact.getState().equalsIgnoreCase(state)).collect(Collectors.toList());
            }

            public List<Contacts> searchByCityOrState(String cityOrState) {
                return contactsList.stream().filter(contact -> contact.getCity().equalsIgnoreCase(cityOrState) || contact.getState().equalsIgnoreCase(cityOrState)).collect(Collectors.toList());
            }

            public void displayCountByCityAndState() {
                System.out.println("Count by city:");
                contactsList.stream().collect(Collectors.groupingBy(Contacts::getCity, Collectors.counting())).forEach((city, count) -> System.out.println(city + ": " + count));
                System.out.println("Count by state:");
                contactsList.stream().collect(Collectors.groupingBy(Contacts::getState, Collectors.counting())).forEach((state, count) -> System.out.println(state + ": " + count));
            }
}



