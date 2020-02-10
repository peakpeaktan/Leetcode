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
//https://leetcode.com/problems/generate-parentheses/discuss/10100/Easy-to-understand-Java-backtracking-solution
import java.util.*;
public class $22_GENERATE_PARENTHESES {

        public static List<String> generateParenthesis ( int n){
            List<String> list = new ArrayList<String>();
            backtrack(list, "", 0, 0, n);
            return list;
        }

        public static void backtrack(List<String> list, String str,int open, int close, int n){

            if (str.length() == n * 2) {
                list.add(str);
                return;
            }

            if (open < n)
                backtrack(list, str + "(", open + 1, close, n);

            if (close < open)
                backtrack(list, str + ")", open, close + 1, n);
        }


    public static void main(String [] args){
        System.out.println(generateParenthesis(3));
    }
}
