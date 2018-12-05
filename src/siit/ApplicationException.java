package siit;

public class ApplicationException extends Exception {

    private String errorCode;

    public ApplicationException(String message) {
        super(message);
    }
}
