package EASY;
import java.util.*;
/*
Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.



Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]
Example 2:

Input: nums = [1,1]
Output: [2]


Constraints:

n == nums.length
1 <= n <= 105
1 <= nums[i] <= n


Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */

//very similar to 442. Find All Duplicates in an Array
public class $448_Find_All_Numbers_Disappeared_in_an_Array {
    //https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/92957/2ms-O(n)-In-Space-Java
    //https://www.youtube.com/watch?v=Y5AkrdnUOxs
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -1 * nums[Math.abs(nums[i]) - 1];
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }

    public static void  main(String[] args){
        findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
    }
}
