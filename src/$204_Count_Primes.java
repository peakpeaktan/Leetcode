/*
Given an integer n, return the number of prime numbers that are strictly less than n.


Example 1:

Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
Example 2:

Input: n = 0
Output: 0
Example 3:

Input: n = 1
Output: 0


Constraints:

0 <= n <= 5 * 106
 */

//label_math
public class $204_Count_Primes {
    //https://leetcode.com/problems/count-primes/discuss/57588/My-simple-Java-solution
    public int countPrimes(int n) {
        if(n <=1 ) return 0;

        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;

        for(int i = 2; i < Math.sqrt(n); i++){
            if(!notPrime[i]){
                for(int j = 2; j*i < n; j++){
                    notPrime[i*j] = true;
                }
            }
        }

        int count = 0;
        for(int i = 2; i< notPrime.length; i++){
            if(!notPrime[i]) count++;
        }
        return count;
    }
}
