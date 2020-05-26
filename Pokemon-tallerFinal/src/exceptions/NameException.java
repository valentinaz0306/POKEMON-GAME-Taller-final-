package exceptions;

public class NameException extends Exception {

    public NameException() {

        super("The number of characters most be between 3 and 12 \n Please enter a new name");

    }
}
