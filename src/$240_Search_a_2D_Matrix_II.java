/*
https://leetcode.com/problems/search-a-2d-matrix-ii/
 */

//similar: 74. Search a 2D Matrix
//label_matrix
public class $240_Search_a_2D_Matrix_II {
    //https://www.youtube.com/watch?v=-IzCjqVsjZw
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null) return false;
        int column = matrix[0].length;
        int row = matrix.length;
        int i = row - 1;
        int j = 0;
        while (i >= 0 && i < row && j >= 0 && j < column){
            if(matrix[i][j] > target){
                i--;
            }else if(matrix[i][j] < target){
                j++;
            }else{
                return true;
            }
        }
        return false;
    }
}
