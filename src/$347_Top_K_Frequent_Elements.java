import java.util.*;
/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.


Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.


Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */

//label_priority_queue
//label_bucket_sort
public class $347_Top_K_Frequent_Elements {
    //bucket sort
    //https://www.youtube.com/watch?v=YPTqKIgVk-k
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

    //priority queue
    public int[] topKFrequent2(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
                (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
            heap.add(n);
            if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    public static void main(String [] args){
        int[] array = {1,1,1,2,2,3};
        System.out.println(topKFrequent(array, 2));
    }
}


