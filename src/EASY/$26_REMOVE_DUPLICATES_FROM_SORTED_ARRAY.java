package EASY;
/*
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
 */

import java.util.Arrays;

public class $26_REMOVE_DUPLICATES_FROM_SORTED_ARRAY {

    public static int removeDuplicates(int[] nums) {

        if (nums.length == 0 || nums == null) return 0;

        if(nums.length == 1) return nums[0];

        int count = 1;

        for (int i = 1; i < nums.length; i++) {

            if(nums[i] != nums[i-1]){

                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String [] args){

        int[] arr = {0,0,1,1,2,2,3};

        int[] arr2 = {0,0};

        System.out.println(removeDuplicates(arr2));
    }
}
