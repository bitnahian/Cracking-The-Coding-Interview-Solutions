package BitManipulation;

import org.junit.Test;

import static org.junit.Assert.*;

public class BitManipulatorTest {

    @Test
    public void insertion() {
        assertEquals(0b10001001100, BitManipulator.insertion(0b10000000000, 0b10011, 2, 6));
        assertEquals(0b10000100110, BitManipulator.insertion(0b10000000000, 0b10011, 1, 5));
    }

    @Test
    public void testPrintBinary() {
        assertEquals(".101", BitManipulator.printBinary(0.625));
        assertEquals(".1011", BitManipulator.printBinary(0.6875));

    }

    @Test
    public void testFlipBit() {
        assertEquals(5, BitManipulator.flipBit(0b0011011));
        assertEquals(1, BitManipulator.flipBit(0b0000));
        assertEquals(11, BitManipulator.flipBit(0b1110111111101));
    }

    @Test
    public void testPrintSmallest() {
        assertEquals("0000001", BitManipulator.printSmallest(0b1000000));
        assertEquals("0000111", BitManipulator.printSmallest(0b1010010));

    }

    @Test
    public void testFindNextLargest() {
        assertEquals(0b11011010001111, BitManipulator.findNextLargest(0b11011001111100));
        assertEquals(0b11011010000111, BitManipulator.findNextLargest(0b11011001111000));
        assertEquals(0b11011010000011, BitManipulator.findNextLargest(0b11011001110000));
    }

    @Test
    public void testSwap() {
        assertEquals(2, BitManipulator.bitSwapRequired(0b11101, 0b01111));
        assertEquals(1, BitManipulator.bitSwapRequired(0b01101, 0b01101));
        assertEquals(1, BitManipulator.bitSwapRequired(0b11101, 0b11101));
    }
}