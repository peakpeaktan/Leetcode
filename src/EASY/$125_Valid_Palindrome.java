package EASY;
/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
 */

//label_palindrome
//label_twopointers
//label_string
public class $125_Valid_Palindrome {
    //solution 1, use built in method to check if a char is alphanumeric
    //https://leetcode.com/problems/valid-palindrome/discuss/40029/Accepted-pretty-Java-solution(271ms)
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;

        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }

    //https://leetcode.com/problems/valid-palindrome/discuss/39993/3ms-java-solution(beat-100-of-java-solution)
    //solution 2, do not use built in method, build the alphanumeric char array myself
    public static boolean isPalindrome2(String s) {
        char[] charMap = new char[256];
        for (int i = 0; i < 10; i++)
            charMap['0'+i] = (char) (1+i);  // numeric - don't use 0 as it's reserved for illegal chars
        for (int i = 0; i < 26; i++)
            charMap['a'+i] = charMap['A'+i] = (char) (11+i);  //alphabetic, ignore cases, continue from 11

        for (int start = 0, end = s.length()-1; start < end;) {
            if (charMap[s.charAt(start)] == 0)
                start++;
            else if (charMap[s.charAt(end)] == 0)
                end--;
            else if (charMap[s.charAt(start++)] != charMap[s.charAt(end--)])
                return false;
        }
        return true;
    }

    public static void main(String [] args){
        isPalindrome("a? bcdd !cb# a");
    }
}
