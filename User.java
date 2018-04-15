//User class that sets up constructors for the login

public class User {
    private String firstName;
    private String lastName;
    private String emailAddress;

    public Person(String firstName, String lastName, String emailAddress) {
        firstName = firstName;
        lastName = lastName;
        email = emailAddress;
    }

    public String toString() { return firstName + " " + lastName + " " + emailAddress; }
}
