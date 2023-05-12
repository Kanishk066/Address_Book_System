package com.bl.addressbooksystem;
import java.util.*;
import java.util.stream.*;
import java.util.stream.Collectors;
public class AddressBookClass {
    ArrayList<Contacts> contactList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
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

        Contacts newContact = new Contacts(firstName, lastName, address, city, state, zip, phoneNo , email);
        // Check for duplicate entry
        boolean duplicateEntry = contactList.stream()
                .anyMatch(contact -> contact.firstName.equalsIgnoreCase(firstName)
                        && contact.lastName.equalsIgnoreCase(lastName));
        if (duplicateEntry) {
            System.out.println("Contact already exists!");
        } else {
            contactList.add(newContact);
            System.out.println("Contact added successfully!");
        }
    }

    public Contacts display() {
        System.out.println("Enter the First Name of Contact to Display:");
        String displayFirstName = sc.next();
        System.out.println("Enter the Last Name of Contact to Display:");
        String displayLastName = sc.next();
        Contacts resultContact = null;
        // Search for contact by name
        Optional<Contacts> optionalContact = contactList.stream()
                .filter(contact -> contact.firstName.equalsIgnoreCase(displayFirstName)
                        && contact.lastName.equalsIgnoreCase(displayLastName))
                .findFirst();
        if (optionalContact.isPresent()) {
            resultContact = optionalContact.get();
            System.out.println("Contact Found!");
        } else {
            System.out.println("Contact not found!");
        }
        return resultContact;
    }
    public void editContactByName(String firstName, String lastName) {
        Optional<Contacts> optionalContact = contactList.stream()
                .filter(contact -> contact.firstName.equalsIgnoreCase(firstName)
                        && contact.lastName.equalsIgnoreCase(lastName))
                .findFirst();
        if (optionalContact.isPresent()){
            Contacts contact = optionalContact.get();
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter new First Name (or press enter to skip):");
            String newFirstName = sc.nextLine();
            if (!newFirstName.isEmpty()) {
                contact.setFirstName(newFirstName);
        }
            System.out.println("Enter new Last Name (or press enter to skip):");
            String newLastName = sc.nextLine();
            if (!newLastName.isEmpty()) {
                contact.setLastName(newLastName);
            }
            System.out.println("Enter new Address (or press enter to skip):");
            String newAddress = sc.nextLine();
            if (!newAddress.isEmpty()) {
                contact.setAddress(newAddress);
            }
            System.out.println("Enter new City (or press enter to skip):");
            String newCity = sc.nextLine();
            if (!newCity.isEmpty()) {
                contact.setCity(newCity);
            }
            System.out.println("Enter new State (or press enter to skip):");
            String newState = sc.nextLine();
            if (!newState.isEmpty()) {
                contact.setState(newState);
            }
            System.out.println("Enter new Zip Code (or press enter to skip):");
            String newZipCode = sc.nextLine();
            if (!newZipCode.isEmpty()) {
                contact.setZip(sc.nextInt());
            }
            System.out.println("Enter new Phone Number (or press enter to skip):");
            String newPhoneNumber = sc.nextLine();
            if (!newPhoneNumber.isEmpty()) {
                contact.setPhoneNumber(sc.nextInt());
            }
            System.out.println("Enter new Email (or press enter to skip):");
            String newEmail = sc.nextLine();
            if (!newEmail.isEmpty()) {
                contact.setEmailAddress(newEmail);
            }
            System.out.println("Contact edited successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Delete a contact
    public void deleteContact(String deleteFirstName, String deleteLastName) {
        Optional<Contacts> optionalContact = contactList.stream()
                .filter(contact -> contact.firstName.equalsIgnoreCase(deleteFirstName)
                        && contact.lastName.equalsIgnoreCase(deleteLastName))
                .findFirst();
        if (optionalContact.isPresent()) {
            Contacts contactToDelete = optionalContact.get();
            contactList.remove(contactToDelete);
            System.out.println("Contact deleted successfully.");
        } else {
            System.out.println("Contact not found.");
        }
    }
}

