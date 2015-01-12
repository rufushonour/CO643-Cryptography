package com.rufushonour.crypto.transposition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class for decrypting transposition ciphers
 * @author Rufus Honour
 * @author roh2@kent.ac.uk
 */
public class TranspositionDecrypt {
    /**
     * Decrypt the cipherText with the columns in order.
     * @param cipherText the cipherText you want to decrypt
     * @param columnAmount the amount of columns the ciphertext is encrypted with
     * @param columns optional if you want to give it some columns to decrypt with.
     * @return A string which will contain the plaintext if the columns are in the correct order
     */
    public static String decryptWithColLengthInOrder(String cipherText, int columnAmount, Map<Integer, List<Character>> columns) {
        // If no columns are defined then we want to make them from the ciphertext
        if(columns == null) {
            columns = makeColumnsFromCipher(cipherText, columnAmount);
        }
        String plainText = "";
        int j = 0;
        int k = 0;
        // Go through each column getting the next value and put it into the plaintext
        for(int i = 0; i < cipherText.length(); i++) {
            plainText += Character.toString(columns.get(j).get(k));

            // If we have run out of columns then we want to start from the first column again
            if(j == columnAmount - 1){
                j = 0;
                k++;
            } else {
                j++;
            }
        }
        return plainText;
    }

    /**
     * Makes the columns when given some cipherText and a column amount
     * @param cipherText the ciphertext you want to make columns with
     * @param colAmount the amount of columns we need to split the ciphertext into
     * @return A HashMap which contains the number of columns which its corresponding characters from the ciphertext
     */
    private static Map<Integer, List<Character>> makeColumnsFromCipher(String cipherText, int colAmount) {
        Map<Integer, List<Character>> columns = new HashMap<Integer, List<Character>>();

        int columnSize = cipherText.length() / colAmount;
        int columnIndex = 0;
        // Make the columns from the cipherText
        for(int i = 0; i <= cipherText.length() - columnSize; i += columnSize) {
            // Every n'th columnsize we want to make a new column
            String column = cipherText.substring(i, i + columnSize);
            List<Character> columnChars = new ArrayList<Character>();
            // Adds the characters to an array to put in our HashMap
            for(int j = 0; j < column.toCharArray().length; j++) {
                columnChars.add(column.toCharArray()[j]);
            }
            columns.put(columnIndex, columnChars);
            // Next column
            columnIndex++;
        }

        return columns;
    }

    /**
     * A method that
     * @param cipherText the ciphertext you want to decrypt
     * @param columnAmount the amount of columns there are
     * @return A string containing the plaintext after decryption
     */
    public static String decryptWithColLength(String cipherText, int columnAmount) {
        // Sort the ciphertext into columns in the order they are in the cipher text
        Map<Integer, List<Character>> columns = makeColumnsFromCipher(cipherText, columnAmount);

        Map<Integer, List<Character>> newColumns = new HashMap<Integer, List<Character>>();
        // Set the columns to the ones you have worked out by looking for words in the output
        newColumns.put(0, columns.get(5));
        newColumns.put(1, columns.get(4));
        newColumns.put(2, columns.get(0));
        newColumns.put(3, columns.get(1));
        newColumns.put(4, columns.get(2));
        newColumns.put(5, columns.get(3));

        // decrypt the ciphertext using the columns specified above
        String possiblePlain = decryptWithColLengthInOrder(cipherText, columnAmount, newColumns);

        return possiblePlain;
    }
}
