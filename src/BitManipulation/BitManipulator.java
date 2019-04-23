package BitManipulation;

public class BitManipulator {

    public static int bitSwapRequired(int a, int b) {
        int count = 0;
        while(a != 0 | b != 0) {
            boolean aF = (a & 1) != 0;
            boolean bF = (b & 1) != 0;

            if (!(aF & bF)) {
                count++;
            }
            a = a >>> 1;
            b = b >>> 1;
        }

        return count;
    }

    public static int findNextLargest(int a) {
        if(a == 0) // If all 0s
            return 0;
        if (~(a) == 0) {
            // If all ones
            a = a << 1;
            return a;
        }

        int pointer = 1;

        while(true) {
            if((a & pointer) != 0) {
               break;
            }
            pointer = (pointer << 1);
        }
        int numOnes = 0;

        while(true) {
            if((a & pointer) == 0) {
                a = a | pointer; // Flip the 0 to 1
                int mask = ~(pointer - 1);
                a = a & mask;
                break;
            }
            else if((a & pointer) != 0) {
                // If these are all ones
                numOnes = (numOnes << 1) + 1;
            }
            pointer = pointer << 1;
        }

        // Remove 1 one from numOnes
        numOnes = numOnes >>> 1;
        // Create a mask with numOnes

        return (a | numOnes);
    }

    public static String printSmallest(int a) {

        int length = 0;
        StringBuilder builder = new StringBuilder();
        while (a != 0) {
            if( (a&1) == 1) {
                // If you see a 1
                builder.append(1);
            }
            length++;
            a = a >>> 1;
        }

        while(length - builder.length() > 0) {
            builder.insert(0, 0);
        }

        return builder.toString();
    }

    public static int flipBit(int a) {
        if(~(a) == 0) {
            return Integer.BYTES * 8; // Longest sequence possible
        }

        int currentLength = 0;
        int previousLength = 0;
        int maxLength = 1; // By flipping 1 bit in a bit array of 0

        while (a != 0) {
            if ((a & 1) == 1) {
                // If you see a 1
                currentLength++;
            }
            else if((a&1) == 0) {
                // If you see a 0
                previousLength = (a & 2) == 0 ? 0 : currentLength;
                currentLength = 0;
            }

            a = a >>> 1; // Logical shift to right
            maxLength = Math.max(currentLength + previousLength + 1, maxLength);

        }

        return maxLength;

    }
    /**
     * You are given two 32-bit numbers, N and M, and two bit positions i and j. Write a method to insert
     * M into N such that M starts at bit j and ends at bit i. You can assume that the bits j through i
     * have enough space to fit all of M. That is, if M = 10011, you can assume there are at least 5 bits
     * between j and i. You would not, for example, have j = 3 and i = 2, because M could not fully fit
     * between bit 3 and bit 2
     * @param N
     * @param M
     * @param i
     * @param j
     * @return
     */
    public static int insertion(int N, int M, int i, int j) {
        // Create a mask of all 1s
        int allOnes = ~(0);

        // 1s before position j, then 0s
        int left = allOnes << (j + 1);

        // 1s after position i
        int right = ((1 << i) - 1);

        int mask = left | right;

        // Clear bits j through i then put m in there
        N = N & mask;

        int result = (N | (M << i));

        return result;
    }

    public static String printBinary(double num) {
        if(num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(".");

        while(num > 0) {

            if(builder.length() > 32) {
                return "ERROR";
            }

            double r = num * 2;
            if (r >= 1) {
                builder.append(1);
                num = r - 1;
            }
            else {
                builder.append(0);
                num = r;
            }

        }
        return builder.toString();
    }

    public static boolean getBit(int num, int i) {
        return ((num & (1 << i)) != 0);
    }

    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    public static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return (num & mask);
    }

    public static int clearBitsMSBthroughI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    public static int clearBitsIhtrough0(int num, int i) {
        int mask = -1 << (i + 1);
        return num & mask;
    }



}
