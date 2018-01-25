package ua.nure.tkachenko.Final.db.exception;

/**
 * An exception that provides information on an database error.
 *
 * @author Vadym Tkachenko
 *
 */
public class DataBaseException extends Exception {

    public DataBaseException() {
        super();
    }

    public DataBaseException(String message) {
        super(message);
        System.out.println(message);
    }

    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
        System.out.println(message + cause.toString());
    }
}
