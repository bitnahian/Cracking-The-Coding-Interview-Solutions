package ArraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class PermutationTest {

    @Test
    public void isPermutation() {
        assertEquals(true, Permutation.isPermutation("abc", "cba"));
        assertEquals(true, Permutation.isPermutation("dog", "god"));

    }

    @Test
    public void isNotPermutation() {
        assertEquals(false, Permutation.isPermutation("asdkjasdh", "asldjalsdjalskd"));
        assertEquals(false, Permutation.isPermutation("abc", "abd"));

    }
}