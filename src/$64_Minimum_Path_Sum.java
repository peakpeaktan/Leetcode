/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

Input:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
Output: 7
Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

public class $64_Minimum_Path_Sum {

    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
                    res[0][0] = grid[i][j];
                }else if(i == 0 && j != 0){
                    res[i][j] = grid[i][j] + res[i][j-1];
                }else if(j == 0 && i != 0){
                    res[i][j] = grid[i][j] + res[i-1][j];
                }else{//j > 0 && i > 0
                    res[i][j] = Math.min(res[i][j-1], res[i-1][j]) + grid[i][j];
                }
            }
        }

        return res[m-1][n-1];
    }

    public static void main(String [] args){

        int[][] test = { {1,3,1},
                         {1,5,1},
                         {4,2,1} };
        System.out.println(minPathSum(test));
    }
}
