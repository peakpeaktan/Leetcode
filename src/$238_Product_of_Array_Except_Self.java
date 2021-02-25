/*
Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

Note: Please solve it without division and in O(n).

Follow up:
Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */

public class $238_Product_of_Array_Except_Self {
    //https://www.youtube.com/watch?v=rpQhKorJRd8
    public static int[] productExceptSelf(int[] nums) {
        int left = 1;
        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = left;
            left = left * nums[i];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] = output[i] * right;
            right = right * nums[i];
        }

        return output;
    }

    public static void main (String[] args){
        //2, 3, 4, 5
        //1, 0, 0, 0
        productExceptSelf(new int[]{2,3,4,5});
    }
}
