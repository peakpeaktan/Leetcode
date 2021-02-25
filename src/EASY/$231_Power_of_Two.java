package EASY;
/*
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Example 2:

Input: 16
Output: true
Example 3:

Input: 218
Output: false
 */

public class $231_Power_of_Two {
    //https://leetcode.com/problems/power-of-two/discuss/63966/4-different-ways-to-solve-Iterative-Recursive-Bit-operation-Math
    public boolean isPowerOfTwo(int n) {

        if(n==0) return false;
        while(n%2==0) n/=2;
        return (n==1);
    }

    public boolean isPowerOfTwo2(int n) {

        return n>0 && (1073741824 % n == 0);
    }
}
