/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.


Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0


Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 105


Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */

//label_sliding_window
//label_two_pointers
public class $209_Minimum_Size_Subarray_Sum {
    //https://www.youtube.com/watch?v=aYqYMIqZx5s&ab_channel=NeetCode
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
