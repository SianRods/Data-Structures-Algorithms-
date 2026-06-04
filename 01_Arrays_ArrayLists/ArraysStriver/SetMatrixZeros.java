import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeros {
    public static void main(String[] args) {
        // int matrix[][] = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        int matrix[][] = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };

        solution2(matrix);
        print2DArray(matrix);

    }

    public static void solution2(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;

        // Note that here we will be using the first row and first column of the input
        // cell as the markers
        // to deteermine whether it should be made zero or not
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check the first row for any zeros
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check the first columsn for any zeros
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // The above loops are important because we want to know before using them as
        // the markers
        // if they contain any zeros at the end the first columns or the first row has
        // to be made 'zero'

        // for the remaining matrix check for zeros and mark them up using the markers

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    // mark them up in the first row and first colus
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }

            }
        }

        // Set cells to zero based on markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // now update the firstRow or firstcol based on the boolean values
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

    }

    /**
     * These methods updates the cols and rows of zero'th element feild for all the
     * zeros using addtional space for storing the location of the rows and the
     * coloumns
     * 
     * @param matrix input m*n matrix with negative and positive integer values
     * 
     */
    public static void solution1(int matrix[][]) {
        // int matrix [][]={{1,1,1},{1,0,1},{1,1,1}};
        int m = matrix.length;
        int n = matrix[0].length;
        // first we have to keep track of all the position where the
        // actual 0's are present in the original array

        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < rows.size(); i++) {
            convertRowColZero(matrix, rows.get(i), cols.get(i));
        }

    }

    /**
     * 
     * @param matrix Input matrix of which the cols and rows have to be transformed
     *               to zeros
     * @param row    row index to be transformed of original matrix
     * @param col    col index to be transformed of original matrix
     */
    public static void convertRowColZero(int matrix[][], int row, int col) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            matrix[i][col] = 0;

        }

        for (int j = 0; j < n; j++) {
            matrix[row][j] = 0;

        }

    }

    public static void print2DArray(int matrix[][]) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
