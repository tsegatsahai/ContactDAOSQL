import java.util.Scanner;

public class Main {
    public static void main(String [] arg){

        ContactsDAO contactList = new ContactsDAO();
        Contact user1 = new Contact(1,"John","Snow","123456789","deep@deep.com");
        Contact user2 = new Contact(2,"Jamie","Lannister","123456789","deep@deep.com");
        Contact user3 = new Contact(3,"Tyrion","Lannister","123456789","deep@deep.com");
        Contact user4 = new Contact(4,"Tsega", "Tsahai", "5153155157", "tsega@tsega.com");
        Contact user5 = new Contact(5, "Bill", "Smith", "899327841", "billy@yahoo.com");
        Contact user6 = new Contact(6, "Police", "USA", "911", "police@policing.com");
        Contact user7 = new Contact(7, "Bob", "Bobby", "909874532", "bob@bobby.com");


        ContactDAOSQL sql_test = new ContactDAOSQL();

        System.out.println("Adding Contacts to the Table...");
        sql_test.addContact(user4);
        sql_test.addContact(user5);
        sql_test.addContact(user6);
        sql_test.addContact(user7);

        System.out.println("\nContents of Table:");
        sql_test.printContacts();

        System.out.println("\nUpdating a Contact...");
        sql_test.updateContact(user2);

        System.out.println("\nContents of Table After Update:");
        sql_test.printContacts();

        System.out.println("\nRemoving " + user4.getFirstName() + " " + user4.getLastName() + " From Contacts...");
        sql_test.removeContact(user4);

        System.out.println("\nContents of Table After Removal:");
        sql_test.printContacts();


        sql_test.removeContact(user5);
        sql_test.removeContact(user6);
        sql_test.removeContact(user7);

    }

}
