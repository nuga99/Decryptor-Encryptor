package xoxo.exceptions;

/**
 * An exception that is thrown if the Kiss Key that
 * is used to encrypt a message exceeding 28 characters
 * in length.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 */
public class KeyTooLongException extends RuntimeException {

    /**
     * Class constructor.
     */
    public KeyTooLongException(String message) {
        super(message);
    }

}