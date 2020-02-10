package EASY;

import java.util.Arrays;

/*
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:

Input: 16
Returns: True
Example 2:

Input: 14
Returns: False
 */
public class $367_VALID_PERFECT_SQUARE {

    public static boolean isPerfectSquare(int num) {
        //binary search
        int low = 1, high = num;
        while (low <= high) {
            long mid = (high - low)/2 + low;//declare as long to handle overflow
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    public static void main(String [] args){

        System.out.println(isPerfectSquare(16));
    }

    public boolean isPerfectSquare2(int num) {
        //A square number is 1+3+5+7+...
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public boolean isPerfectSquare3(int num) {
        //Newton method
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
}
