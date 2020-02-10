/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
 */

public class $74_Search_a_2D_Matrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int row = matrix.length;

        if(row == 0) return false;

        int column = matrix[0].length;

        if(column == 0) return false;

        int begin = 0;

        int end = row * column -1;

        while(begin <= end){

            int mid = (begin + end)/2;

            int midValue = matrix[mid/column][mid%column];

            if(midValue == target){

                return true;

            }else if(midValue < target){

                begin = mid + 1;

            }else{

                end = mid - 1;

            }
        }

        return false;
    }
}
