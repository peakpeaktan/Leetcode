package EASY;

import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */
public class $14_Longest_Common_Prefix {

    public static String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0) return "";

        if(strs.length == 1) return strs[0];//if only one string return itself

        String str = strs[0];

        for (int i = 1; i < strs.length; i++) {//loop from the second string to the end

            while (strs[i].indexOf(str) != 0){//if there is no common prefix, then decrement string by 1 letter from the end
                str = str.substring(0, str.length()-1);
            }
        }

        return str;
    }

    public static void main(String [] args){

        String[] arr = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(arr));
    }
}
