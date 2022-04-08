package EASY;
import java.util.*;
/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters.

No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
Note:
You may assume both s and t have the same length.
 */

//label_string
public class $205_Isomorphic_Strings {

    public boolean isIsomorphic(String s, String t) {

        if(s == null || t == null) return false;

        Map<Character, Character> myMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {

            char sChar = s.charAt(i);
            char tChar = s.charAt(i);

            if(myMap.containsKey(sChar)){

                if(!myMap.get(sChar).equals(tChar)) return false;

            }else{

                if(myMap.containsValue(tChar)) return false;

                myMap.put(sChar,tChar);
            }
        }

        return true;
    }

    //https://leetcode.com/problems/isomorphic-strings/discuss/57802/Java-solution-using-HashMap/59449
    public boolean isIsomorphic2(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() != t.length()) return false;

        Map<Character, Integer> mapS = new HashMap<Character, Integer>();
        Map<Character, Integer> mapT = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            int indexS = mapS.getOrDefault(s.charAt(i), -1);
            int indexT = mapT.getOrDefault(t.charAt(i), -1);

            if (indexS != indexT) {
                return false;
            }

            mapS.put(s.charAt(i), i);
            mapT.put(t.charAt(i), i);
        }

        return true;
    }
}
