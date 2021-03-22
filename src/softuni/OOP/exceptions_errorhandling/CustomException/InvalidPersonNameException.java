package softuni.OOP.exceptions_errorhandling.CustomException;

public class InvalidPersonNameException extends RuntimeException {

    public InvalidPersonNameException (String message) {
        super(message);
    }
}
