package EASY;
/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
 */

import java.util.Stack;

//label_string
public class $20_Valid_Parentheses {
    //https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character chr : s.toCharArray()){
            if(chr == '('){
                stack.push(')');
            }else if(chr == '['){
                stack.push(']');
            }else if(chr == '{'){
                stack.push('}');
            }else{//closing brackets
                //if stack is already empty meaning that there is an extra closing one, for example ()}}
                if(stack.isEmpty() || stack.pop() != chr) return false;
            }
        }
        return stack.isEmpty();
    }

    //another solution, which differs in what we push into the stack:
    //https://www.youtube.com/watch?v=o7lQWD8FiIA
}
