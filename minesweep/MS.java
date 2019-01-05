import java.util.*;

public class MS {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int[][] bombs1 = {{0, 2}, {2, 0}};
        System.out.println(Arrays.deepToString(mineSweeper(bombs1, 3, 3)));
        // [[0, 1, -1],
        //  [1, 2, 1],
        //  [-1, 1, 0]]

        int[][] bombs2 = {{0, 0}, {0, 1}, {1, 2}};
        System.out.println(Arrays.deepToString(mineSweeper(bombs2, 3, 4)));
        // [[-1, -1, 2, 1],
        //  [2, 3, -1, 1],
        //  [0, 1, 1, 1]]

        int[][] bombs3 = {{1, 1}, {1, 2}, {2, 2}, {4, 3}};
        System.out.println(Arrays.deepToString(mineSweeper(bombs3, 5, 5)));
        // [[1, 2, 2, 1, 0],
        //  [1, -1, -1, 2, 0],
        //  [1, 3, -1, 2, 0],
        //  [0, 1, 2, 2, 1],
        //  [0, 0, 1, -1, 1]]
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
                if(isValid(i,j,board) && board[i][j] != -1) {
                    board[i][j]++;
                }
            }
        }
    }

    // Implement your solution below.
    public static int[][] mineSweeper(int[][] bombs, int numRows, int numCols) {
        int[][] field = new int[numRows][numCols];
        for(int i = 0; i < bombs.length; i++) {
            field[bombs[i][0]][bombs[i][1]] = -1;
            visitSquare(field, bombs[i][0], bombs[i][1]);
        }
        return field;
    }
 }
