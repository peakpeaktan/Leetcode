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

public class $50_Pow_x_n {

    public static double myPow(double x, int n) {

        if(n < 0){
            if(n == Integer.MIN_VALUE){
                return 1/(myPow(x, -(n+1)) * x);
            }else{
                return 1/myPow(x, -n);
            }
        }

        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == 2) return x*x;

        if(n%2 == 0){

            return myPow(myPow(x, n/2), 2);

        }else{

            return x* myPow(myPow(x, n/2), 2);
        }

    }

    public static void main(String [] args){

        //System.out.println(myPow(1, Integer.MIN_VALUE));
        System.out.println(myPow(2, 10));
    }
}
