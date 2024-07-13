// Create EncryptionProgram Class
//     Declare random field.
//     Declare list field.
//     Declare shuffledList field.
//     Declare character field.
//     Declare letters field.
//     Define constructor to initialize fields and call newKey and askQuestion methods.
//         EncryptionProgram()
//             Initialize random
//             Initialize list
//             Initialize shuffledList
//             Set character to ' '
//             Call newKey()
//             Call askQuestion()
//     Define askQuestion method to display options and handle user input.
//             Loop
//                 Display options ("New Key", "Get Key", "Encrypt", "Decrypt", "Quit")
//                 Get user response
//                 If response is "New Key"
//                     Call newKey()
//                 Else if response is "Get Key"
//                     Call getKey()
//                 Else if response is "Encrypt"
//                     Call encrypt()
//                 Else if response is "Decrypt"
//                     Call decrypt()
//                 Else if response is "Quit"
//                     Call quit()
//                 Else
//                     Display "Invalid Choice"
//     Define newKey method to generate and shuffle a new key.
//         newKey()
//             Set character to ' '
//             Clear list
//             Clear shuffledList
//             For i from 32 to 126
//                 Add character to list
//                 Increment character
//             Copy list to shuffledList
//             Shuffle shuffledList
//             Display "*New key generated*"
//     Define getKey method to display the original and shuffled keys.
//         getKey()
//             Initialize originalKey as StringBuilder
//             Initialize shuffledKey as StringBuilder
//             For each character in list
//                 Append character to originalKey
//             For each character in shuffledList
//                 Append character to shuffledKey
//             Initialize textArea with originalKey and shuffledKey
//             Display textArea in scrollPane with title "Key"
//     Define encrypt method to encrypt a user-provided message.
//         encrypt()
//             Get message from user input
//             If message is null, return
//             Convert message to char array (letters)
//             For each character in letters
//                 For each character in list
//                     If character matches list character
//                         Replace with shuffledList character
//                         Break
//             Initialize encryptedMessage as StringBuilder
//             For each character in letters
//                 Append character to encryptedMessage
//             Initialize textArea with encryptedMessage
//             Display textArea in scrollPane with title "Encrypted Message"
//     Define decrypt method to decrypt a user-provided message.
//         decrypt()
//             Get message from user input
//             If message is null, return
//             Convert message to char array (letters)
//             For each character in letters
//                 For each character in shuffledList
//                     If character matches shuffledList character
//                         Replace with list character
//                         Break
//             Initialize decryptedMessage as StringBuilder
//             For each character in letters
//                 Append character to decryptedMessage
//             Initialize textArea with decryptedMessage
//             Display textArea in scrollPane with title "Decrypted Message"
//     Define quit method to display a goodbye message and exit the program.
//         quit()
//             Display "Thank you, have a nice day!"
//             Exit program
// Create main Method
//     Create an instance of EncryptionProgram to start the application.
//         main(String[] args)
//             Create new instance of EncryptionProgram

public class Main {

    public static void main(String[] args) {

        EncryptionProgram ep = new EncryptionProgram();

    }

}