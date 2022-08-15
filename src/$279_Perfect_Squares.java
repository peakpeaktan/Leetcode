import java.util.Arrays;
/*
Given an integer n, return the least number of perfect square numbers that sum to n.

A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.


Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.


Constraints:

1 <= n <= 104
 */

//label_dp
//similar: 322. Coin Change
public class $279_Perfect_Squares {
    //https://www.youtube.com/watch?v=HLZLwjzIVGo&ab_channel=NeetCode
    //https://leetcode.com/problems/perfect-squares/discuss/71495/An-easy-understanding-DP-solution-in-Java
    public static int numSquares(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i - j * j]+1);
            }
        }

        return res[n];
    }

    public static void main(String [] args){

        /*
            0  0
            1  1
            2  2
            3  3
            4  1
            5  2
            6  3
            7  4
            8  2
            9  1
            10  2
            11  3
            12  3
            13  2
         */

        System.out.println(numSquares(13));
    }
}
