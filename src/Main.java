import com.rufushonour.crypto.caesar.CaesarDecrypt;
import com.rufushonour.crypto.substitution.SubstitutionDecrypt;
import com.rufushonour.crypto.transposition.TranspositionDecrypt;

import java.util.List;
import java.util.Scanner;

/**
 * This class is the main class and will run a new instance of Main when launched
 * @author Rufus Honour
 * @author roh2@kent.ac.uk
 */
public class Main {

    public static void main(String [] args) {
        new Main();
    }

    public Main() {
        // Get the console input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your ciphertext");

        /*
        // Exercise 1
        CaesarDecrypt decrypter = new CaesarDecrypt();
        List<String> possibleLines = decrypter.decrypt(scanner.nextLine());
        //Print out all possible combinations
        for(String line : possibleLines) {
            System.out.println(line);
        }
        */

        /*
        // Exercise 2
        String cipherText = scanner.nextLine();
        System.out.println("Please enter a key");
        String key = scanner.nextLine();
        String decrypted = VigenereDecrypt.decryptWithKey(cipherText, key);

        System.out.println(decrypted);*/

        /*
        // Exercise 3
        String cipherText = scanner.nextLine();
        System.out.println("Please enter a key length");
        String keyLength = scanner.nextLine();
        String key = VigenereDecrypt.WithKeyLength(cipherText, Integer.parseInt(keyLength));
        String decrypted = VigenereDecrypt.decryptWithKey(cipherText, key);
        System.out.println(decrypted);
        */

        /*
        // Exercise 4
        String cipherText = scanner.nextLine();
        for(int i = 4; i < 8; i++) {
            int keyLength = i;
            String key = VigenereDecrypt.WithKeyLength(cipherText, keyLength);
            String decrypted = VigenereDecrypt.decryptWithKey(cipherText, key);
            System.out.println(decrypted);
        }
        */
        /*
        // Exercise 5
        String cipherText = scanner.nextLine();
        for(int i = 4; i <= 8; i++) {
            String plainText = TranspositionDecrypt.decryptWithColLengthInOrder(cipherText, i, null);
            System.out.println(plainText);
        }*/

        /*
        // Exercise 6
        String cipherText = scanner.nextLine();
        System.out.println(TranspositionDecrypt.decryptWithColLength(cipherText, 6));
        */

        /*
        // Exercise 7
        String cipherText = scanner.nextLine();
        System.out.println(SubstitutionDecrypt.getFreq(cipherText).toString());

        String plain = "";
        // ALPHABET with |
        char[] ALPHABET_ARRAY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ|".toCharArray();
        // Key
        char[] ALPHABET_CIPHE = "BKVDTHGYEP*MFA*MNWHROSCUL|I".toCharArray();
        char[] cipherTextChars = cipherText.toCharArray();
        for(int i = 0; i < cipherText.length(); i++) {
            for(int j = 0; j < ALPHABET_ARRAY.length; j++) {
                // decrypting the cipertext character into a 'real' character
                if(cipherTextChars[i] == ALPHABET_ARRAY[j]) {
                    plain += ALPHABET_CIPHE[j];
                }
            }
        }
        System.out.println(cipherText);
        System.out.println(plain);
        */
    }
}
