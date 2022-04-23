/*
Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.


Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */

//label_array
//label_dp
public class $152_Maximum_Product_Subarray {

    public static int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int maxToCurrent = nums[0];
        int minToCurrent = nums[0];
        int product = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = maxToCurrent;//store maxToCurrent to a temp
            maxToCurrent = Math.max(Math.max(nums[i] * minToCurrent, nums[i] * maxToCurrent), nums[i]);
            minToCurrent = Math.min(Math.min(nums[i] * temp, nums[i] * minToCurrent), nums[i]);
            if(maxToCurrent > product){
                product = maxToCurrent;
            }
        }

        return product;
    }

    public static void main(String [] args){

        int[] array = {-1,2,-3,2,1};

        System.out.println(maxProduct(array));
    }
}
