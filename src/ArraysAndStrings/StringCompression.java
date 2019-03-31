package ArraysAndStrings;

public class StringCompression {

    public static String compress(String str) {
        StringBuilder compressed = new StringBuilder();

        int characterCount = 0;
        char currentChar = str.charAt(0);
        for(int i = 0; i < str.length(); ++i) {
            char c = str.charAt(i);
            if(c == currentChar){
                characterCount++;
            }
            else {
                compressed.append(currentChar);
                compressed.append(characterCount);
                currentChar = c;
                characterCount = 1;
            }
        }

        compressed.append(str.charAt(str.length()-1));
        compressed.append(characterCount);

        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}
