package xoxo;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * This class handles most of the GUI construction.
 * 
 * @author M. Ghautsul Azham
 * @author Mgs. Muhammad Thoyib Antarnusa
 * @author Muhammad Ardivan Satrio Nugroho
 */
public class XoxoView {

    /**
     * A field that used to build a frame
     * where the frame consist as a GUI
     */
    private JFrame frame;
    
    /**
     * A field that used to be the input of the
     * message that wants to be encrypted/decrypted.
     */
    private JTextField messageField;

    /**
     * A field that used to be the input of the key string.
     * It is a Kiss Key if it is used as the encryption.
     * It is a Hug Key if it is used as the decryption.
     */
    private JTextField keyField;

    /**
     * A filed that used to be the input of seed String
     * It is used for generate how user want to set the seed
     */
    private JTextField seedField;

    /**
     * A field that used to display any log information such
     * as you click the button, an output file succesfully
     * created, etc.
     */
    private JTextArea logField;

    /**
     * A field that used to display any log information such
     * as you click the button, an output file succesfully
     * created, etc. (In case there's a limit in view spaces)
     * so user can scroll it
     */
    private JScrollPane logFieldScrollPane;

    /**
     * A button that when it is clicked, it encrypts the message.
     */
    private JButton encryptButton;

    /**
     * A button that when it is clicked, it decrpyts the message.
     */
    private JButton decryptButton;

    //TODO: You may add more components here

    /**
     * Class constructor that initiates the GUI.
     */
    public XoxoView() {
        this.initGui();
    }

    /**
     * Constructs the GUI.
     */
    private void initGui() {
        //TODO: Construct your GUI here

        frame = new JFrame("Encrypter / Decrypter ");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu helpMenu = new JMenu("Help");
        helpMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                String message = "Message : \t\t\t the message you want to decrypt or encrypt.\n" +
                        "Hug/Kiss key : \t\t\t the key you want to use as decryptor or encryptor.\n" +
                        "Seed : \t\t\t the number (integer) you want to randomize type of decrypt or encrypt.";
                JOptionPane.showMessageDialog(frame, message);

            }

            @Override
            public void menuDeselected(MenuEvent e) {

                JOptionPane.getRootFrame().dispose();

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        menuBar.add(helpMenu);

        JMenu aboutMenu = new JMenu("About");
        aboutMenu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                JOptionPane.showMessageDialog(frame,"This is a simple the tools " +
                        "to encrypt and decrypt a message");
            }

            @Override
            public void menuDeselected(MenuEvent e) {

                JOptionPane.getRootFrame().dispose();
            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        menuBar.add(aboutMenu);

        JMenu donate = new JMenu("Donate");
        donate.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {

                JOptionPane.showMessageDialog(frame,"Apabila ingin memberikan donasi" +
                        " agar tools ini dapat berkembang harap hubungi PT.Decrypter and Encrypter ");
            }

            @Override
            public void menuDeselected(MenuEvent e) {
                JOptionPane.getRootFrame().dispose();
            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });
        menuBar.add(donate);

        // MESSAGE PANEL
        JPanel messagePanel = new JPanel();
        JLabel msgLabel = new JLabel("Message : ");
        messageField = new JTextField();
        msgLabel.setPreferredSize(new Dimension(100, 30));
        messageField.setPreferredSize(new Dimension(300, 30));
        messagePanel.add(msgLabel);
        messagePanel.add(messageField);
        topPanel.add(messagePanel, BorderLayout.NORTH);

        // KEY PANEL
        JPanel keyPanel = new JPanel();
        JLabel keyLabel = new JLabel("Kiss/Hug key : ");
        keyLabel.setPreferredSize(new Dimension(100, 30));
        keyField = new JTextField();
        keyField.setPreferredSize(new Dimension(300, 30));
        keyPanel.add(keyLabel);
        keyPanel.add(keyField);
        topPanel.add(keyPanel, BorderLayout.CENTER);

        // SEED PANEL
        JPanel seedPanel = new JPanel();
        JLabel seedLabel = new JLabel("Seed : ");
        seedLabel.setPreferredSize(new Dimension(100, 30));
        seedField = new JTextField();
        seedField.setPreferredSize(new Dimension(300, 30));
        seedPanel.add(seedLabel);
        seedPanel.add(seedField);
        topPanel.add(seedPanel, BorderLayout.SOUTH);

        // ENCRYPT and DECRYPT BUTTON
        JPanel buttonPanel = new JPanel();
        encryptButton = new JButton("Encrypt!");
        encryptButton.setBackground(Color.darkGray);
        encryptButton.setForeground(Color.white);
        decryptButton = new JButton("Decrypt!");
        decryptButton.setBackground(Color.cyan);
        buttonPanel.add(encryptButton);
        buttonPanel.add(decryptButton);

        // LOG TEXT AREA
        logField = new JTextArea();
        logFieldScrollPane = new JScrollPane(logField);
        logFieldScrollPane.setPreferredSize(new Dimension(300,50));

        // ADDING FRAME TO GUI and PACK IT
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.EAST);
        frame.add(logFieldScrollPane, BorderLayout.SOUTH);
        frame.setVisible(true);
        frame.pack();
        frame.setLocation(300, 150);
    }

    public JFrame Frame(){

        return this.frame;
    }

    /**
     * Gets the message from the message field.
     * 
     * @return The input message string.
     */
    public String getMessageText() {
        return messageField.getText().trim();
    }

    /**
     * Gets the key text from the key field.
     * 
     * @return The input key string.
     */
    public String getKeyText() {
        return keyField.getText().trim();
    }

    public String getSeedText(){

        return seedField.getText().trim();
    }

    /**
     * Appends a log message to the log field.
     *
     * @param log The log message that wants to be
     *            appended to the log field.
     */
    public void appendLog(String log) {
        logField.append(log + '\n');
    }

    /**
     * Sets an ActionListener object that contains
     * the logic to encrypt the message.
     * 
     * @param listener An ActionListener that has the logic
     *                 to encrypt a message.
     */
    public void setEncryptFunction(ActionListener listener) {
        encryptButton.addActionListener(listener);
    }
    
    /**
     * Sets an ActionListener object that contains
     * the logic to decrypt the message.
     * 
     * @param listener An ActionListener that has the logic
     *                 to decrypt a message.
     */
    public void setDecryptFunction(ActionListener listener) {
        decryptButton.addActionListener(listener);
    }
}