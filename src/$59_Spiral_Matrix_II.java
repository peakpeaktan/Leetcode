/*
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */

//similar: 54. Spiral Matrix
//label_matrix
public class $59_Spiral_Matrix_II {
    //https://leetcode.com/problems/spiral-matrix-ii/discuss/22289/My-Super-Simple-Solution.-Can-be-used-for-both-Spiral-Matrix-I-and-II/21913
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];

        int cur = 1;
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;

        while(cur <= n * n) {
            int i;
            int j;
            //left to right
            for(j = colBegin ; j <= colEnd; j++){
                res[rowBegin][j] = cur++;
            }
            rowBegin++;
            //top to bot
            for(i = rowBegin ; i <= rowEnd; i++){
                res[i][colEnd] = cur++;
            }
            colEnd--;
            //right to left
            for(j = colEnd ; j >= colBegin; j--){
                res[rowEnd][j] = cur++;
            }
            rowEnd--;
            //bot to top
            for(i = rowEnd; i >= rowBegin; i--){
                res[i][colBegin] = cur++;
            }
            colBegin++;
        }
        return res;
    }

    public static void main(String [] args){

        System.out.println(generateMatrix(4));
    }
}
