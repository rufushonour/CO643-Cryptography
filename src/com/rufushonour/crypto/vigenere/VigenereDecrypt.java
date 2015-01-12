package com.rufushonour.crypto.vigenere;

import com.rufushonour.crypto.caesar.CaesarDecrypt;

import java.util.ArrayList;
import java.util.List;
/**
 * A class for decrypting vigenere ciphers
 * @author Rufus Honour
 * @author roh2@kent.ac.uk
 */
public class VigenereDecrypt {
    // An array to hold the alphabet so we can wrap around when we need to easier - also can add other characters here if we need them
    protected static char[] ALPHABET_ARRAY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * A method for getting the key of a vigenere cipher if the key length is known
     * It uses chi-squared statistics which compares it to the english letter frequencies
     * @param cipherText the ciphertext you want to decrypt
     * @param keyLength the length of the key
     * @return the keyword used for enciphering the text
     */
    public static String WithKeyLength(String cipherText, int keyLength) {
        String keyword = "";
        // for each of the letters in the key length we want to find a ceaser cipher for each one.
        for(int i = 0; i < keyLength; i++) {
            String newCipher = "";
            for(int j = 0; j < cipherText.length(); j++) {
                // creating the ceaser cipher
                if(!(((keyLength+i) * j) + 1 > cipherText.length())) {
                    if(j == 0) {
                        newCipher += cipherText.substring(i, i + 1);
                    } else {
                        newCipher += cipherText.substring((keyLength * j) + i, ((keyLength * j) + i) + 1);
                    }
                }
            }
            // Uses the ceaser decrypter class to get 26 possible combinations
            List<String> caesers = CaesarDecrypt.decrypt(newCipher);

            // We now compare these 26 caeser ciphers to the letter freqencies in english
            List<Double> chiSquared = new ArrayList<Double>();
            for(String cipher : caesers) {
                chiSquared.add(VCMath.getChiSquared(cipher));
            }

            int chiIndex = -1;
            double chiLowest = -1;
            // We want to find the lowest chi squared value which indicates its the closest to english
            for(int j = 0; j < chiSquared.size(); j++) {
                double chi = chiSquared.get(j);
                if(chiLowest == -1) {
                    chiLowest = chi;
                    chiIndex = j;
                }
                if(chi < chiLowest) {
                    chiLowest = chi;
                    chiIndex = j;
                }
            }


            char[] cipherTextChars = cipherText.toCharArray();
            char cipherchar = cipherTextChars[i];
            int cipherTextIndex = -1;
            // We want to get this from our alphabet array for easier adding and subtracting
            for(int k = 0; k < ALPHABET_ARRAY.length; k++) {
                if(ALPHABET_ARRAY[k] == cipherchar) {
                    cipherTextIndex = k;
                }
            }
            // Once we have found the chi squared index we want to minus the chiIndex (which corresponds to a letter) from the ciphertext value to get our plainTextIndex
            // All these indexs are numbers instead of letters but they correspond to letters from the ALPHABET_ARRAY static constant.
            int plainTextIndex = cipherTextIndex + chiIndex;
            // Subtract the ciphertText by the index of the plainText which will give us our key value
            for(int k = 0; k < plainTextIndex; k++) {
                if(cipherTextIndex == 0) {
                    cipherTextIndex = 25;
                } else {
                    cipherTextIndex -= 1;
                }
            }

            // Get the key char from the alphabet array and add it to our end value.
            keyword += ALPHABET_ARRAY[cipherTextIndex];
        }
        return keyword;
    }

    /**
     * Decrypt some vigenere cipher text encrypted with an key
     * @param cipherText the cipher text you want to decrypt
     * @param key the key you want to decrypt with
     * @return the decrypted text
     */
    public static String decryptWithKey(String cipherText, String key) {
        // The key is not always as long as the cipherText so we need to keep an eye on where we are.
        int keyIndex = 0;
        String decryptedText = "";

        char[] cipherTextChars = cipherText.toCharArray();
        char[] keyChars = key.toCharArray();

        // We need to loop through the cipherText
        for(int i = 0; i < cipherText.length(); i++) {
            // Variables for holding array indices of each type (key and cipertext)
            int alphabetKeyIndex = -1;
            int alphabetCipherIndex = -1;
            for(int j = 0; j < ALPHABET_ARRAY.length; j++) {
                // If the key char is in the array then we want to hold the index at which the statement equaled true
                if(ALPHABET_ARRAY[j] == keyChars[keyIndex]) {
                    alphabetKeyIndex = j;
                }

                // same as above but with the cipherText char instead
                if(ALPHABET_ARRAY[j] == cipherTextChars[i]) {
                    alphabetCipherIndex = j;
                }
            }
            // We subtract the cipherIndex by the index of the key, which will give us our decrypted letter
            // This is only done one at a time in case we hit 0 as we will want to wrap back around to 'Z' and carry on
            for(int j = 0; j < alphabetKeyIndex; j++) {
                if(alphabetCipherIndex == 0) {
                    alphabetCipherIndex = 25;
                } else {
                    alphabetCipherIndex -= 1;
                }
            }
            // The 'real' character is added to the end string
            decryptedText += ALPHABET_ARRAY[alphabetCipherIndex];

            // Start from the beginning index of the key
            if (keyIndex == key.length() - 1) {
                keyIndex = 0;
            } else {
                keyIndex++;
            }
        }
        return decryptedText;
    }
}
