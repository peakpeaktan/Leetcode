/*
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are considered permutations of arr: [1,2,3], [1,3,2], [3,1,2], [2,3,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.



Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]


Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
 */

public class $31_Next_Permutation {
    //https://www.youtube.com/watch?v=IbcQOdtmvpA&ab_channel=%E5%B1%B1%E6%99%AF%E5%9F%8E%E4%B8%80%E5%A7%90
    //https://leetcode.com/problems/next-permutation/discuss/13872/Easiest-JAVA-Solution
    //awesome diagram for explanation: https://leetcode.com/problems/next-permutation/discuss/13994/Readable-code-without-confusing-ij-and-with-explanation
    public static void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) {
            i--; // Find 1st id i that breaks descending order
        }
        if(i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while(A[j] <= A[i]) {
                j--;           // Find rightmost first larger id j
            }
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }

    //my solution
    public static void nextPermutation2(int[] A) {
        int j = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if(i == 0) {//descending, reverse the whole thing and return
                reverse(A, 0, A.length-1);
                return;
            }
            if(i >= 1 && A[i] > A[i-1]){//solution above is better in looking for element that
                                        // breaks the descending order from right to left.
                j =  i - 1;
                break;
            }
        }
        int n = 0;
        for (int m = A.length - 1; m > j; m--) {
            if(A[m] > A[j]){
                n = m;
                break;
            }
        }
        swap(A, j, n);
        reverse(A, j+1, A.length - 1);
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }

    public static void main(String [] args){

        int[] arr = {1,3,2};//{1, 2, 5, 3, 3, 0};
        nextPermutation(arr);
        System.out.println(arr);
    }
}
