package EASY;
/*
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string.

This is consistent to C's strstr() and Java's indexOf().
 */

public class $28_Implement_strStr {
    //https://leetcode.com/problems/implement-strstr/discuss/12807/Elegant-Java-solution/13117
    public static int strStr(String s, String t) {
        if (t.isEmpty()) return 0; // edge case: "",""=>0  "a",""=>0
        for (int i = 0; i <= s.length() - t.length(); i++) {
            for (int j = 0;
                 j < t.length() && s.charAt(i + j) == t.charAt(j);
                 j++)
                if (j == t.length() - 1) {
                    return i;
                }
        }
        return -1;
    }

    public static void main(String [] args){
        System.out.println(strStr("hello","ll"));
    }
}
