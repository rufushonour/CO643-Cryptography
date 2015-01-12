package com.rufushonour.crypto.substitution;

import java.util.HashMap;
import java.util.Map;

/**
 * A class for decrypting substitution ciphers
 * @author Rufus Honour
 * @author roh2@kent.ac.uk
 *
 * @author Peter Cramp
 * @author pc289@kent.ac.uk
 */
public class SubstitutionDecrypt {

    /**
     * Gives the letter frequencies of the cipherText
     * @param cipherText the ciphertext you want to get the frequencies for
     * @return A HashMap which contains the character and its frequency in the ciphertext
     */
    public static Map<Character, Double> getFreq(String cipherText) {
        Map<Character, Integer> characterCount = new HashMap<Character, Integer>();
        Map<Character, Double> characterFreq = new HashMap<Character, Double>();
        char[] cipherTextChars = cipherText.toCharArray();
        for(int i = 0; i < cipherText.length(); i++) {
            int count = 0;
            if(characterCount.containsKey(cipherTextChars[i])) {
                count = characterCount.get(cipherTextChars[i]);
            }
            count++;

            double percent = ((double) count / (double) cipherText.length()) * 100;
            characterCount.put(cipherTextChars[i], count);
            characterFreq.put(cipherTextChars[i], percent);
        }

        return characterFreq;
    }

}
