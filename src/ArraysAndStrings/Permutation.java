package ArraysAndStrings;

import java.util.Arrays;

public class Permutation {


    /**
     * Given two strings s and t, write a method to decide if one is a permutation of the other
     * @param s
     * @param t
     * @return
     */
    public static boolean isPermutation(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    private static String sort(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
