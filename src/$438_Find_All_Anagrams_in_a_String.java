import java.util.*;
/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".


Constraints:

1 <= s.length, p.length <= 3 * 104
s and p consist of lowercase English letters.
 */
public class $438_Find_All_Anagrams_in_a_String {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || p.length() < s.length()) return list;
        char[] pHash = new char[26];
        char[] sHash = new char[26];
        for (char c : p.toCharArray()) {
            pHash[c - 'a']++;
        }
        int left = 0, right = 0, count = p.length();

        while (right < s.length()) {
            sHash[s.charAt(right) - 'a']++;
            if (String.valueOf(sHash).equals(String.valueOf(pHash))) {
                list.add(left);
            }
            right++;
            if (right - left == p.length() ) {
                sHash[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return list;
    }

    public static void main(String[] args){
        findAnagrams("cbaebabacd", "abc");
    }
}
