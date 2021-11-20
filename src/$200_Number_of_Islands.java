/*

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
 */
//label_matrix
//label_dfs
public class $200_Number_of_Islands {
    //https://www.youtube.com/watch?v=__98uL6wst8&ab_channel=TECHDOSE
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

        grid[m][n] = '0';
        DFSHelper(grid, m+1, n);
        DFSHelper(grid, m-1, n);
        DFSHelper(grid, m, n+1);
        DFSHelper(grid, m, n-1);

        //in this DFS we do not need to change it back to '1'
        return;
    }
}
