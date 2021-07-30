/*

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

Example 1:

Input: [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum
             jump length is 0, which makes it impossible to reach the last index.
 */

public class $55_Jump_Game {
    //https://leetcode.com/problems/jump-game/discuss/20932/6-line-java-solution-in-O(n)
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i > maxReach) return false;
            maxReach = Math.max(i + nums[i], maxReach);
        }
        return true;
    }

    public static boolean canJump2(int[] nums) {
        if(nums.length < 2) return true;

        for(int curr = nums.length-2; curr>=0;curr--){
            if(nums[curr] == 0){
                int neededJumps = 1;
                while(neededJumps > nums[curr]){
                    neededJumps++;
                    curr--;
                    if(curr < 0) return false;
                }
            }
        }
        return true;
    }

    public static void main(String [] args){
        int[] array = {2,3,1,1,4};//true
        int[] array2 = {3,2,1,0,4};//false
        int[] array3 = {2,0,0,0,3};//false

        System.out.println(canJump(array));
        System.out.println(canJump(array2));
        System.out.println(canJump(array3));

        //System.out.println(canJump2(array));
        System.out.println(canJump2(array2));
    }
}
