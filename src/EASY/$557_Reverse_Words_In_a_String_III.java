package EASY;
/*
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */

//similar: 151. Reverse Words in a String, 186. Reverse Words in a String II
public class $557_Reverse_Words_In_a_String_III {
    public String reverseWords(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        for (int i = 0, j = 0; j <= n; j++) {
            if (j == n || c[j] == ' ') {
                reverse(c, i, j-1);
                i = j+1;
            }
        }
        return new String(c);
    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++; j--;
        }
    }
}
