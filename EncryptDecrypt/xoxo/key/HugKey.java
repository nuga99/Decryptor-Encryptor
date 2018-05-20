package xoxo.key;

/**
 * The key that is required to decrypt an
 * encrypted message.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 */
public class HugKey {

    /**
     * The Hug Key string.
     */
    private String keyString;
    
    /**
     * Default seed that is used to generate the Hug Key string.
     */
    public static final int DEFAULT_SEED = 18;

    /**
     * Minimum allowed seed to be used.
     */
    public static final int MIN_RANGE = 0;

    /**
     * Maximum allowed seed to be used.
     */
    public static final int MAX_RANGE = 36;

    /**
     * Class constructor given its couple Kiss Key.
     */
    public HugKey(KissKey kissKey) {
        this(kissKey, DEFAULT_SEED);
    }

    /**
     * Class constructor given its couple Kiss Key and
     * a number seed to be used to generate the Hug Key string.
     */
    public HugKey(KissKey kissKey, int seed) {
        this.keyString = this.convert(kissKey, seed);
    }

    /**
     * Gets the Hug Key string.
     * 
     * @return The Hug Key string.
     */
    public String getKeyString() {
        return keyString;
    }

    /**
     * Converts Kiss Key into a Hug Key so it can
     * be used to decrypt a message.
     * 
     * @param kissKey The Kiss Key that is used to encrypt a message.
     * @param seed A number to create a different Hug Key
     *             even the Kiss Key is the same.
     * @return A Hug Key string that can be used to decrypt a message.
     */
    private String convert(KissKey kissKey, int seed) {
        String keyString = "";
        final int length = kissKey.length();
        for (int i = 0; i < length; i++) {
            int k = kissKey.keyAt(i);
            int value = k ^ seed;
            keyString += (char) value;
        }
        return keyString;
    }
}