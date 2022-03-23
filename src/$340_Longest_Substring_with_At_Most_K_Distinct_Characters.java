/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
 */

import java.util.HashMap;

//label_hashmap
//label_string
//label_twopointers
//similar: 159, 904, 3
public class $340_Longest_Substring_with_At_Most_K_Distinct_Characters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
            if(map.size() > k){//find and remove leftmost character
                int leftmost = Integer.MAX_VALUE;
                for(int each : map.values()){
                    leftmost = Math.min(leftmost, each);
                }
                map.remove(s.charAt(leftmost));
                index = leftmost + 1;
            }
            result = Math.max(result, i - index + 1);
        }
        return result;
    }
}
