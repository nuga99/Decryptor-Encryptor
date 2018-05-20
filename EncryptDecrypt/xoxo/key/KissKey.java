package xoxo.key;

import xoxo.exceptions.KeyTooLongException;

/**
 * The key that is required to encryt a message.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 */
public class KissKey {

    /**
     * The Kiss Key string.
     */
    private String keyString;

    /**
     * The allowed maximum length for the Kiss Key string.
     */
    public static final int MAX_LENGTH = 28;

    /**
     * Class constructor given the string to build the Kiss Key.
     * 
     * @throws KeyTooLongException if the given key string length exceeded 28 characters.
     */
    public KissKey(String keyString) throws KeyTooLongException {
        if(keyString.length() > MAX_LENGTH)
            throw new KeyTooLongException("Key length must not exceed 28");
        this.keyString = keyString;
    }

    /**
     * Gets a character at certain index.
     * 
     * @param i The index of a char that wants to be retrieved.
     * @return A char from the Kiss Key string at index i.
     */
    public int keyAt(int i) {
        return keyString.charAt(i % keyString.length());
    }

    /**
     * Gets the length of the Kiss Key string.
     * 
     * @return Length of the Kiss Key string.
     */
    public int length() {
        return keyString.length();
    }
}