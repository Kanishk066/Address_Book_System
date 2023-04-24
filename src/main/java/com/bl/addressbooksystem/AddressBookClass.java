package com.bl.addressbooksystem;
import java.util.Collection;
import java.util.Scanner;

public class AddressBookClass {
    Scanner sc = new Scanner(System.in);
    Contacts obj = new Contacts();
    void addContacts(){
        System.out.println("Enter First Name: ");
        obj.setFirstName(sc.next());

        System.out.println("Enter Last Name: ");
        obj.setLastName(sc.next());

        System.out.println("Enter Address: ");
        obj.setAddress(sc.next());

        System.out.println("Enter City Name: ");
        obj.setCity(sc.next());

        System.out.println("Enter State Name: ");
        obj.setState(sc.next());

        System.out.println("Enter Zip Code: ");
        obj.setZip(sc.nextInt());

        System.out.println("Enter Phone Number: ");
        obj.setPhoneNumber(sc.nextLong());

        System.out.println("Enter Email Address: ");
        obj.setEmailAddress(sc.next());
    }
    // Get a contact from the address book by name
    Contacts getContactByName(String firstName, String lastName) {
        if (obj.getFirstName().equals(firstName) && obj.getLastName().equals(lastName)) {
            return obj;
        } else {
            return null;
        }
    }
    // Edit an existing contact in the address book by name
    void editContactByName(String firstName, String lastName) {
        if (obj.getFirstName().equals(firstName) && obj.getLastName().equals(lastName)) {
            System.out.println("Enter Address: ");
            obj.setAddress(sc.next());

            System.out.println("Enter City Name: ");
            obj.setCity(sc.next());

            System.out.println("Enter State Name: ");
            obj.setState(sc.next());

            System.out.println("Enter Zip Code: ");
            obj.setZip(sc.nextInt());

            System.out.println("Enter Phone Number: ");
            obj.setPhoneNumber(sc.nextLong());

            System.out.println("Enter Email Address: ");
            obj.setEmailAddress(sc.next());
        } else {
            System.out.println("Contact not found.");
        }
    }
    Contacts display()
    {
        return obj;
    }
    // Delete a contact
    void deleteContact(String firstName, String lastName){
        if(firstName.equals(obj.getFirstName()) && lastName.equals(obj.getLastName())){
            obj.setFirstName("");
            obj.setLastName("");
            obj.setAddress("");
            obj.setCity("");
            obj.setState("");
            obj.setZip(0);
            obj.setPhoneNumber(0);
            obj.setEmailAddress("");
            System.out.println("Contact deleted successfully!");
        }
        else{
            System.out.println("Contact not found!");
        }
    }
}

