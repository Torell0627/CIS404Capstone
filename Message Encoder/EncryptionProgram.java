import javax.swing.*;
import java.util.*;

public class EncryptionProgram {

    private Random random;
    private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private char[] letters;

    EncryptionProgram() {
        random = new Random();
        list = new ArrayList<>();
        shuffledList = new ArrayList<>();
        character = ' ';

        newKey();
        askQuestion();
    }

    private void askQuestion() {
        while (true) {
            String[] options = {"New Key", "Get Key", "Encrypt", "Decrypt", "Quit"};
            int response = JOptionPane.showOptionDialog(null, "What would you like to do?",
                    "Encryption Program", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (response) {
                case 0:
                    newKey();
                    break;
                case 1:
                    getKey();
                    break;
                case 2:
                    encrypt();
                    break;
                case 3:
                    decrypt();
                    break;
                case 4:
                    quit();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Choice");
            }
        }
    }

    private void newKey() {
        character = ' ';
        list.clear();
        shuffledList.clear();

        for (int i = 32; i < 127; i++) {
            list.add(Character.valueOf(character));
            character++;
        }

        shuffledList = new ArrayList<>(list);
        Collections.shuffle(shuffledList);
        JOptionPane.showMessageDialog(null, "*New key generated*");
    }

    private void getKey() {
        StringBuilder originalKey = new StringBuilder("Original Key: \n");
        StringBuilder shuffledKey = new StringBuilder("Shuffled Key: \n");

        for (Character x : list) {
            originalKey.append(x);
        }
        originalKey.append("\n");

        for (Character x : shuffledList) {
            shuffledKey.append(x);
        }
        shuffledKey.append("\n");

        JTextArea textArea = new JTextArea(originalKey.toString() + "\n" + shuffledKey.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(650, 200));
        JOptionPane.showMessageDialog(null, scrollPane, "Key", JOptionPane.INFORMATION_MESSAGE);
    }

    private void encrypt() {
        String message = JOptionPane.showInputDialog("Enter a message to be encrypted:");
        if (message == null) return;

        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < list.size(); j++) {
                if (letters[i] == list.get(j)) {
                    letters[i] = shuffledList.get(j);
                    break;
                }
            }
        }

        StringBuilder encryptedMessage = new StringBuilder("Encrypted Message: ");
        for (char x : letters) {
            encryptedMessage.append(x);
        }

        JTextArea textArea = new JTextArea(encryptedMessage.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 200));
        JOptionPane.showMessageDialog(null, scrollPane, "Encrypted Message", JOptionPane.INFORMATION_MESSAGE);
    }

    private void decrypt() {
        String message = JOptionPane.showInputDialog("Enter a message to be decrypted:");
        if (message == null) return;

        letters = message.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < shuffledList.size(); j++) {
                if (letters[i] == shuffledList.get(j)) {
                    letters[i] = list.get(j);
                    break;
                }
            }
        }

        StringBuilder decryptedMessage = new StringBuilder("Decrypted Message: ");
        for (char x : letters) {
            decryptedMessage.append(x);
        }

        JTextArea textArea = new JTextArea(decryptedMessage.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 200));
        JOptionPane.showMessageDialog(null, scrollPane, "Decrypted Message", JOptionPane.INFORMATION_MESSAGE);
    }

    private void quit() {
        JOptionPane.showMessageDialog(null, "Thank you, have a nice day!");
        System.exit(0);
    }

    public static void main(String[] args) {
        new EncryptionProgram();
    }
}
