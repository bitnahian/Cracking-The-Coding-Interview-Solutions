package ArraysAndStrings;

public class URLify {

    public static String urilfy(String str) {
        char[] str_array = str.toCharArray();

        for(int i = 0; i < str_array.length; ++i) {
            if(str_array[i] == ' ') {
                // Shift all characters by 3 characters
                for(int j = str_array.length-1; j >= i; --j) {
                    str_array[j] = str_array[j-2];
                }
                int k = 0;
                for(char sp : "%20".toCharArray()) {
                    str_array[i+k] = sp;
                    k++;
                }
            }

        }

        return String.copyValueOf(str_array);
    }

    public static String urilfyBetter(String string, int trueLength) {
        int spaceCount = 0;
        int index = 0;

        char[] str = string.toCharArray();

        // First pass counts the number of spaces in the string
        for(int i = 0; i < trueLength; ++i) {
            if(str[i] == ' ')
                spaceCount++;
        }

        index = trueLength + spaceCount * 2;

        for(int i = trueLength-1; i >= 0; --i) {
            if(str[i] == ' ') {
                str[index-3] = '%';
                str[index-2] = '2';
                str[index-1] = '0';

                index -= 3;
            }
            else {
                str[index-1] = str[i];
                index--;
            }
        }

        return String.copyValueOf(str);

    }
}
