import java.util.*;

public class R2 {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        int a1[][] = {{1, 2, 3},
                      {4, 5, 6},
                      {7, 8, 9}};
        System.out.println(Arrays.deepToString(rotateInPlace(a1, 3)));
        // rotate(a1, 3) should return:
        // [[7, 4, 1],
        //  [8, 5, 2],
        //  [9, 6, 3]]

        int a2[][] = {{1, 2, 3, 4},
                      {5, 6, 7, 8},
                      {9, 10, 11, 12},
                      {13, 14, 15, 16}};
        System.out.println(Arrays.deepToString(rotateInPlace(a2, 4)));
        // rotate(a2, 4) should return:
        // [[13, 9, 5, 1],
        //  [14, 10, 6, 2],
        //  [15, 11, 7, 3],
        //  [16, 12, 8, 4]]
    }
    
    public static int[][] rotateInPlace(int[][] a, int n) {
        int length = n - 1;
        int count = n/2;
        for(int i = 0; i < count; i++) {
            int start = i;
            int end = length - i;
            for(int j = start; j < end; j++) {
                int offset = j -start;
                //left bottom to left top
                int top = a[start][j];
                a[start][j] = a[end - offset][start];

                //right bottom to left bottom
                a[end - offset][start] = a[end][end - offset];

                //top right to right bottom
                a[end][end - offset] = a[j][end];

                //left top to right top
                a[j][end] = top;
            }
        }
        return a;
    }

    // Implement your solution below.
    public static int[][] rotate(int[][] a, int n) {
        // NOTE: To solve it in place, write this function so that you
        // won't have to create rotated.
        int[][] rotated = new int[n][n];
        for(int i = 0, k = (a.length - 1); i < a.length; i++,k--) {
            for(int j = 0; j < a[i].length; j++) {
                rotated[j][k] = a[i][j]; 
            }
        }
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[i].length; j++) {
                a[i][j] = rotated[i][j];
            }
        }
        
        return rotated;
    }
 }
