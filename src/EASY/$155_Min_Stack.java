package EASY;
import java.util.*;
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

Implement the MinStack class:

MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.


Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2


Constraints:

-231 <= val <= 231 - 1
Methods pop, top and getMin operations will always be called on non-empty stacks.
At most 3 * 104 calls will be made to push, pop, top, and getMin.

 */

//similar: 716. Max Stack
//label_stack
public class $155_Min_Stack {
    //https://www.youtube.com/watch?v=8UegNFCUQks&ab_channel=TECHDOSE
    //two stack approach, use one stack for recording the min
    class MinStack1 {
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = null;
        Stack<Integer> minStack = null;

        public MinStack1() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int val) {
            stack.push(val);
            if(minStack.isEmpty()){
                minStack.push(val);
            }else{
                if(val < minStack.peek()){
                    minStack.push(val);
                }else{
                    minStack.push(minStack.peek());
                }
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

    //one stack approach, not as intuitive as two stack approach
    //https://www.youtube.com/watch?v=oE8zkEBNxN8&ab_channel=XinghaoHuang
    class MinStack2 {
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = null;

        public MinStack2() {
            stack = new Stack<>();
        }

        public void push(int val) {
            if(val <= min){//if element is smaller than or equal to min, also push the current min onto the stack and update the min value
                stack.push(min);
                min = val;
            }
            stack.push(val);
        }

        public void pop() {
            Integer i = stack.pop();
            if(i == min){
                min = stack.pop();//make sure min is updated
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }

    }

    public static void main(String[] args){

    }
}
