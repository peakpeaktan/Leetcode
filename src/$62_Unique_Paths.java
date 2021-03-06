/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

https://leetcode.com/problems/unique-paths/description/

Above is a 7 x 3 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right
Example 2:

Input: m = 7, n = 3
Output: 28
 */

public class $62_Unique_Paths {

    public int uniquePaths(int m, int n) {

        int[][] result = new int[m][n];
        //IMPORTANT: int[m][n] declares a 2D array with m rows and n columns
        /*
        int[][] multi = new int[5][10];
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
         */

        for (int i = 0; i < m; i++) {
            result[i][0] = 1;//set first column all 1
        }

        for (int i = 0; i < n; i++) {
            result[0][i] = 1;//set first row all 1
        }

        for (int x = 1; x < m; x++) {

            for (int y = 1; y < n; y++) {

                result[x][y] = result[x-1][y] + result[x][y-1];
            }
        }

        return result[m-1][n-1];
    }
}
