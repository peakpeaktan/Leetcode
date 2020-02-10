/*

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class $347_Top_K_Frequent_Elements {

    public static List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> hashMap = new HashMap<>();

        for(int num: nums){
            hashMap.put(num, hashMap.getOrDefault(num, 0)+1);//IMPORTANT: getOrDefault
        }

        //bucket sort array declaration. nums.length+1 because if the array contains all the same elements then
        //the frequency will be its length.
        List<Integer>[] array = new List[nums.length+1];

        for (int key: hashMap.keySet()){//IMPORTANT: keySet

            int frequency = hashMap.get(key);

            if(array[frequency] == null){
                array[frequency] = new ArrayList<>();
            }

            array[frequency].add(key);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = array.length - 1; i > 0 ; i--) {

            if(result.size() < k){

                if(array[i] != null){
                    result.addAll(array[i]);
                }
            }
        }

        return result;
    }

    public static void main(String [] args){

        int[] array = {1,1,1,2,2,3};

        System.out.println(topKFrequent(array, 2));
    }
}


