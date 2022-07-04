import java.util.*;
/*

Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
 */

//label_dp
public class $139_Word_Break {
    //solution 1: DP
    public static boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        dp[0] = true;

        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                String str = s.substring(j, i);
                if(dp[j] && set.contains(str)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //solution 2: DP v2
    public static boolean wordBreak2(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];
        Set<String> set = new HashSet<>();
        set.addAll(wordDict);

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                String str = s.substring(j, i);
                dp[i] = dp[j] && set.contains(str);
                if(dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //solution 3: DFS + Memoization
    public static boolean wordBreak3(String s, List<String> dict) {
        Set<Integer> set = new HashSet<Integer>();
        return dfs(s, 0, dict, set);
    }

    private static boolean dfs(String s, int index, List<String> dict, Set<Integer> set){
        // base case
        if(index == s.length()) return true;
        // check memory
        if(set.contains(index)) return false;
        // recursion
        for(int i = index+1;i <= s.length();i++){
            String t = s.substring(index, i);
            if(dict.contains(t))
                if(dfs(s, i, dict, set))
                    return true;
                else
                    set.add(i);
        }
        set.add(index);
        return false;
    }

    //solution 4: DFS + Memoization v2
    // Time Complexity: O(n^2) quadratic time
    // Space Complexity: O(n) linear space
    //https://leetcode.com/problems/word-break/discuss/597051/Java-DP-and-BFS-Solutions-Clean-Code
    public static boolean wordBreak4(String s, List<String> wordDict) {
        return bckTrck(s, new HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    public static boolean bckTrck(String s, Set<String> dict, int idx, Boolean[] memo) {
        if (idx == s.length()) return true;

        if (memo[idx] != null) {
            return memo[idx];
        }

        for (int end = idx + 1; end <= s.length(); end++) {
            String str = s.substring(idx, end);
            if (dict.contains(str) && bckTrck(s, dict, end, memo)){
                memo[idx] = true;
                return true;
            }
        }

        memo[idx] = false;
        return false;
    }

    //solution 5
    //https://leetcode.com/problems/word-break/discuss/43819/DFS-with-Path-Memorizing-Java-Solution/144071
    static Set visited = new HashSet();
    public static boolean wordBreak5(String s, List<String> wordDict) {
        if(visited.contains(s)) return false;
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                int len = word.length();
                if (s.length() == len)
                    return true;
                else {
                    if (wordBreak4(s.substring(len), wordDict))
                        return true;
                }
            }
        }
        visited.add(s);
        return false;
    }

    public static void main(String [] args){
        List<String> wordDict = new ArrayList<>();
        wordDict.add("go");
        wordDict.add("goal");
        wordDict.add("goals");
        wordDict.add("special");

        List<String> wordDict2 = new ArrayList<>();
        wordDict2.add("cat");
        wordDict2.add("cats");
        wordDict2.add("and");
        wordDict2.add("dog");
        wordDict2.add("dogs");

        List<String> wordDict3 = new ArrayList<>();
        wordDict3.add("a");
        wordDict3.add("aa");
        wordDict3.add("aaa");

        //System.out.println(wordBreak5("goalspecial", wordDict));
        //System.out.println(wordBreak5("catsanddogs", wordDict2));
        //System.out.println(wordBreak6("aaaab", wordDict3));
    }

}
