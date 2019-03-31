package ArraysAndStrings;

import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {

    @Test
    public void rotate() {
        Matrix matrix = new Matrix(3,3);
        matrix.populateSequentialNumbers();
        matrix.rotate();
        matrix.rotate();
        matrix.rotate();
        matrix.rotate();
        System.out.println(matrix.toString());
    }

    @Test
    public void zero() {
        Matrix matrix = new Matrix(4, 4);
        matrix.populateSequentialNumbers();

        matrix.matrix[0][2] = 0;

        matrix.matrix[2][0] = 0;

        System.out.println(matrix);

        matrix.setZeroRowColumn();

        System.out.println(matrix);


    }
}