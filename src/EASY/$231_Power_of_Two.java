package EASY;
/*
Given an integer n, return true if it is a power of two. Otherwise, return false.

An integer n is a power of two, if there exists an integer x such that n == 2x.


Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false


Constraints:

-231 <= n <= 231 - 1

Follow up: Could you solve it without loops/recursion?
 */

//label_bit_manipulation
public class $231_Power_of_Two {
    //iterative solution
    public boolean isPowerOfTwo(int n) {
        if(n==0) return false;
        while(n%2==0) n/=2;
        return (n==1);
    }

    //bitwise solution - refer to leetcode solution for intuition & details
    public boolean isPowerOfTwo2(int n) {
        if (n <= 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }

    //bitwise solution - refer to leetcode solution for intuition & details
    public boolean isPowerOfTwo3(int n) {
        if (n <= 0) return false;
        long x = (long) n;
        return (x & (x - 1)) == 0;
    }
}
