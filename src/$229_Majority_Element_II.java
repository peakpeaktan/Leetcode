import java.util.*;
/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Follow-up: Could you solve the problem in linear time and in O(1) space?



Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]


Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 */

/**
 * follow up of {@link EASY.$169_Majority_Element}
 */
public class $229_Majority_Element_II {
    //https://www.youtube.com/watch?v=lGYHf_yMq7w
    //https://leetcode.com/problems/majority-element-ii/discuss/63500/JAVA-Easy-Version-To-Understand!!!!!!!!!!!!
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if(nums.length == 0 || nums == null){
            return result;
        }
        int candidate1 = 0;
        int count1 = 0;
        int candidate2 = 0;
        int count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2){
                count2++;
            }else if(count1 == 0){
                candidate1 = nums[i];
                count1++;
            }else if(count2 == 0){
                candidate2 = nums[i];
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (Integer each : nums){
            if(each == candidate1){
                count1++;
            }else if(each == candidate2){
                count2++;
            }
        }
        if(count1 > nums.length/3){
            result.add(candidate1);
        }
        if(count2 > nums.length/3){
            result.add(candidate2);
        }
        return result;
    }
}
