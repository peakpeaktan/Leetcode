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

//label_string
//label_sliding_window
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

    //https://github.com/YaokaiYang-assaultmaster/LeetCode/blob/master/LeetcodeAlgorithmQuestions/340.%20Longest%20Substring%20with%20At%20Most%20K%20Distinct%20Characters.md
    public int lengthOfLongestSubstringKDistinct2(String s, int k) {
        if (s == null || s.isEmpty() || k == 0) return 0;

        int start = 0;
        int end = 0;
        int ret = 0;
        char[] chs = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        while (end < chs.length) {
            map.put(chs[end], map.getOrDefault(chs[end], 0) + 1);
            while (map.size() > k) {
                int count = map.get(chs[start]) - 1;
                map.put(chs[start], count);
                if (count == 0) map.remove(chs[start]);
                start++;
            }
            ret = Math.max(ret, end - start + 1);
            end++;
        }

        return ret;
    }
}
