import java.util.*;
/*
You are given an array of positive integers nums and want to erase a subarray containing unique elements. The score you get by erasing the subarray is equal to the sum of its elements.

Return the maximum score you can get by erasing exactly one subarray.

An array b is called to be a subarray of a if it forms a contiguous subsequence of a, that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).

Example 1:

Input: nums = [4,2,4,5,6]
Output: 17
Explanation: The optimal subarray here is [2,4,5,6].
Example 2:

Input: nums = [5,2,1,2,5,2,1,2,5]
Output: 8
Explanation: The optimal subarray here is [5,2,1] or [1,2,5].

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
 */

//label_hashmap
//label_hashset
//label_twopointers
//similar: 3
public class $1695_Maximum_Erasure_Value {
    //my solution
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int sum = 0;
        int cur = 0;
        int left = 0;
        while(cur < nums.length) {
            if(!map.containsKey(nums[cur])){
                sum += nums[cur];
                map.put(nums[cur], cur);
                cur++;
            }else{
                int temp = map.get(nums[cur]) + 1;
                for(int j = map.get(nums[cur]); j >= left;j--){
                    sum -= nums[j];
                    map.remove(nums[j]);
                }
                left = temp;
            }
            result = Math.max(result, sum);
        }
        return result;
    }

    //https://www.cnblogs.com/cnoodle/p/14249640.html
    //you can also use a hashset here
    /*
    Maintain一個Hashset然後借助Sliding Window的方法，如果當前這個數字沒有在set內，就把這個數字納入subarrray的考量，然後計算總和。
    如果當前這個數字已經出現在set內，則代表nums[left ... right]的範圍內數字並非uniqu，
    因此必需把nums[left]的數值一個一個pop掉（並且left++），直到nums[left...right]沒有duplicate為止
     */
    public int maximumUniqueSubarray2(int[] nums) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int res = 0;
        int len = nums.length;
        HashSet<Integer> set = new HashSet<>();
        while (end < len) {
            if (!set.contains(nums[end])) {
                sum += nums[end];
                set.add(nums[end]);
                end++;
                res = Math.max(res, sum);
            } else {
                sum -= nums[start];
                set.remove(nums[start]);
                start++;
            }
        }
        return res;
    }
}
