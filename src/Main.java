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

        /*CaesarDecrypt decrypter = new CaesarDecrypt();
        List<String> possibleLines = decrypter.decrypt(scanner.nextLine());
        for(String line : possibleLines) {
            System.out.println(line);
        }*/

        /*
        String cipherText = scanner.nextLine();
        System.out.println("Please enter a key");
        String key = scanner.nextLine();
        String decrypted = VigenereDecrypt.decryptWithKey(cipherText, key);

        System.out.println(decrypted);*/

        /*double ic = VCMath.getIC(scanner.nextLine());

        System.out.println(ic);*/

        /*double chi = VCMath.getChiSquared(scanner.nextLine());

        System.out.println(chi);*/
        /*
        String cipherText = scanner.nextLine();
        System.out.println("Please enter a key length");
        String keyLength = scanner.nextLine();
        String key = VigenereDecrypt.WithKeyLength(cipherText, Integer.parseInt(keyLength));
        String decrypted = VigenereDecrypt.decryptWithKey(cipherText, key);
        System.out.println(decrypted);
        */
        /*
        String cipherText = scanner.nextLine();
        for(int i = 4; i < 8; i++) {
            int keyLength = i;
            String key = VigenereDecrypt.WithKeyLength(cipherText, keyLength);
            String decrypted = VigenereDecrypt.decryptWithKey(cipherText, key);
            System.out.println(decrypted);
        }
        */
        /*
        String cipherText = scanner.nextLine();
        for(int i = 4; i <= 8; i++) {
            String plainText = TranspositionDecrypt.decryptWithColLengthInOrder(cipherText, i);
            System.out.println(plainText);
        }*/

        /*
        String cipherText = scanner.nextLine();
        System.out.println(TranspositionDecrypt.decryptWithColLength(cipherText, 6));
        */

        /*
        String cipherText = scanner.nextLine();
        System.out.println(SubstitutionDecrypt.decrypt(cipherText).toString());

        String plain = "";
        char[] ALPHABET_ARRAY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ|".toCharArray();
        char[] ALPHABET_CIPHE = "BKVDTHGYEP*MFA*MNWHROSCUL|I".toCharArray();
        char[] cipherTextChars = cipherText.toCharArray();
        for(int i = 0; i < cipherText.length(); i++) {
            for(int j = 0; j < ALPHABET_ARRAY.length; j++) {
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
