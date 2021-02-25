/*
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 */

public class $221_Maximal_Square {
    //https://www.youtube.com/watch?v=5AfIa6z3Yw0
    public static int maximalSquare(char[][] matrix) {
        int column = matrix[0].length;
        int row = matrix.length;
        int maxLength = 0;
        for (int i = 0; i < column; i++) {
            if(matrix[0][i] == '1'){
                maxLength = 1;
            }
        }
        for (int i = 0; i < row; i++) {
            if(matrix[i][0] == '1'){
                maxLength = 1;
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if(matrix[i][j] != '0'){
                    int top = matrix[i-1][j] - '0';
                    int diagonal = matrix[i-1][j-1] - '0';
                    int left = matrix[i][j-1] - '0';
                    int length = Math.min(top, Math.min(diagonal, left)) + 1;
                    maxLength = Math.max(maxLength, length);
                    matrix[i][j] = (char)('0' + length - 0);
                }
            }
        }
        return maxLength*maxLength;
    }

    /*another form, this simplifies things when for example it's 1 1, the 1st solution will start from [1,1] and since it's 0, it will not return correct answer.
                                                                 1 0

     */
    public static int maximalSquare2(char[][] a) {
        if(a.length == 0) return 0;
        int m = a.length, n = a[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(a[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        return result*result;
    }

    public static void main(String[] args){
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        maximalSquare(matrix);
    }
}
