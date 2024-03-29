package EASY;

/*
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
 */

//label_math
public class $172_Factorial_Trailing_Zeroes {
    //https://www.youtube.com/watch?v=T3lhjrX2z9k
    public static int trailingZeroes(int n) {
        return n == 0 ? 0 : n/5 + trailingZeroes(n/5);
    }

    public static void main(String [] args){

        System.out.println(trailingZeroes(50));
    }
}
