package softuni.OOP.exceptions_errorhandling.ValidPerson;

public class Main {
    public static void main(String[] args) {

        try {
            Person noName = new Person("", "Aimee", 19);
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }
    }
}
