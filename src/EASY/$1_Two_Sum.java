package EASY;
import java.util.*;
/*

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

//label_hashmap
public class $1_Two_Sum {

    public static int[] twoSum(int[] numbers, int target) {
        //key: number , value: index in array
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int[] array = new int[2];

        for (int i = 0; i < numbers.length ; i++) {

            if(hashMap.containsKey(target - numbers[i])){

                array[1] = i;
                array[0] = hashMap.get(target - numbers[i]);

                return array;

            }else{

                hashMap.put(numbers[i], i);
            }
        }
        return array;
    }

    public static void main(String [] args){

        int[] arr = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    /*
    The important thing here is that we can assume each input has exactly ONE solution,
    and we cannot use the same element twice.
     */
}
