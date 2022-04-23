package HARD;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */

//label_array
//label_dp
public class $42_Trapping_Rain_Water {
    //dp solution
    //https://leetcode.com/problems/trapping-rain-water/discuss/409175/Java-Detailed-Explanations-and-Illustrations-(divide-and-conquer-DP-two-pointers)
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;
        // pre-compute
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0]; // init
        rightMax[n - 1] = height[n - 1];
        for (int i = 1, j = n - 2; i < n; ++i, --j) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            rightMax[j] = Math.max(rightMax[j + 1], height[j]);
        }
        // water
        int totalWater = 0;
        for (int k = 1; k < n - 1; ++k) { // do not consider the first and the last places
            int water = Math.min(leftMax[k - 1], rightMax[k + 1]) - height[k];
            totalWater += (water > 0) ? water : 0;
        }
        return totalWater;
    }
}
