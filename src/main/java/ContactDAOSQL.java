import java.sql.*;
import java.util.Scanner;

public class ContactDAOSQL {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";
    private static final String CONN_STRING = "jdbc:mysql://localhost:3306/contacts";
    private Connection conn = null;

    public ContactDAOSQL(){
        try{
            this.conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
            System.out.println("Database Connected\n");
        }catch (SQLException e){
            System.err.println(e);
        }
    }

    public void printContacts() {
        try {
            String query = "SELECT * FROM contact";
            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String phoneNum = rs.getString("phoneNum");
                String emailAdd = rs.getString("email");

                // print the results
                System.out.format("%s, %s, %s, %s, %s\n", id, firstName, lastName, phoneNum, emailAdd);
            }
            st.close();

        } catch (SQLException e) {
            System.err.println(e);
        }
    }

    public void addContact(Contact contact){
        try{
            String query = "INSERT INTO contact (id, firstName, lastName, phoneNum, email) VALUES('"+contact.getId()+"', '"+contact.getFirstName()+"', '"+contact.getLastName()+"', '"+contact.getPhoneNumber()+"', '"+contact.getEmailAddress()+"');";
            Statement st = conn.createStatement();
            st.executeUpdate(query);
            st.close();
        }
        catch (SQLException e){
            System.err.println(e);
        }
    }

    public void updateContact(Contact contact){
        try{
            Statement st = conn.createStatement();
            Scanner scanner = new Scanner(System.in);
            String query = "";
            System.out.println("What would you like to update? ");
            System.out.println("\t 1 for first name");
            System.out.println("\t 2 for last name");
            System.out.println("\t 3 for phone number");
            System.out.println("\t 4 for email");
            int userChoice = scanner.nextInt();
            scanner.nextLine();
            switch (userChoice){
                case 1:
                    System.out.println("Please enter the updated first name: ");
                    String newFirstName = scanner.nextLine();
                    contact.setFirstName(newFirstName);
                    query = "UPDATE contact SET firstName = '"+contact.getFirstName()+"' WHERE id = '"+contact.getId()+"'";
                    st.executeUpdate(query);
                    System.out.println("Success!");
                    break;
                case 2:
                    System.out.println("Please enter the updated last name: ");
                    String newLastName = scanner.nextLine();
                    contact.setLastName(newLastName);
                    query = "UPDATE contact SET lastName = '"+contact.getLastName()+"' WHERE id = '"+contact.getId()+"'";
                    st.executeUpdate(query);
                    System.out.println("Success!");
                    break;
                case 3:
                    System.out.println("Please enter the updated phone number: ");
                    String newNumber = scanner.nextLine();
                    contact.setPhoneNumber(newNumber);
                    query = "UPDATE contact SET phoneNum = '"+contact.getPhoneNumber()+"' WHERE id = '"+contact.getId()+"'";
                    st.executeUpdate(query);
                    System.out.println("Success!");
                    break;
                case 4:
                    System.out.println("Please enter the updated email address: ");
                    String newEmail = scanner.nextLine();
                    contact.setEmailAddress(newEmail);
                    query = "UPDATE contact SET email = '"+contact.getEmailAddress()+"' WHERE id = '"+contact.getId()+"'";
                    st.executeUpdate(query);
                    System.out.println("Success!");
                    break;
                default:
                    System.out.println("ERROR: Invalid Option");
                    break;
            }
            st.close();
        }
        catch (SQLException e){
            System.err.println(e);
        }
    }

    public void removeContact(Contact contact){
        try{
            Statement st = conn.createStatement();
            String query = "DELETE FROM contact WHERE id = '"+contact.getId()+"'";
            st.executeUpdate(query);
            st.close();
        }
        catch (SQLException e){
            System.err.println(e);
        }
    }
}
