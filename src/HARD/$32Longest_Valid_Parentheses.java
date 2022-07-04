package HARD;
import java.util.Stack;
/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.


Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.

 */

//label_stack
public class $32Longest_Valid_Parentheses {
    //https://leetcode.com/problems/longest-valid-parentheses/discuss/14167/Simple-JAVA-solution-O(n)-time-one-stack
    //https://www.youtube.com/watch?v=M1Vw5Tk1rw4&ab_channel=basketwangCoding
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<Integer>();
        int max=0;
        int left = -1;
        for(int j=0;j<s.length();j++){
            if(s.charAt(j)=='(') stack.push(j);
            else {
                if (stack.isEmpty()) left=j;
                else{
                    stack.pop();
                    if(stack.isEmpty()) max=Math.max(max,j-left);
                    else max=Math.max(max,j-stack.peek());
                }
            }
        }
        return max;
    }

    //this solution pushes -1 onto the stack first
    //https://www.youtube.com/watch?v=r0-zx5ejdq0

    //this solution calculates the max length at the end
    //https://leetcode.com/problems/longest-valid-parentheses/discuss/14126/My-O(n)-solution-using-a-stack

}
