/*
There is an integer array nums sorted in non-decreasing order (not necessarily with distinct values).

Before being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,4,4,5,6,6,7] might be rotated at pivot index 5 and become [4,5,6,6,7,0,1,2,4,4].

Given the array nums after the rotation and an integer target, return true if target is in nums, or false if it is not in nums.

You must decrease the overall operation steps as much as possible.


Example 1:

Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true
Example 2:

Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
nums is guaranteed to be rotated at some pivot.
-104 <= target <= 104


Follow up: This problem is similar to Search in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?
 */

//similar: 33. Search in Rotated Sorted Array, 153. Find Minimum in Rotated Sorted Array, 154. Find Minimum in Rotated Sorted Array II
//label_binary_search
public class $81_Search_in_Rotated_Sorted_Array_II {
    //https://www.youtube.com/watch?v=eG27FBcmy1k
    //https://leetcode.com/problems/search-in-rotated-sorted-array-ii/discuss/28202/Neat-JAVA-solution-using-binary-search/27196
    public boolean search(int[] nums, int target) {
        int start  = 0, end = nums.length - 1;
        //check each num so we will check start == end
        //We always get a sorted part and a half part
        //we can check sorted part to decide where to go next
        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == target) return true;

            //if left part is sorted
            if(nums[start] < nums[mid]){
                if(target < nums[start] || target > nums[mid]){
                    //target is in rotated part
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }else if(nums[start] > nums[mid]){
                //right part is rotated

                //target is in rotated part
                if(target < nums[mid] || target > nums[end]){
                    end = mid -1;
                }else{
                    start = mid + 1;
                }
            }else{
                //duplicates, we know nums[mid] != target, so nums[start] != target
                //based on current information, we can only move left pointer to skip one cell
                //thus in the worest case, we would have target: 2, and array like 11111111, then
                //the running time would be O(n)
                start ++;
            }
        }

        return false;
    }
}
