/*
Given an array of non-negative integers nums, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

You can assume that you can always reach the last index.



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
 */

//label_greedy
//label_array
public class $45_Jump_Game_II {
    //https://leetcode.com/problems/jump-game-ii/discuss/18014/Concise-O(n)-one-loop-JAVA-solution-based-on-Greedy
    //https://www.youtube.com/watch?v=dJ7sWiOoK7g&ab_channel=NeetCode
    public static int jump(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int step = 1;
        int max = nums[0];
        int nextMax = 0;
        /*
        This is an implicit bfs solution. i == curEnd means you visited all the items on the current level.
        Incrementing jumps++ is like incrementing the level you are on. And curEnd = curFarthest is like getting the queue size (level size) for the next level you are traversing.
         */
        for (int i = 0; i < nums.length - 1; i++) {
            nextMax = Math.max(nextMax, i+nums[i]);
            if(i == max){
                max = nextMax;
                step++;
                if(nextMax >= nums.length - 1){
                    break;
                }
            }
        }
        return step;
    }
}
