import java.util.Stack;
/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, and /. Each operand may be an integer or another expression.

Note that division between two integers should truncate toward zero.

It is guaranteed that the given RPN expression is always valid. That means the expression would always evaluate to a result, and there will not be any division by zero operation.


Example 1:

Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22


Constraints:

1 <= tokens.length <= 104
tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */

//label_stack
public class $150_Evaluate_Reverse_Polish_Notation {
    //https://www.youtube.com/watch?v=6FCyyrrtjp0&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A
    //https://leetcode.com/problems/evaluate-reverse-polish-notation/discuss/47430/Java-Accepted-Code%3A-Stack-implementation.
    public int evalRPN(String[] tokens) {
        int a,b;
        Stack<Integer> S = new Stack<Integer>();
        for (String s : tokens) {
            if(s.equals("+")) {
                S.add(S.pop()+S.pop());
            }
            else if(s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            }
            else if(s.equals("*")) {
                S.add(S.pop() * S.pop());
            }
            else if(s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            }
            else {
                S.add(Integer.parseInt(s));
            }
        }
        return S.pop();
    }

    public static int evalRPN2(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String str : tokens){
            if(str == "+" || str == "-" || str == "*" || str == "/"){
                Integer v1 = st.pop();
                Integer v2 = st.pop();
                if(str == "+"){
                    st.push(v1 + v2);
                }else if(str == "-"){
                    st.push(v2 - v1);
                }else if(str == "*"){
                    st.push(v1 * v2);
                }else{
                    st.push(v2 / v1);
                }
            }else{
                st.push(Integer.valueOf(str));
            }
        }
        return st.pop();
    }

    public static void main(String[] args){
        evalRPN2(new String[]{"2","1","+","3","*"});
    }

}
