package xoxo.crypto;

import xoxo.exceptions.RangeExceededException;
import xoxo.exceptions.SizeTooBigException;

import java.util.Arrays;
import java.util.List;

/**
 * This class is used to create a decryption instance
 * that can be used to decrypt an encrypted message.
 *
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 */
public class XoxoDecryption {

    /**
     * A Hug Key string that is required to decrypt the message.
     */
    private String hugKeyString;
    
    List<String> alphabets = Arrays.asList(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
            "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "@", "a", "b", "c",
            "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z"
    );

    /**
     * Class constructor with the given Hug Key string.
     */
    public XoxoDecryption(String hugKeyString) {
        this.hugKeyString = hugKeyString;
    }

    /**
     * Decrypts an encrypted message.
     *
     * @param encryptedMessage An encrypted message that wants to be decrypted.
     * @return The original message before it is encrypted.
     */
    public String decrypt(String encryptedMessage, int seed) {
        //TODO: Implement decryption algorithm

        int SEED = seed;
        int HUG_KEY_LENGTH = hugKeyString.length();
        int MESSAGE_LENGTH = encryptedMessage.length();

        int HUG_KEY_XOR;
        int DEC_WITH_A;
        int XOR_ENCRYPTED_MESSAGE;
        String DECRYPTED_MESSAGE = "";

        // Applied defensive programming

        if (MESSAGE_LENGTH > 1300) {

            throw new SizeTooBigException();
        }

        if (seed < 0 || seed > 36) {

            throw new RangeExceededException();
        }

        else {

            for (int i = 0; i < MESSAGE_LENGTH; i++) {

                HUG_KEY_XOR = hugKeyString.charAt(i % HUG_KEY_LENGTH) ^ SEED;
                DEC_WITH_A = HUG_KEY_XOR - 'a';
                XOR_ENCRYPTED_MESSAGE = DEC_WITH_A ^ encryptedMessage.charAt(i);
                char addChar = (char) (XOR_ENCRYPTED_MESSAGE);
                DECRYPTED_MESSAGE += addChar;
            }

            return DECRYPTED_MESSAGE;

        }

    }
}