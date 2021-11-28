package EASY;

import java.util.Stack;

/*
Design a max stack that supports push, pop, top, peekMax and popMax.

push(x) -- Push element x onto stack.
pop() -- Remove the element on top of the stack and return it.
top() -- Get the element on the top.
peekMax() -- Retrieve the maximum element in the stack.
popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.

Example 1:

MaxStack stack = new MaxStack();
stack.push(5);
stack.push(1);
stack.push(5);
stack.top(); -> 5
stack.popMax(); -> 5
stack.top(); -> 1
stack.peekMax(); -> 5
stack.pop(); -> 1
stack.top(); -> 5
 */

//label_stack
public class $716_Max_Stack {
    //https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/716-max-stack.html
    //https://www.youtube.com/watch?v=fXiLhwtwv_Q&ab_channel=AndroidBabies%E5%AE%89%E5%8D%93%E5%A4%A7%E5%AE%9D%E8%B4%9D%E4%BB%AC
    class MaxStack{
        Stack<Integer> stack = null;
        Stack<Integer> maxStack = null;
        int max = Integer.MIN_VALUE;

        public MaxStack(){
            stack = new Stack<>();
            maxStack = new Stack<>();
        }

        public void push(int x) {
            if(maxStack.empty()){
                maxStack.push(x);
            }else{
                if(x > maxStack.peek()){
                    maxStack.push(x);
                }else{
                    maxStack.push(maxStack.peek());
                }
            }
            stack.push(x);
        }

        public int pop() {
            maxStack.pop();
            return stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return maxStack.peek();
        }

        public int popMax() {
            Integer max = maxStack.peek();
            Stack<Integer> temp = new Stack<>();
            while (stack.peek() != max){
                Integer i = stack.pop();
                temp.push(i);
                maxStack.pop();
            }
            stack.pop();
            maxStack.pop();
            while (!temp.empty()){
                push(temp.pop());//after removing max, re-push/reorganize all the elements in the temp
            }
            return max;
        }
    }
}
