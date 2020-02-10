/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
Find all unique triplets in the array which gives the sum of zero.

        Note:

        The solution set must not contain duplicate triplets.

        Example:

        Given array nums = [-1, 0, 1, 2, -1, -4],

        A solution set is:
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]
*/
//https://www.youtube.com/watch?v=gq-uWp327m8
import java.util.Arrays;
import java.util.*;

public class $15_3SUM {

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> myList = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2 ; i++) {//up to the third element from the right/last

            int target = 0 - nums[i];
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
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

        System.out.println(threeSum(arr));
    }
}
