import java.util.ArrayDeque;
import java.util.Arrays;

public class MS2 {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] field1 = {{0, 0, 0, 0, 0},
                          {0, 1, 1, 1, 0},
                          {0, 1, -1, 1, 0}};

        System.out.println(Arrays.deepToString(click(field1, 3, 5, 2, 2)));

        // click(field1, 3, 5, 2, 2) should return:
        // [[0, 0, 0, 0, 0],
        //  [0, 1, 1, 1, 0],
        //  [0, 1, -1, 1, 0]]
        
        System.out.println(Arrays.deepToString(click(field1, 3, 5, 1, 4)));
        // click(field1, 3, 5, 1, 4) should return:
        // [[-2, -2, -2, -2, -2],
        //  [-2, 1, 1, 1, -2],
        //  [-2, 1, -1, 1, -2]]


        int[][] field2 = {{-1, 1, 0, 0},
                          {1, 1, 0, 0},
                          {0, 0, 1, 1},
                          {0, 0, 1, -1}};

        System.out.println(Arrays.deepToString(click(field2, 4, 4, 0, 1)));
        // click(field2, 4, 4, 0, 1) should return:
        // [[-1, 1, 0, 0],
        //  [1, 1, 0, 0],
        //  [0, 0, 1, 1],
        //  [0, 0, 1, -1]]

        System.out.println(Arrays.deepToString(click(field2, 4, 4, 1, 3)));
        // click(field2, 4, 4, 1, 3) should return:
        // [[-1, 1, -2, -2],
        //  [1, 1, -2, -2],
        //  [-2, -2, 1, 1],
        //  [-2, -2, 1, -1]]
    }
    
    public static boolean isValid(int row, int col, int[][] board) {
        if(row < 0 || col < 0){
            return false;
        }
        else if (row >= board.length || col >= board[0].length) {
            return false;
        }
        
        return true;
    }
    
    public static void visitSquare(int[][] board, int row, int col) {
        for(int i = row-1; i < row+2; i++) {
            for(int j = col-1; j < col+2; j++) {
                if(isValid(i,j,board) && board[i][j] == 0) {
                    board[i][j] = -2;
                    visitSquare(board, i, j);
                }
            }
        }
    }


    // Implement your solution below.
    public static int[][] click(int[][] field, int numRows, int numCols, int givenI, int givenJ) {
        if(field[givenI][givenJ] == 0) {
            visitSquare(field, givenI, givenJ);
        }
        
        return field;
    }
 }
