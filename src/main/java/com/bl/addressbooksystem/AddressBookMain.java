package com.bl.addressbooksystem;

public class AddressBookMain {
    public static void main(String[] args) {
        System.out.println("Welcome To Address Book System Program");
        AddressBookClass obj = new AddressBookClass();
        obj.addContacts();
        System.out.println(obj.display());
    }
}

