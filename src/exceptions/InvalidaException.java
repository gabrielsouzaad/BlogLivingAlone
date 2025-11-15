package exceptions;

public class InvalidaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidaException(String msg) {
        super(msg);
    }
}
