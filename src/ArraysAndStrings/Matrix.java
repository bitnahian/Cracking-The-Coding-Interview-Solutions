package ArraysAndStrings;

public class Matrix {

    private int row;
    private int column;
    public int[][] matrix;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        matrix = new int[row][column];
    }

    public void rotate() {
        for(int layer = 0; layer < row/2; ++layer) {
            int first = layer;
            int last = row - layer - 1;

            // From first to last layer

            for(int i = first; i < last; ++i) {
                int offset = i - first;

                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;

            }
        }
    }

    public void populateSequentialNumbers(){
        for(int i = 0; i < row; ++i)
            for(int j = 0; j < column; ++j) {
                matrix[i][j] = row*i + j+1;
            }
    }

    public void nullifyRow(int row) {
        for(int i = 0; i < column; ++i)
            matrix[row][i] = 0;
    }

    public void nullifyColumn(int column) {
        for(int i = 0; i < row; ++i)
            matrix[i][column] = 0;
    }

    public void setZeroRowColumn() {
        boolean[] rowb = new boolean[row];
        boolean[] columnb = new boolean[column];

        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < column; ++j) {
                if(matrix[i][j] == 0){
                    rowb[i] = true;
                    columnb[j] = true;
                }
            }
        }

        for(int i = 0; i < rowb.length; ++i)
            if(rowb[i])
                nullifyRow(i);

        for(int i = 0; i < columnb.length; ++i)
            if(columnb[i])
                nullifyColumn(i);

    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        for(int i = 0; i < row; ++i) {
            for(int j = 0; j < column; ++j)
            {
                str.append(matrix[i][j]);
                str.append(" ");
            }
            str.append("\n");
        }

        return str.toString();
    }
}
