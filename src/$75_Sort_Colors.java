import java.util.Arrays;
/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.


Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.


Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */

//similar: 283. Move Zeroes
//label_array
public class $75_Sort_Colors {
    //https://www.youtube.com/watch?v=aVOm2Kickys&t=350s&ab_channel=%E5%B1%B1%E6%99%AF%E5%9F%8E%E4%B8%80%E5%A7%90
    public static void sortColors(int[] nums) {
        if(nums == null) return;
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right){
            if(nums[index] == 0){
                nums[index] = nums[left];
                nums[left] = 0;
                index++;
                left++;
            }else if(nums[index] == 2){
                nums[index] = nums[right];
                nums[right] = 2;
                right--;
            }else{
                index++;
            }
        }
    }

    public static void main(String [] args){
        int[] array = {2,0,2,1,1,0};
        int[] array2 = {0,1,1,0,2,2};

        sortColors(array);

        System.out.println(Arrays.toString(array));
    }
}
