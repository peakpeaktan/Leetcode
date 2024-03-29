package EASY;
/*

Given a sorted array and a target value, return the index if the target is found.

If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 */

//label_binary_search
//https://www.youtube.com/watch?v=xSs-R1onSpc&t=353s
public class $35_Search_Insert_Position {

    public int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while (low + 1 < high){
            int mid = (high-low) / 2 + low;
            if(nums[mid] > target){
                high = mid;
            }else if(nums[mid] < target){
                low = mid;
            }else{
                return mid;
            }
        }

        if(nums[high] < target) return high+1;
        else if(nums[low] >= target) return low;
        else return high;
    }
}
