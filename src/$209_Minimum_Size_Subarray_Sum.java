/*
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class $209_Minimum_Size_Subarray_Sum {
    //https://www.youtube.com/watch?v=jKF9AcyBZ6E
    public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0) return 0;
        int sum = 0;
        int left = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= s){
                return 1;
            }
            sum += nums[i];
            while (sum >= s){
                result = Math.min(i - left + 1, result);
                sum = sum - nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        minSubArrayLen(7, nums);
    }
}
