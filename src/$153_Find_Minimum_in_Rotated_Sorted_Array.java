/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.
 */

//label_binarysearch
public class $153_Find_Minimum_in_Rotated_Sorted_Array {
    //https://www.youtube.com/watch?v=IQyJX5ddEx0
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[0] <nums[nums.length - 1]) return nums[0];//fully ascending, return first(minimum) element
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) return nums[mid+1];
            else if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return 0;
    }

    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            } else {//else if (nums[mid] > nums[right])
                left = mid + 1;
            }
        }
        return nums[left];
    }

    public int findMin3(int[] nums) {
        if(nums == null || nums.length ==0) return -1;
        int left = 0;
        int right = nums.length-1;
        while(left+1 < right){
            int mid = left + (right-left)/2;
            if(nums[mid] > nums[right]){
                left = mid;
            }else{
                right = mid;
            }
        }
        return nums[left]>nums[right]?nums[right]:nums[left];
    }

    public int findMin4(int[] nums) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            if (nums[begin] < nums[end]) return nums[begin];//pivot point
            int mid = (begin + end) / 2;
            if (nums[mid] >= nums[begin]) begin = mid + 1;
            else if (nums[mid] < nums[end]) end = mid;
        }
        return nums[begin];
    }
}
