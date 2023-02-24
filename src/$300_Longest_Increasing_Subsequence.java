import java.util.*;
/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].

Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1

Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104

Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */

//label_dp
public class $300_Longest_Increasing_Subsequence {
    //https://www.youtube.com/watch?v=Q6KyDl_xiIg&ab_channel=HuifengGuan
    //my solution
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;//default to 1 for each in dp array
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String [] args){
        //int[] array = {6, 5, 9, 8, 10, 2};
        int[] array = {1,2,3,5};
        System.out.println(lengthOfLIS2(array));

    }

    public static int lengthOfLIS2(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        int result = 0;
        return checkLIS2(Integer.MIN_VALUE, cache, 0, nums);
    }

    public static int checkLIS2(int base, int[] cache, int index, int[] nums){
        if(index == nums.length) return 0;
        int result = 0;
        if(cache[index] != -1){
            return cache[index];
        }
        for(int i = index; i < nums.length; i++){
            if(nums[i] <= base){
                continue;
            }
            int length = 1 + checkLIS2(nums[i], cache, i + 1, nums);
            result = Math.max(result, length);
        }
        cache[index] = result;
        return result;
    }
}
