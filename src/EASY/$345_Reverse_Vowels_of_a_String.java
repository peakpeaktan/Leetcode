package EASY;
/*

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
 */

import java.util.HashSet;
import java.util.Set;

public class $345_Reverse_Vowels_of_a_String {

    public String reverseVowels(String s) {

        Set<Character> hashSet = new HashSet<>();
        //Set<Character> vowels = new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));
        hashSet.add('a');
        hashSet.add('e');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('u');
        hashSet.add('A');
        hashSet.add('E');
        hashSet.add('I');
        hashSet.add('O');
        hashSet.add('U');

        char[] list = s.toCharArray();
        int start = 0;
        int end = list.length - 1;

        while (start < end){
            while(start < end && !hashSet.contains(list[start])) start++;
            while(start < end && !hashSet.contains(list[end])) end--;

                Character temp = list[end];
                list[end] = list[start];
                list[start] = temp;
                start++;
                end--;
        }

        return String.valueOf(list);
    }
}
