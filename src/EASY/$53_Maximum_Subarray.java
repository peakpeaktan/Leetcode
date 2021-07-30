package EASY;

/*

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */

//https://www.youtube.com/watch?v=EcJ0wBBMoKA
//https://www.youtube.com/watch?v=zT28AwRNTaQ
public class $53_Maximum_Subarray {
    //https://leetcode.com/problems/maximum-subarray/discuss/329089/O(N)-TIME-O(1)-SPACE-JAVA-SOLUTION
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
