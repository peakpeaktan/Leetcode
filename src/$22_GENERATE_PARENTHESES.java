/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 */

//very good explanation:
//https://www.youtube.com/watch?v=PCb1Ca_j6OU

import java.util.*;
public class $22_GENERATE_PARENTHESES {
        //https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
        public static List<String> generateParenthesisBackTrack ( int n){
            List<String> list = new ArrayList<String>();
            backtrack(list, "", 0, 0, n);
            return list;
        }

        public static void backtrack(List<String> list, String currentStr,int open, int close, int n){

            if (currentStr.length() == n * 2) {
                list.add(currentStr);
                return;
            }
            if (open < n)
                backtrack(list, currentStr + "(", open + 1, close, n);

            if (close < open)
                backtrack(list, currentStr + ")", open, close + 1, n);
        }


    public static void main(String [] args){
        System.out.println(generateParenthesisBackTrack(3));
    }
}
