package EASY;

/*

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

public class $7_REVERSE_INTEGER {

    public int reverse(int x) {

        long temp = 0;//long because the reversed int can overflow

        while (x != 0){

            temp = temp * 10 + x % 10;
            x = x/10;
        }

        if( temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) return 0;

        return (int) temp;
    }
}
