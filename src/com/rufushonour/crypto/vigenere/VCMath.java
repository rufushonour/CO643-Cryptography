package com.rufushonour.crypto.vigenere;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Chi Statistics
 * @author Rufus Honour
 * @author roh2@kent.ac.uk
 */
public class VCMath {
        public static double getChiSquared(String cipherText) {
        List<Double> englishFreq = Arrays.asList(0.08167,0.01492,0.02782,0.04253,0.12702,0.02228,0.02015,0.06094,0.06966,0.00153,0.00772,
                0.04025,0.02406,0.06749,0.07507,0.01929,0.00095,0.05987,0.06327,0.09056,0.02758,0.00978,
                0.02360,0.00150,0.01974,0.00074);

        List<Integer> count = new ArrayList<Integer>();
        // initialize the list to 0
        for(int i = 0; i < 26; i++) {
            count.add(0);
        }

        for(int i = 0; i < cipherText.length(); i++) {
            int letterIndex = -1;
            for(int j = 0; j < VigenereDecrypt.ALPHABET_ARRAY.length; j++) {
                // Get the corresponding index for the letter in our alphabet
                if (cipherText.charAt(i) == VigenereDecrypt.ALPHABET_ARRAY[j]) {
                    letterIndex = j;
                }
            }
            // Get the previous value in the index
            int prevValue = count.get(letterIndex);
            prevValue++;
            // put the value after incrementing back into the array
            count.set(letterIndex, prevValue);
        }

        double chi = 0.0;
        for(int i = 0; i < 26; i++) {
            chi += Math.pow((count.get(i) - cipherText.length()*englishFreq.get(i)), 2)/(cipherText.length()*englishFreq.get(i));
        }

        return chi;
    }
}
