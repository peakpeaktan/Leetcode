/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */

//https://www.youtube.com/watch?v=m2Mk9JN5T4A
public class $5_LONGEST_PALINDROMIC_SUBSTRING {

    //DP
    public static String longestPalindrome(String s) {

        if(s == null || s.length() == 0) return s;

        String result = "";
        int maxLength = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        //two pointers, scan from left to right
        for (int j = 0; j < s.length(); j++) {

            for (int i = 0; i <= j; i++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ( j - i <= 2 || dp[i+1][j-1] );//dp[i+1][j-1] will take effect after j-i > 2
                if(dp[i][j]){
                    if(j - i + 1 > maxLength){
                        maxLength = j - i + 1;
                        result = s.substring(i, j +1);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String [] args){

        String example = "babad";

        System.out.println(longestPalindrome(example));
    }
}
