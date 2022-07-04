package EASY;
import java.util.*;
/*
Given an array of size n, find the majority element.

The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
 */

/**
 * follow up: 229 Majority Element II
 */
//label_array
public class $169_Majority_Element {
    //solution 1: moore voting algorithm, O(1) extra space
    public int majorityElement1(int[] nums) {
        int count=0, ret = 0;
        for (int num: nums) {
            if (count==0)
                ret = num;
            if (num!=ret)
                count--;
            else
                count++;
        }
        return ret;
    }

    //https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
    //solution 2: use hash table, O(n) extra space
    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> myMap = new HashMap<Integer, Integer>();
        int ret=0;
        for (int num: nums) {
            if (!myMap.containsKey(num))
                myMap.put(num, 1);
            else
                myMap.put(num, myMap.get(num)+1);
            if (myMap.get(num)>nums.length/2) {
                ret = num;
                break;
            }
        }
        return ret;
    }

    public static void main(String [] args){

        int[] nums = {2,2,1,1,1,2,2};

        //System.out.println(majorityElement2(nums));
    }
}
