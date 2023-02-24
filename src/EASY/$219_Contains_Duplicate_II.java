package EASY;
import java.util.*;
/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */

//similar: 217. Contains Duplicate, 220. Contains Duplicate III
//label_hashset
//label_sliding_window
public class $219_Contains_Duplicate_II {
    //sliding window + hashset
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) {
                set.remove(nums[i-k-1]);
            }
            if(!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }

    //hashmap
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer lastIndex = indices.put(nums[i], i);
            if (lastIndex != null && (i - lastIndex) <= k)
                return true;
        }
        return false;
    }

    public static void main(String[] args){
        containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2);
    }
}
