/*

Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
 */

import java.util.*;
import java.util.Arrays;

public class $49_GROUP_ANAGRAMS {
    //https://leetcode.com/problems/group-anagrams/discuss/19176/Share-my-short-JAVA-solution
    public static List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length ==0) return new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs){

            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sorted = String.valueOf(charArray);

            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<String>());
            }
            map.get(sorted).add(str);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String [] args){

        String[] array = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams(array));
    }


}
