package ArraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class URLifyTest {

    @Test
    public void testUrilify() {
        assertEquals("Mr%20John%20Smith", URLify.urilfyBetter("Mr John Smith    ", 13));
    }
}