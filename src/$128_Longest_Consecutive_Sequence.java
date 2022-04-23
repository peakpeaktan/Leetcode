import java.util.*;
/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */

//label_array
public class $128_Longest_Consecutive_Sequence {
    //https://leetcode.com/problems/longest-consecutive-sequence/discuss/41130/Another-accepted-Java-O(n)-solution
    //https://www.youtube.com/watch?v=P6RZZMu_maU&ab_channel=NeetCode
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int each : nums){
            set.add(each);
        }
        int count = 0;
        for(int each : nums){
            int newCount = 1;
            int num = each;
            while(set.contains(--num)){
                newCount++;
                set.remove(num);
            }
            num = each;
            while(set.contains(++each)){
                newCount++;
                set.remove(num);
            }
            set.remove(each);
            count = Math.max(count, newCount);
        }
        return count;
    }

    public static void main(String [] args){
        int[] array = {4, 3, 1, 2};
        longestConsecutive(array);
    }
}
