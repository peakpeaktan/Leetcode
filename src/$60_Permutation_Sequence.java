/*
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
 */
import java.util.*;

public class $60_Permutation_Sequence {
    //https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
    public static String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();
        // create an array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;// factorial[] = {1, 1, 2, 6, 24, ... n!}
        }
        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);// numbers = {1, 2, 3, 4}
        }
        k--;
        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[n-i];
        }

        return String.valueOf(sb);
    }

    public static void main(String [] args){
        /*
        when n=4 k=15,

        1234
        1243
        1324
        1342
        1423
        1432

        2134
        2143
        2314
        2341
        2413
        2431

        3124
        3142
        3214
        3241
        3412 <-
        3421

        4123
        4132
        4213
        4231
        4312
        4321
         */
        System.out.println(getPermutation(4,17));
    }
}
