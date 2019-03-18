package ArraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniqueTest {

    @Test
    public void isUnique() {

        assertEquals("String should be unique", true, Unique.isUnique("abc"));
        assertEquals("String should be unique", true, Unique.isUnique("def"));
        assertEquals("String should be unique", true, Unique.isUnique("abcdj9123"));
        assertEquals("String should be unique", true, Unique.isUnique("onetwhr"));


        assertEquals("String should be unique", true, Unique.isUniqueO1("abc"));
        assertEquals("String should be unique", true, Unique.isUniqueO1("def"));
        assertEquals("String should be unique", true, Unique.isUniqueO1("abcdj9123"));
        assertEquals("String should be unique", true, Unique.isUniqueO1("onetwhr"));

    }

    @Test
    public void isNotUnique() {
        assertEquals("String should not be unique", false, Unique.isUnique("aaa"));
        assertEquals("String should not be unique", false, Unique.isUnique("dedfg"));
        assertEquals("String should not be unique", false, Unique.isUnique("abcdefgha"));
        assertEquals("String should not be unique", false, Unique.isUnique("lmaook"));

        assertEquals("String should not be unique", false, Unique.isUniqueO1("aaa"));
        assertEquals("String should not be unique", false, Unique.isUniqueO1("dedfg"));
        assertEquals("String should not be unique", false, Unique.isUniqueO1("abcdefgha"));
        assertEquals("String should not be unique", false, Unique.isUniqueO1("lmaook"));

    }
}