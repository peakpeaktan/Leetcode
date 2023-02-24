package EASY;
import java.util.*;
/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

 */

//label_hashmap
public class $242_Valid_Anagram {

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int[] array = new int[26];

        for (int i = 0; i < s.length() ; i++) {
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }

        for (int num : array){
            if(num != 0){
                return false;
            }
        }

        return true;
    }

    //https://leetcode.com/problems/valid-anagram/discuss/66484/Accepted-Java-O(n)-solution-in-5-lines/190829
    //follow up - input containing Unicode characters
    public boolean isAnagram2(String s, String t) {
        HashMap<Character,Integer> smap=new HashMap<>();
        int sl=s.length();
        int tl=t.length();
        if(sl!=tl){return false;}
        for(int i=0;i<sl;i++){
            smap.put(s.charAt(i),smap.getOrDefault(s.charAt(i),0)+1);
            smap.put(t.charAt(i),smap.getOrDefault(t.charAt(i),0)-1);
        }
        for(char c:smap.keySet()){
            if(smap.get(c)!=0){return false;}
        }

        return true;
    }

    public static void main(String [] args){

        String first = "anagram";
        String second = "nagaram";

        System.out.println(isAnagram(first, second));
    }
}
