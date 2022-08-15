import java.util.*;
/*
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */

//label_hashmap
//label_data_structure_design
//label_two_pointers
public class $244_Shortest_Word_Distance_II {
    //https://www.youtube.com/watch?v=BBJRj3Ku2P8
    public class WordDistance {
        HashMap<String, ArrayList<Integer>> map;
        public WordDistance(String[] words) {
            map = new HashMap<String, ArrayList<Integer>>();
            for(int i=0; i<words.length; i++){
                if(map.containsKey(words[i])){
                    map.get(words[i]).add(i);
                }else{
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    map.put(words[i], list);
                }
            }
        }

        public int shortest(String word1, String word2) {

            ArrayList<Integer> l1 = map.get(word1);
            ArrayList<Integer> l2 = map.get(word2);

            int result = Integer.MAX_VALUE;
            int i=0;
            int j=0;
            while(i<l1.size() && j<l2.size()){
                result = Math.min(result, Math.abs(l1.get(i)-l2.get(j)));
                if(l1.get(i)<l2.get(j)){
                    i++;
                }else{
                    j++;
                }
            }

            return result;
        }
    }
}
