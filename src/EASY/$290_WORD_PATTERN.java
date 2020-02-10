package EASY;

/*

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */

import java.util.*;

public class $290_WORD_PATTERN {

    public boolean wordPattern(String pattern, String str) {

        if(pattern.isEmpty() || str.isEmpty()) return false;

        String[] array = str.split(" ");

        if(array.length != pattern.length()) return false;//if different length return false

        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {

            Character c = pattern.charAt(i);

            if(map.containsKey(c)){

                if(!map.get(c).equals(array[i])) return false;//if the same key refers to different values

            }else{

                if(map.containsValue(array[i])) return false;//if different keys refer to the same value

                map.put(c, array[i]);
            }
        }

        return true;
    }
}
