package EASY;
/*
Given a string s consisting of some words separated by some number of spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.


Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.
Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.
Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.


Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.
 */

//label_string
public class $58_Length_of_Last_Word {

    public int lengthOfLastWord(String s) {
        //"hello world "
        //"a"
        int length = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if(s.charAt(i) == ' '){
                if(length != 0) return length;
            }else{
                length++;
            }
        }
        return length;
    }

    public int lengthOfLastWord3(String s) {
        //trim() eliminates leading and trailing spaces of a string
        return s.trim().length() - s.trim().lastIndexOf(" ")-1;
    }

    public int lengthOfLastWord2(String s) {
        String[] words = s.split(" ");
        if (words.length==0) return 0;
        else return words[words.length-1].length();
    }
}
