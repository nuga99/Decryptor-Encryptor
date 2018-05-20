package xoxo.util;

import xoxo.key.HugKey;

/**
 * The class that is instantiated after the
 * encryption process which contains the
 * encrypted message and the Hug Key.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 */
public class XoxoMessage {

    /**
     * An encrypted message that is built after
     * the encryption process.
     */
    private String encryptedMessage;

    /**
     * A Hug Key which is the couple of the Kiss Key
     * that is used during the encryption process.
     */
    private HugKey hugKey;

    /**
     * Class constructor given the encrypted message
     * and the Hug Key.
     */
    public XoxoMessage(String encryptedMessage, HugKey hugKey) {
        this.encryptedMessage = encryptedMessage;
        this.hugKey = hugKey;
    }

    /**
     * Gets the Hug Key.
     * 
     * @return The Hug Key object.
     */
    public HugKey getHugKey() {
        return hugKey;
    }

    /**
     * Gets the encrypted message.
     * 
     * @return The encrypted message string.
     */
    public String getEncryptedMessage() {
        return encryptedMessage;
    }
}