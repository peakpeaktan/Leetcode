package EASY;
/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45
 */

//label_dp
public class $70_Climbing_Stairs {
    //O(n) memory space
    public static int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2){return n;}
        int[] mem = new int[n+1];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 2;
        for(int i = 3; i <= n; i++){
            mem[i] = mem[i-1] + mem[i-2];
        }
        return mem[n];
    }

    //O(1) memory solution
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    public static void main(String [] args){
        System.out.println(climbStairs(5));
    }
}
