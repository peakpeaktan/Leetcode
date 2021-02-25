import java.util.*;
/*
Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.


Example 1:

Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
Example 3:

Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false


Constraints:

0 <= nums.length <= 2 * 104
-231 <= nums[i] <= 231 - 1
0 <= k <= 104
0 <= t <= 231 - 1
 */
//similar: 217. Contains Duplicate, 219. Contains Duplicate II
public class $220_Contains_Duplicate_III {
    //https://leetcode.com/problems/contains-duplicate-iii/discuss/61655/Java-O(N-lg-K)-solution
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums.length < 2 || k == 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();

        for(int i = 0; i < nums.length; i++){
            Long floor = set.floor((long) nums[i]);
            Long ceiling = set.ceiling((long) nums[i]);
            if ((floor != null && nums[i] - floor <= t ) ||
                    (ceiling != null && ceiling - nums[i] <= t)) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] array = {1,6,10,17,25,4,2};
        int[] array2 = {1,1,2,3};
        containsNearbyAlmostDuplicate(array, 3, 3);
        containsNearbyAlmostDuplicate(array2, 3, 0);
    }
}
