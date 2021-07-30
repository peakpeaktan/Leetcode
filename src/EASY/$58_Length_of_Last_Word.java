package EASY;
/*
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
 */

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
