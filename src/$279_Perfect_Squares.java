/*

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */

import java.util.Arrays;

public class $279_Perfect_Squares {

    public static int numSquares(int n) {

        int[] res = new int[n + 1];

        Arrays.fill(res, Integer.MAX_VALUE);

        res[0] = 0;

        for(int i = 0; i <= n; i++) {
//            System.out.print(i+"  ");
            for(int j = 1; j * j <= i; j++) {
                res[i] = Math.min(res[i], res[i - j * j]+1);
            }
//            System.out.print(res[i]+"\n");
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
