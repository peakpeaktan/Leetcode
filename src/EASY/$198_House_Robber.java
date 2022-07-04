package EASY;
/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.


Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 400
 */

//similar: 256, follow up: 213
//label_dp
//https://www.youtube.com/watch?v=k-JYXpHXOcU&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A
public class $198_House_Robber {
    //https://www.youtube.com/watch?v=-i2BFAU25Zk
    /* example
            2   7   9   3   1
        r   2   7  11  10  12
       nr   0   2  7   11  11
     */
    public int rob(int[] nums) {

        if(nums.length == 0 ) return 0;

        int robMax = 0;
        int notRobMax = 0;

        for (int num : nums){
            int prev = Math.max(robMax, notRobMax);
            robMax = notRobMax + num;
            notRobMax = prev;
        }

        return Math.max(robMax, notRobMax);
    }

    public int rob2(int[] num) {
        int last = 0;
        int now = 0;
        int tmp;
        for (int n :num) {
            tmp = now;
            now = Math.max(last + n, now);
            last = tmp;
        }
        return now;
    }

    //my solution, similar to rob2
    public int rob3(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int prev  = nums[0];
        int beforePrev = 0;
        int cur = nums[1];

        for (int i=1; i<nums.length; i++) {
            cur  = Math.max(prev,nums[i] + beforePrev);
            beforePrev = prev;
            prev = cur;
        }
        return cur;
    }
}
