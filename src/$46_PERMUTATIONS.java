/*

Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */

import java.util.*;

public class $46_PERMUTATIONS {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){

        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{

            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }

    }

    /*
    backtrack({},{},{1,2,3})
        i = 0
            tempList.add(nums[0]) -> templist = {1}
            backtrack( {}, {1}, {1,2,3})
                i = 0
                    continue
                i = 1
                    tempList.add(nums[1]) -> templist = {1,2}
                    backtrack( {}, {1,2}, {1,2,3} )
                        i = 0
                            continue
                        i = 1
                            continue
                        i = 2
                            tempList.add(nums[2]) -> templist = {1,2,3}
                            backtrack( {}, {1,2,3}, {1,2,3} )
                                tempList.size() == nums.length
                                list.add({1,2,3}) -> list = { {1,2,3} }
                            tempList.remove(2) -> templist = {1,2}
                    tempList.remove(1) -> templist = {1}
                i = 2
                    tempList.add(nums[2]) -> templist = {1,3}
                    backtrack( { {1,2,3} }, {1,3}, {1,2,3} )
                        i = 0
                            continue
                        i = 1
                            tempList.add(nums[1]) -> templist = {1,3,2}
                            backtrack( {{1,2,3}}, {1,3,2}, {1,2,3} )
                                tempList.size() == nums.length
                                list.add({1,3,2}) -> list = { {1,2,3}, {1,3,2} }
                            tempList.remove(2) -> templist = {1,3}
                        i = 2
                            continue
                    tempList.remove(1) -> templist = {1}
            tempList.remove(0) -> templist = {}
        i = 1
            tempList.add(nums[1]) -> templist = {2}
            ...
     */

    public static void main(String [] args){

        int[] array = {1,2,3};

        System.out.println(permute(array));

    }
}
