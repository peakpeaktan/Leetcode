/*
Given an input string , reverse the string word by word.

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note:

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.

Follow up: Could you do it in-place without allocating extra space?
 */

//label_string
public class $186_Reverse_Words_In_a_String_II {
    //https://www.youtube.com/watch?v=voWDMaKc-Lo
    public void reverseWords(char[] str) {
        if(str == null || str.length <= 1) return;
        int start = 0;
        for (int i = 0; i <= str.length; ++i) {
            if (i == str.length || str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
        reverse(str, 0, str.length - 1);
    }

    public void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
