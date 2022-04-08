/*
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: tis "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: "aabbb" which its length is 5.
 */

import java.util.HashMap;

//label_string
//label_sliding_window
//similar: 340, 904, 3
public class $159_Longest_Substring_with_At_Most_Two_Distinct_Characters {
    //my solution based on https://www.youtube.com/watch?v=2vW_Q8ToSAU&ab_channel=XinghaoHuang
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int result = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
            if(map.size() > 2){//find and remove leftmost character
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

    public static void main (String[] args){
        lengthOfLongestSubstringTwoDistinct("ccaabbb");
    }
}
