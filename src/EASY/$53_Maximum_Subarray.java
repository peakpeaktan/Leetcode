package EASY;
/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.


Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Example 2:

Input: nums = [1]
Output: 1
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104


Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

//label_dp
public class $53_Maximum_Subarray {
    //https://www.youtube.com/watch?v=6xLjNawbyUc&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A
    public static int maxSubArrayDP(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + (dp[i-1] > 0 ? dp[i-1] : 0);
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    //https://www.youtube.com/watch?v=EcJ0wBBMoKA&ab_channel=basketwangCoding
    public static int maxSubArray(int[] A) {
        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    public static void main(String [] args){

        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(maxSubArrayDP(nums));
        System.out.println(maxSubArray(nums));
    }

}
