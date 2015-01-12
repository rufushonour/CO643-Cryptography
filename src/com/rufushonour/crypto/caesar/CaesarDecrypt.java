package com.rufushonour.crypto.caesar;

import java.util.ArrayList;
import java.util.List;

/**
 * A class for decrypting caesar ciphers
 * @author Rufus Honour
 * @author roh2@kent.ac.uk
 */
public class CaesarDecrypt {
    private static int MAX_ALPHABET_LENGTH = 26;

    /**
     * A method to brute force and extract the cipherText from some ciphertext encoded with a caeser ciphers
     * @param cipherText The cipher text you want to decrypt
     * @return 26 strings of possible decryptions
     */
    public static List<String> decrypt(String cipherText) {
        char[] cipherTextChars = cipherText.toCharArray();
        List<String> possibleEntries = new ArrayList<String>();
        // Gets every possible key (26 keys) and adds it to an array
        for(int i = 0; i < cipherTextChars.length; i++) {
            char currentLetter = cipherTextChars[i];
            for(int j = 0; j < MAX_ALPHABET_LENGTH; j++) {
                String possibleEntryString = "";
                if(possibleEntries.size() == 26) {
                    possibleEntryString = possibleEntries.get(j);
                } else {
                    possibleEntries.add(possibleEntryString);
                }

                possibleEntryString += currentLetter;
                possibleEntries.set(j, possibleEntryString);
                if(currentLetter == 'Z') {
                    currentLetter = 'A';
                } else {
                    currentLetter = (char) (currentLetter + 1);
                }
            }
        }

        return possibleEntries;
    }
}
