/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.


Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [0]
Output: 0


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */

//label_dp
//label_array
public class $213_House_Robber_II {
    //https://www.youtube.com/watch?v=-i2BFAU25Zk
    //https://leetcode.com/problems/house-robber-ii/discuss/59934/Simple-AC-solution-in-Java-in-O(n)-with-explanation/61006
    public int rob(int[] nums) {

        if(nums.length == 1 ) return nums[0];

        return Math.max(rob1(nums), rob2(nums));
    }

    public int rob1(int[] nums) {

        if(nums.length == 0 ) return 0;

        int robMax = 0;
        int notRobMax = 0;

        for(int i = 0; i < nums.length - 1; i++){
            int prev = Math.max(robMax, notRobMax);
            robMax = notRobMax + nums[i];
            notRobMax = prev;
        }

        return Math.max(robMax, notRobMax);
    }

    public int rob2(int[] nums) {

        if(nums.length == 0 ) return 0;

        int robMax = 0;
        int notRobMax = 0;

        for(int i = 1; i < nums.length; i++){
            int prev = Math.max(robMax, notRobMax);
            robMax = notRobMax + nums[i];
            notRobMax = prev;
        }

        return Math.max(robMax, notRobMax);
    }
}
