/*
Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper and citations is sorted in an ascending order, return compute the researcher's h-index.

According to the definition of h-index on Wikipedia: A scientist has an index h if h of their n papers have at least h citations each, and the other n − h papers have no more than h citations each.

If there are several possible values for h, the maximum one is taken as the h-index.

You must write an algorithm that runs in logarithmic time.


Example 1:

Input: citations = [0,1,3,5,6]
Output: 3
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had received 0, 1, 3, 5, 6 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
Example 2:

Input: citations = [1,2,100]
Output: 2


Constraints:

n == citations.length
1 <= n <= 105
0 <= citations[i] <= 1000
citations is sorted in ascending order.
 */

//label_binary_search
public class $275_H_Index_II {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;

        // We need to find the rightmost 'index' such that: (citations[index] <= n - index)
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // There's (n - mid) papers with an equal or higher citation count than citations[mid]
            // If (citations[mid] == n - mid) it's the optimal result and can be returned right away
            if (citations[mid] == n - mid)
                return citations[mid];

            // If citations[mid] is less than (n - mid), narrow down on the right half to look for a paper
            // at a future index that meets the h-index criteria. Otherwise, narrow down on the left half
            if (citations[mid] < n - mid)
                left = mid + 1;
            else
                right = mid - 1;
        }

        // We didn't find an exact match, so there's exactly (n - left) papers that have citations
        // greater than or equal to citations[left] and that is our answer
        return n - left;
    }
}
