/*
Given an array of integers nums sorted in ascending order,

find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
 */

//https://www.youtube.com/watch?v=NlLP8Op_4zw
public class $34_Search_for_a_Range {

    //two binary searches
    public int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        int[] array = new int[2];
        array[0] = first;
        array[1] = last;
        return array;
    }

    public int findFirst(int[] nums, int target) {

        int result = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = (end - start) / 2 + start;

            if(nums[mid] >= target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
            if(nums[mid] == target) result = mid;
        }
        return result;
    }

    public int findLast(int[] nums, int target) {

        int result = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end){
            int mid = (end - start) / 2 + start;

            if(nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
            if(nums[mid] == target) result = mid;
        }
        return result;
    }
}
