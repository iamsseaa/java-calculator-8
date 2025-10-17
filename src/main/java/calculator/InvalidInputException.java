package calculator;

public class InvalidInputException extends IllegalAccessError {
    public InvalidInputException(String message) {
        super(message);
    }
}
