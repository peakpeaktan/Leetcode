package HARD;
/*
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.



Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"


Constraints:

1 <= n <= 9
1 <= k <= n!
 */

import java.util.ArrayList;
import java.util.List;

public class $60_Permutation_Sequence {
    //https://leetcode.com/problems/permutation-sequence/discuss/22507/%22Explain-like-I'm-five%22-Java-Solution-in-O(n)
    public static String getPermutation(int n, int k) {
        int[] factorial = new int[n+1];
        List<Integer> nums = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = i * factorial[i-1];
            nums.add(i);
        }
        k--;
        for (int j = n; j >=1; j--) {
            int index = k / factorial[j-1];
            sb.append(nums.get(index));
            nums.remove(index);
            k = k - factorial[j-1] * index;
        }
        return sb.toString();
    }

    public static void main (String[] args){
        getPermutation(4,9);
    }
}
