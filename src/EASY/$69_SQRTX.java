package EASY;

/*

Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:

Input: 4
Output: 2
Example 2:

Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since
             the decimal part is truncated, 2 is returned.
 */

public class $69_SQRTX {
    //https://leetcode.com/problems/sqrtx/discuss/25047/A-Binary-Search-Solution/239667
    public static int mySqrt(int x) {
        int low = 1;
        int high = x;
        int ans = 0;
        while (low <= high){
            int mid = low + (high-low)/2;
            // upper bound的形式，因为我们要找的ans要是最接近于x的最大的数，利用upper bound
            if (mid <= x/mid){
                low = mid +1;
                ans = mid;
            }
            else
                high = mid-1;
        }

        return ans;
    }

    public static void main(String [] args){
        System.out.println(mySqrt(8));
        System.out.println(mySqrt(23));
    }
}
