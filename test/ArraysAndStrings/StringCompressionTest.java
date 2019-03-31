package ArraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompressionTest {

    @Test
    public void compress() {
        assertEquals("a3b2c4d1", StringCompression.compress("aaabbccccd"));
        assertEquals("a3b2c4d3", StringCompression.compress("aaabbccccddd"));
        assertEquals("a3b2c4", StringCompression.compress("aaabbcccc"));
        assertEquals("abc", StringCompression.compress("abc"));


    }
}