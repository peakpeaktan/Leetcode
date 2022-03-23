/*
Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.

Example 1:

Input: s1 = "sea", s2 = "eat"
Output: 231
Explanation: Deleting "s" from "sea" adds the ASCII value of "s" (115) to the sum.
Deleting "t" from "eat" adds 116 to the sum.
At the end, both strings are equal, and 115 + 116 = 231 is the minimum sum possible to achieve this.
Example 2:

Input: s1 = "delete", s2 = "leet"
Output: 403
Explanation: Deleting "dee" from "delete" to turn the string into "let",
adds 100[d] + 101[e] + 101[e] to the sum.
Deleting "e" from "leet" adds 101[e] to the sum.
At the end, both strings are equal to "let", and the answer is 100+101+101+101 = 403.
If instead we turned both strings into "lee" or "eet", we would get answers of 433 or 417, which are higher.


Constraints:

1 <= s1.length, s2.length <= 1000
s1 and s2 consist of lowercase English letters.

 */

//label_string
//label_dp
public class $712_Minimum_ASCII_Delete_Sum_for_Two_Strings {
    //https://www.cnblogs.com/grandyang/p/7752002.html
    //my solution
    public int minimumDeleteSum(String s1, String s2) {
        int word1Length = s1.length();
        int word2Length = s2.length();
        int[][] dp = new int[word2Length+1][word1Length+1];
        dp[0][0] = 0;
        for (int i = 1; i <= word1Length; i++) {
            dp[0][i] = dp[0][i-1] + s1.charAt(i-1);
        }
        for (int i = 1; i <= word2Length; i++) {
            dp[i][0] = dp[i-1][0] + s2.charAt(i-1);
        }
        for (int i = 1; i <= word2Length; i++) {
            for (int j = 1; j <= word1Length; j++) {
                if(s1.charAt(j-1) == s2.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j] + s2.charAt(i-1), dp[i][j-1] + s1.charAt(j-1));
                }
            }
        }
        return dp[word2Length][word1Length];
        /*
                 ""  s    e    a
              "" 0   s    se  sea
              e  e   se   s   sa
              a  ea  sea  sa  s
              t  eat seat sat st
         */
    }
}
