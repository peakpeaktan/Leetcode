/*
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Note:

Both dividend and divisor will be 32-bit signed integers.
The divisor will never be 0.
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */

//label_math
public class $29_Divide_Two_Integers {

    public static int divide(int dividend, int divisor) {

        int sign = 1;
        if( (dividend < 0 && divisor >  0) || (dividend > 0 && divisor < 0)){
            sign = -1;
        }

        if(dividend == 0){
            return 0;
        }

        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);

        long res = helper(absDividend,absDivisor);

        int ans;

        if (res > Integer.MAX_VALUE){

            ans = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {

            ans = (sign == 1) ? (int) (res) : (int) (-res) ;
        }
        return ans;
    }

    public static long helper(long ldividend, long ldivisor) {

        if(ldividend < ldivisor) return 0;

        long sum = ldivisor;
        int multiple = 1;

        while ((sum + sum) < ldividend){

            sum += sum;
            multiple += multiple;
        }

        return multiple + helper(ldividend - sum, ldivisor);
    }

    public static void main(String [] args){

        System.out.println(divide(-100,3));
    }
}
