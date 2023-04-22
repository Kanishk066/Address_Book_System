package com.bl.addressbooksystem;

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
    Contacts display()
    {
        return obj;
    }
}

