/*
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.  The cost of painting each house with a certain color is different.

You have to paint all the houses such that no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix.

For example, costs[0][0] is the cost of painting house 0 with color red;costs[1][2] is the cost of painting house 1 with color green, and so on...

Find the minimum cost to paint all houses.

Example:

Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
             Minimum cost: 2 + 5 + 3 = 10.
 */

//label_dp
//label_important
public class $256_Paint_House {
    //https://www.youtube.com/watch?v=BCUQb9UEUFs&ab_channel=AndroidBabies%E5%AE%89%E5%8D%93%E5%A4%A7%E5%AE%9D%E8%B4%9D%E4%BB%AC
    //https://www.youtube.com/watch?v=PCC6Tshwxbo&ab_channel=%E5%B1%B1%E6%99%AF%E5%9F%8E%E4%B8%80%E5%A7%90
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0) {
            return 0;
        }
        int[][] copy = new int[costs.length][3];//create a copy, or you can modify the original array but that is not recommended
        copy[0][0] = costs[0][0];
        copy[0][1] = costs[0][1];
        copy[0][2] = costs[0][2];
        for (int i = 1; i < copy.length; i++) {
            copy[i][0] = Math.min(costs[i-1][1], costs[i-1][2]) + costs[i][0];
            copy[i][1] = Math.min(costs[i-1][0], costs[i-1][2]) + costs[i][0];
            copy[i][2] = Math.min(costs[i-1][0], costs[i-1][1]) + costs[i][0];
        }
        return Math.min(Math.min(copy[costs.length-1][0], copy[costs.length-1][1]), copy[costs.length-1][2]);
    }
}
