import java.util.*;
/*
Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
Example:
Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]
 */

//similar: 228 Summary Ranges
public class $163_Missing_Ranges {
    //https://www.youtube.com/watch?v=qUKn6Y0eryc
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        long lowerLong = (long)lower;//long here to deal with overflow
        long lowerUpper = (long)upper;
        for(int num : nums){
            if(lowerLong < num){//lower always <= num because nums[] is in the range of [lower upper]
                if(lowerLong + 1 == num){
                    result.add(String.valueOf(lowerLong));
                }else{
                    result.add(lowerLong + "->" + (num - 1));
                }
            }
            lowerLong = (long)num + 1;
        }
        if(lowerLong == lowerUpper){//upper always >= num because nums[] is in the range of [lower upper]
            result.add(String.valueOf(lowerLong));
        }else{
            result.add(lowerLong + "->" + lowerUpper);
        }

        return result;
    }
}
