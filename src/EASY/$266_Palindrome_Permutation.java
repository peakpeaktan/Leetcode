package EASY;
import java.util.*;
/*
Given a string, determine if a permutation of the string could form a palindrome.

For example, "code" -> False, "aab" -> True, "carerac" -> True.

Hint:

Consider the palindromes of odd vs even length. What difference do you notice? Count the frequency of each character. If each character occurs even number of times, then it must be a palindrome. How about character which occurs odd number of times?
 */

//label_hashmap
//label_string
public class $266_Palindrome_Permutation {
    public boolean canPermutePalindrome(String s) {
        HashSet<Character> app = new HashSet<Character>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if (app.contains(c)) {
                app.remove(c);
            }
            else {
                app.add(c);
            }
        }
        return app.size() <=1;
    }

    //https://leetcode.ca/2016-08-22-266-Palindrome-Permutation/
    public boolean canPermutePalindrome2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, 1 + map.getOrDefault(c, 0));
        }

        int count = 0;
        for (int each: map.values()) {
            if (each % 2 == 1) {//or   each % 2 != 0
                count++;
            }
        }

        return count < 2;
    }
}
