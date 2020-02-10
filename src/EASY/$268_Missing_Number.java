package EASY;/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

        Example 1

        Input: [3,0,1]
        Output: 2
        Example 2

        Input: [9,6,4,2,3,5,7,0,1]
        Output: 8

        Note:
        Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
*/

public class $268_Missing_Number {

    //xor
    public static int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    //math
    public static int missingNumber2(int[] nums) {
        int len = nums.length;
        int sum = (0+len)*(len+1)/2;
        for(int i=0; i<len; i++)
            sum-=nums[i];
        return sum;
    }

    public static void main(String [] args){

        int[] array = {4,2,1,0};

//        System.out.println(missingNumber(array));

        System.out.println(4^0^4^1^2^2^1^3^0);
    }
}
