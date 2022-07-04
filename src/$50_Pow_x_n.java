/*

Implement pow(x, n), which calculates x raised to the power n (xn).

Example 1:

Input: 2.00000, 10
Output: 1024.00000
Example 2:

Input: 2.10000, 3
Output: 9.26100
Example 3:

Input: 2.00000, -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25
Note:

-100.0 < x < 100.0
n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */

//label_math
public class $50_Pow_x_n {
    //recursive solution
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if(n < 0) {
            n = -n;
            x = 1/x;
        }

        return (n%2 == 0) ? myPow(x * x, n/2) : x *  myPow(x * x, n/2);
    }

    //iterative solution: https://www.youtube.com/watch?v=yEQq3t3T_J0&t=22s&ab_channel=basketwangCoding
    public double myPow2(double x, int n) {
        if(n == 0 || x == 1) return 1;
        if(n == 1) return x;
        if (n < 0) return 1/(x * myPow2(x, -(n+1)));
        double res = 1;
        while (n > 1){
            if(n % 2 == 1){
                res *= x;
            }
            x = x * x;
            n /= 2;
        }
        res *= x;
        return res;
    }

    public static void main(String [] args){
    }
}
