/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).

n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
 */

//Good explanation: https://www.youtube.com/watch?v=pdKz9TvIjS8
public class $11_CONTAINER_WITH_MOST_WATER {

    public int maxArea(int[] height) {

        if(height == null || height.length <= 1) return 0;

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right){
            int currHeight = Math.min(height[left],height[right]);
            int currMax = currHeight * (right - left);
            maxArea = Math.max(maxArea, currMax);

            if(height[left] < height[right]){

                left++;
            }else if(height[left] > height[right]){
                right--;
            }else{
                left++;
                right--;
            }
        }

        return maxArea;
    }
}
