package xoxo;

import xoxo.crypto.XoxoDecryption;
import xoxo.crypto.XoxoEncryption;
import xoxo.exceptions.InvalidCharacterException;
import xoxo.exceptions.KeyTooLongException;
import xoxo.exceptions.RangeExceededException;
import xoxo.exceptions.SizeTooBigException;
import xoxo.util.XoxoMessage;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * This class controls all the business
 * process and logic behind the program.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @author Muhammad Ardivan Satrio Nugroho
 */
public class XoxoController {

    /**
     * The GUI object that can be used to get
     * and show the data from and to users.
     */
    private XoxoView gui;

    /**
     * Class constructor given the GUI object.
     */
    public XoxoController(XoxoView gui) {
        this.gui = gui;
    }

    /**
     * Main method that runs all the business process.
     */
    public void run() {


        //TODO: Write your code for logic and everything here
        gui.setDecryptFunction(e -> doDecrypt());
        gui.setEncryptFunction(e-> doEncrypt());

    }

    //TODO: Create any methods that you want

    String DECRYPTED_MESSAGE = "";
    String ENCRYPTED_MESSAGE = "";
    String message = "";
    String key = "";
    String seed = "";

    public void doDecrypt(){

        XoxoDecryption decrypt;
        DECRYPTED_MESSAGE = "";
        message = gui.getMessageText();
        key = gui.getKeyText();
        seed = gui.getSeedText();
        int MESSAGE_LENGTH = message.length();
        int SEED_LENGTH = seed.length();
        int KEY_LENGTH = key.length();

        // With not file (Bonus)
        if(KEY_LENGTH < 1 || MESSAGE_LENGTH < 1 ){

            gui.appendLog("Failed to Decrypt. Try Again!");
            JOptionPane.showMessageDialog(gui.Frame(),"Input the key and message again.");
        }

        else{
            try {
                decrypt = new XoxoDecryption(key);
                if (SEED_LENGTH < 1) {
                    DECRYPTED_MESSAGE = decrypt.decrypt(message, 18);
                }
                else {
                    DECRYPTED_MESSAGE = decrypt.decrypt(message, Integer.parseInt(seed));
                }
                writeFileDecrypt(DECRYPTED_MESSAGE);
                gui.appendLog("Message has been decrypted!");

            } catch (KeyTooLongException e) {
                JOptionPane.showMessageDialog(gui.Frame(), "The key is too long! Please try again.");
            } catch (RangeExceededException e) {
                JOptionPane.showMessageDialog(gui.Frame(), "The seed of number is out of range! Please try again.");
            } catch (SizeTooBigException e) {
                JOptionPane.showMessageDialog(gui.Frame(), "The message size is too big!! Please try again.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(gui.Frame(), "Seed is not an Integer! Please try again.");
            }


        }

    }

    public void writeFileDecrypt(String message) {
        String DECRYPT_FILE_DIRECTORY = "D:/DATA D/Universitas Indonesia/FASILKOM/Semester 2/DDP2/Lab-E/lab_10/src/main/java";
        try {
            FileWriter writer = new FileWriter(DECRYPT_FILE_DIRECTORY+"/decrypted.txt");
            writer.write(message);
            writer.flush();
            writer.close();
        }

        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(gui.Frame(), "FileNotFoundException!!!");
        }

        catch (UnsupportedEncodingException e) {
            JOptionPane.showMessageDialog(gui.Frame(), "UnsupportedEncodingException!!!");
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(gui.Frame(), "There is no file with that name");
        }
    }

    public void doEncrypt(){

        XoxoEncryption encrypt;
        XoxoMessage encMessage;
        message = gui.getMessageText();
        key = gui.getKeyText();
        seed = gui.getSeedText();
        int MESSAGE_LENGTH = message.length();
        int SEED_LENGTH = seed.length();
        int KEY_LENGTH = key.length();

        if (KEY_LENGTH < 1 || MESSAGE_LENGTH < 1 ) {
            gui.appendLog("Failed to encrypt. Try again!");
            JOptionPane.showMessageDialog(gui.Frame(), "Please input the key and message!");
        }

        else {
            try {
                int SEED = Integer.parseInt(seed);
                encrypt = new XoxoEncryption(key);
                if (SEED_LENGTH < 1 ) {
                    encMessage = encrypt.encrypt(message);
                }

                else encMessage = encrypt.encrypt(message, SEED);

                writeFileEncrypt(encMessage);
                gui.appendLog("The message has been encrypted!");
            }
            catch (KeyTooLongException e) {
                JOptionPane.showMessageDialog(gui.Frame(), "The key is too long! Please try again.");
            }
            catch (InvalidCharacterException e) {
                JOptionPane.showMessageDialog(gui.Frame(), "Key must be alphabetical or '@'!");
            }
            catch (RangeExceededException e) {
                JOptionPane.showMessageDialog(gui.Frame(), "The seed of number is out of range! Please try again.");
            }
            catch (SizeTooBigException e) {
                JOptionPane.showMessageDialog(gui.Frame(), "The message size is too big!! Please try again.");
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(gui.Frame(), "Seed is not an Integer! Please try again.");
            }

            finally{
                System.out.println(seed.getClass().getName());
            }
        }
    }

    public void writeFileEncrypt(XoxoMessage message) {
        String ENCRYPT_FILE_DIRECTORY = "D:/DATA D/Universitas Indonesia/FASILKOM/Semester 2/DDP2/Lab-E/lab_10/src/main/java";
        try {
            FileWriter writer = new FileWriter(ENCRYPT_FILE_DIRECTORY+"/encrypt.enc");
            writer.write(message.getEncryptedMessage() + "\n");
            writer.write("Flag / Hug key to Decrypt: " + message.getHugKey().getKeyString());
            writer.flush();
            writer.close();
        }
        catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(gui.Frame(), "FileNotFound!");
        }
        catch (UnsupportedEncodingException e) {
            JOptionPane.showMessageDialog(gui.Frame(), "UnsupportedEncodingFile!");
        }
        catch (IOException e) {
            JOptionPane.showMessageDialog(gui.Frame(), "No file with that name!");
        }
    }


}