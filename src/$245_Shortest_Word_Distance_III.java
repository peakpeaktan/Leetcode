import java.util.*;
/*
Given an array of strings wordsDict and two strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.

Note that word1 and word2 may be the same. It is guaranteed that they represent two individual words in the list.


Example 1:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1
Example 2:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "makes"
Output: 3


Constraints:

1 <= wordsDict.length <= 105
1 <= wordsDict[i].length <= 10
wordsDict[i] consists of lowercase English letters.
word1 and word2 are in wordsDict.
 */

//label_array
public class $245_Shortest_Word_Distance_III {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            if(!map.containsKey(words[i])){
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
        int minDiff = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        for(int l1 : list1){
            for(int l2 : list2){
                if(l1 == l2){   //handle the case : word1 and word2 are the same!
                    continue;
                }
                minDiff = Math.min(minDiff, Math.abs(l1 - l2));
            }
        }
        return minDiff;
    }

    public int shortestWordDistance2(String[] words, String word1, String word2) {
        if(words==null||words.length==0)
            return -1;

        if(word1==null || word2==null)
            return -1;

        boolean isSame = false;

        if(word1.equals(word2))
            isSame = true;

        int shortest= Integer.MAX_VALUE;

        int prev=-1;
        int i1=-1;
        int i2=-1;

        for(int i=0; i<words.length; i++){
            if(isSame){
                if(words[i].equals(word1)){
                    if(prev!=-1){
                        shortest=Math.min(shortest, i-prev);
                    }
                    prev = i;
                }
            }else{
                if(word1.equals(words[i])){
                    i1=i;
                    if(i2!=-1){
                        shortest = Math.min(shortest, i-i2);
                    }
                }else if(word2.equals(words[i])){
                    i2=i;
                    if(i1!=-1){
                        shortest = Math.min(shortest, i-i1);
                    }
                }
            }
        }

        return shortest;
    }
}
