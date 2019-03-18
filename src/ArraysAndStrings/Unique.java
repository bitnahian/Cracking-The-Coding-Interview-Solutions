package ArraysAndStrings;

import java.util.Arrays;

public class Unique {

    public static boolean isUnique(String sample) {
        char[] chars = sample.toCharArray();
        Arrays.sort(chars);
        String sorted = new String(chars);

        for(int i = 0; i < sorted.length() - 1; i++) {
            if(sorted.charAt(i) == sorted.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

    public static boolean isUniqueO1(String sample) {
        // Assume ASCII 128
        int ASCII_SIZE = 128;
        if(sample.length() > ASCII_SIZE)
            return false;

        boolean[] char_set = new boolean[ASCII_SIZE];

        for(int i = 0; i < sample.length(); ++i) {
            int val = sample.charAt(i);
            // If the character has already been seen
            if(char_set[val]) {
                return false;
            }
            char_set[val] = true;
        }
        return true;
    }
}
