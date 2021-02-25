package EASY;
import java.util.*;
/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */

//similar: 225. Implement Stack using Queues
public class $232_Implement_Queue_Using_Stacks {
    //solution 1: dequeue is costly
    class MyQueue {

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        public void push(int x) {
            s1.push(x);
        }

        public int pop() {
            peek();
            return s2.pop();
        }

        public int peek() {

            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
            }

            return s2.peek();
        }

        public boolean empty() {

            return s1.isEmpty() && s2.isEmpty();
        }
    }

    //https://www.youtube.com/watch?v=xSa0sD-RqMg
    //solution 2: enqueue is costly
    class MyQueue2 {
        Stack<Integer> queue = new Stack<Integer>();

        public void push(int x) {
            Stack<Integer> temp = new Stack<Integer>();
            while (!queue.empty()) {
                temp.push(queue.pop());
            }
            queue.push(x);
            while (!temp.empty()) {
                queue.push(temp.pop());
            }
        }

        public void pop() {
            queue.pop();
        }

        public int peek() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.empty();
        }
    }
}
