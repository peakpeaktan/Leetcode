/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.


Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */

//label_matrix
//label_dfs
//label_bfs
public class $200_Number_of_Islands {
    //https://www.youtube.com/watch?v=__98uL6wst8&ab_channel=TECHDOSE
    //https://www.youtube.com/watch?v=Ft0AmONMYyM
    //https://www.youtube.com/watch?v=T7IEAYtb2ts&ab_channel=%E5%B1%B1%E6%99%AF%E5%9F%8E%E4%B8%80%E5%A7%90
    public int numIslands(char[][] grid) {

        if(grid.length == 0) return 0;

        int m = grid.length;//row
        int n = grid[0].length;//column

        int answer = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if(grid[m][n] == 1){

                    DFSHelper(grid, m, n);
                    answer++;
                }
            }
        }
        return answer;
    }

    public void DFSHelper(char[][] grid, int m, int n) {

        if(m < 0 || n < 0 || m >= grid.length || n >= grid[0].length || grid[m][n] != '1') return;

        grid[m][n] = '0';//or * anything you would like
        DFSHelper(grid, m+1, n);
        DFSHelper(grid, m-1, n);
        DFSHelper(grid, m, n+1);
        DFSHelper(grid, m, n-1);

        //in this DFS we do not need to change it back to '1'
        return;
    }
}
