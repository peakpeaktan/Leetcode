package EASY;
import java.util.*;
/*
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.



Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n
Each element in nums appears once or twice.


Follow up: Could you do it without extra space and in O(n) runtime?
 */

//very similar to 448. Find All Numbers Disappeared in an Array
public class $442_Find_All_Duplicates_in_an_Array {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
            }else{
                result.add(Math.abs(nums[i]));
            }
        }
        return result;
    }

    public static void main(String[] args){
        findDuplicates(new int[]{4,3,2,7,8,2,3,1});
    }
}
