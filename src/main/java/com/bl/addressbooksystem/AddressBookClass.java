package com.bl.addressbooksystem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class AddressBookClass {
    ArrayList<Contacts> contactList = new ArrayList<>();

    public void addContacts() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First Name:");
        String firstName = sc.next();
        System.out.println("Enter Last Name:");
        String lastName = sc.next();
        System.out.println("Enter Address:");
        String address = sc.next();
        System.out.println("Enter City:");
        String city = sc.next();
        System.out.println("Enter State:");
        String state = sc.next();
        System.out.println("Enter Zip Code:");
        int zip = sc.nextInt();
        System.out.println("Enter Phone Number:");
        long phoneNumber = sc.nextLong();
        System.out.println("Enter Email Address:");
        String emailAddress = sc.next();

        Contacts newContact = new Contacts(firstName, lastName, address, city, state, zip, phoneNumber, emailAddress);
        contactList.add(newContact);
    }

    public Contacts display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the First Name of Contact to Display:");
        String firstName = sc.next();
        System.out.println("Enter the Last Name of Contact to Display:");
        String lastName = sc.next();

        for (Contacts contacts : contactList) {
            if (contacts.getFirstName().equals(firstName) && contacts.getLastName().equals(lastName)) {
                return contacts;
            }
        }
        System.out.println("Contact not found!");
        return null;
    }

    public void displayAllContacts() {
        for (Contacts contacts : contactList) {
            System.out.println(contacts.toString());
        }
    }

    public void editContactByName(String firstName, String lastName) {
        for (Contacts contact : contactList) {
            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Enter updated address:");
                String address = sc.nextLine();
                contact.setAddress(address);

                System.out.println("Enter updated city:");
                String city = sc.nextLine();
                contact.setCity(city);

                System.out.println("Enter updated state:");
                String state = sc.nextLine();
                contact.setState(state);

                System.out.println("Enter updated zip code:");
                int zip = sc.nextInt();
                contact.setZip(zip);

                System.out.println("Enter updated phone number:");
                long phoneNumber = sc.nextLong();
                contact.setPhoneNumber(phoneNumber);

                System.out.println("Enter updated email address:");
                String emailAddress = sc.next();
                contact.setEmailAddress(emailAddress);

                System.out.println("Contact details updated successfully.");
                return;
            }
        }
        System.out.println("No contact found with the given first name and last name.");
    }

    // Delete a contact
    public void deleteContact(String deleteFirstName, String deleteLastName) {
        int index = -1;
        for (int i = 0; i < contactList.size(); i++) {
            Contacts contact = contactList.get(i);
            if (contact.getFirstName().equals(deleteFirstName) && contact.getLastName().equals(deleteLastName)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.out.println("Contact not found.");
        } else {
            contactList.remove(index);
            System.out.println("Contact deleted successfully.");
        }
    }
}

