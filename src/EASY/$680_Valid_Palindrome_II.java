package EASY;
/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
Note:
The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class $680_Valid_Palindrome_II {

    public boolean validPalindrome(String s) {

        int start = 0;
        int end = s.length() - 1;

        while (start <= end && s.charAt(start) == s.charAt(end)){// start <= end but it can also be start < end
            start++;
            end--;
        }

        if(start > end) return true;// start > end but it can also be start >= end

        if (isPalindrome(s, start+1, end) || isPalindrome(s, start, end+1)) return true;

        return false;
    }

    public boolean isPalindrome(String s, int i, int j) {

        while (i <= j && s.charAt(i) == s.charAt(j)){
            i++;
            j--;
        }

        if(i > j) return true;
        else return false;
    }
}
