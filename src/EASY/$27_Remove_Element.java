package EASY;

import java.util.Arrays;
public class $27_Remove_Element {
    //https://leetcode.com/problems/remove-element/discuss/12289/My-solution-for-your-reference./12795
    public static int removeElement(int[] nums, int element) {
        int i = 0;
        int len = nums.length;
        while (i < len) {
            if (nums[i] == element) {
                nums[i] = nums[len - 1];
                len--;
            }
            else
                i++;
        }
        return len;
    }

    public static void main(String [] args){
        int[] arr = {0,1,2,2,3,0,4,2};
        int[] arr2 = {3,2,2,3};

        System.out.println(removeElement(arr, 2));
        System.out.println(removeElement(arr2, 3));
    }
}
