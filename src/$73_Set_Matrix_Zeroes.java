/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:

Input:
[
  [1,1,1],
  [1,0,1],
  [1,1,1]
]
Output:
[
  [1,0,1],
  [0,0,0],
  [1,0,1]
]
Example 2:

Input:
[
  [0,1,2,0],
  [3,4,5,2],
  [1,3,1,5]
]
Output:
[
  [0,0,0,0],
  [0,4,5,0],
  [0,3,1,0]
]
Follow up:

A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */

//label_matrix
public class $73_Set_Matrix_Zeroes {
    //https://www.youtube.com/watch?v=-I8w2_sN93c
    //https://www.youtube.com/watch?v=5LU0pv0-ZtI
    //https://leetcode.com/problems/set-matrix-zeroes/discuss/26008/My-AC-java-O(1)-solution-(easy-to-read)
    public static void setZeroes(int[][] matrix) {
        boolean firstRowAllZero = false,firstColumnAllZero = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) firstRowAllZero = true;
                    if(j == 0) firstColumnAllZero = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(firstRowAllZero) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(firstColumnAllZero) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String [] args){
        int[][] array = {{1,1,0,1},
                         {1,0,1,1},
                         {1,1,0,1},
                         {1,1,1,1}};
        setZeroes(array);
        System.out.println(array);
    }
}
