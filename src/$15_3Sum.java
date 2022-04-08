import java.util.Arrays;
import java.util.*;
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.


Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []


Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
*/
//https://www.youtube.com/watch?v=gq-uWp327m8

public class $15_3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> myList = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 ; i++) {//up to the third element from the right/last

            int target = 0 - nums[i];
            if(i > 0 && nums[i] == nums[i-1]){
                continue;//skip if there is duplicate number
            }
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right){

                if(nums[left] + nums[right] == target){//triplet sum = 0

                    List<Integer> newList = new LinkedList<>();
                    newList.add(nums[i]);
                    newList.add(nums[left]);
                    newList.add(nums[right]);
                    myList.add(newList);

                    while(left < right && nums[right] == nums[right-1]) right--;
                    while(left < right && nums[left] == nums[left+1]) left++;
                    right--;
                    left++;

                }else if(nums[left] + nums[right] > target){//triplet sum > 0, shift right pointer to the left

                    while(left < right && nums[right] == nums[right-1]) right--;
                    right--;

                }else{//triplet sum < 0, shift left pointer to the right

                    while(left < right && nums[left] == nums[left+1]) left++;
                    left++;
                }
            }
        }

        return myList;
    }

    public static void main(String [] args){

        int[] arr = {-1, 0, 1, 2, -1, -4};
        //after sort {-4, -1, -1, 0, 1, 2}

        int[] arr2 = {-4, 0, 0, 1, 2, 2, 3, 4, 4};

        System.out.println(threeSum(arr2));
    }
}
