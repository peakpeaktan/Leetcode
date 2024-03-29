/*
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
 */

//similar: 81. Search in Rotated Sorted Array II, 153. Find Minimum in Rotated Sorted Array, 154. Find Minimum in Rotated Sorted Array II
//label_binary_search
public class $33_Search_in_Rotated_Sorted_Array {
    //https://www.youtube.com/watch?v=lWEIIFFflQY
    //https://www.youtube.com/watch?v=vaGN5Cjlrfk
    public static int search(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo <= hi) {//while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;//mid
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;//mid
                }
            }
        }
        return -1;
        //return A[lo] == target ? lo : -1;
    }

    public static void main(String [] args){
        /*
                9
               8
              7
                        6 <- hi
                       5 <- target
                      4
                     3
                    2
                   1 <- mid
                  0
         */
        int[] arr = {7,8,9,0,1,2,3,4,5,6};
        System.out.println(search(arr, 5));
    }
}
