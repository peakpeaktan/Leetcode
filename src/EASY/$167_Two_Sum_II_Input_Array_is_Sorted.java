package EASY;
/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */

//label_binary_search
public class $167_Two_Sum_II_Input_Array_is_Sorted {

    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];

        if(numbers.length < 2) return result;
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end){
            if(numbers[start] + numbers[end] == target){
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }else if (numbers[start] + numbers[end] < target){

                start++;
            }else{

                end--;
            }
        }

        return result;
    }
}
