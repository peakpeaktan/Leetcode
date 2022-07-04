import java.util.*;
/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.


Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down


Constraints:

1 <= m, n <= 100
 */

//label_dp
public class $62_Unique_Paths {
    //O(m*n) memory space
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
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

    //O(min(m, n)) memory space solution using one array
    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
