package HARD;
/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character


Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')


Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.
 */

//similar: 1143. Longest Common Subsequence, 583. Delete Operation for Two Strings, 712. Minimum ASCII Delete Sum for Two Strings
//label_dp
public class $72_Edit_Distance {
    //https://www.youtube.com/watch?v=MiqoA-yF-0M&ab_channel=BackToBackSWE
    //solution by me
    public int minDistance(String word1, String word2) {
        int word1Length = word1.length();
        int word2Length = word2.length();
        int[][] dp = new int[word2Length+1][word1Length+1];
        dp[0][0] = 0;
        for (int i = 1; i <= word1Length; i++) {
            dp[0][i] = dp[0][i-1] + 1;
        }
        for (int i = 1; i <= word2Length; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }
        for (int i = 1; i <= word2Length; i++) {
            for (int j = 1; j <= word1Length; j++) {
                if(word1.charAt(j-1) == word2.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1];//if equal take upper left
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;//take min of upper left, left and up and plus 1
                }
            }
        }
        return dp[word2Length][word1Length];
    }
}
