import java.util.*;
/*
Given an integer array nums and an integer k, return the maximum length of a subarray that sums to k. If there is not one, return 0 instead.


Example 1:

Input: nums = [1,-1,5,-2,3], k = 3
Output: 4
Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
Example 2:

Input: nums = [-2,-1,2,1], k = 1
Output: 2
Explanation: The subarray [-1, 2] sums to 1 and is the longest.


Constraints:

1 <= nums.length <= 2 * 105
-104 <= nums[i] <= 104
-109 <= k <= 109

 */

//label_array
//label_prefix_sum
public class $325_Maximum_Size_Subarray_Sum_Equals_k {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        int result = 0, sum = 0;
        hm.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (hm.containsKey(sum - k)) result = Math.max(i - hm.get(sum - k), result);
            if (!hm.containsKey(sum)) hm.put(sum, i);
        }
        return result;
    }
}
