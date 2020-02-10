/*
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
 */

import java.util.Arrays;

public class $387_First_Unique_Character_in_a_String {

    public static int firstUniqueChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        System.out.println(Arrays.toString(freq));
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }

    public static void main(String [] args){

        String first = "leetcode";
        String second = "loveleetcode";

        System.out.println(firstUniqueChar(second));

    }
}


