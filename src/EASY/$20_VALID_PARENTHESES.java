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

public class $20_VALID_PARENTHESES {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (Character chr : s.toCharArray()){

            if(chr == '('){
                stack.push(')');
            }else if(chr == '['){
                stack.push(']');
            }else if(chr == '{'){
                stack.push('}');
            }else{//all closing ones
                //if stack is already empty meaning that there is an extra closing one
                if(stack.isEmpty() || stack.pop() != chr) return false;
            }
        }
        return stack.isEmpty();
    }
}
