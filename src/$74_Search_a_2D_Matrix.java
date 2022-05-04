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

//similar: 240. Search a 2D Matrix II
//label_binary_search
//label_matrix
public class $74_Search_a_2D_Matrix {
    //https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        if(row == 0 || column == 0) return false;
        int begin = 0;//index in an array
        int end = row * column -1;
        while(begin <= end){
            int mid = begin + (end - begin)/2;
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

    public static void main(String [] args){
        int[][] array = {{1, 2,  3,  4},
                         {5, 6,  7,  8},
                         {9, 10, 11, 12},
                         {13,14, 15, 16}};
        System.out.println(searchMatrix(array, 7));
    }
}
