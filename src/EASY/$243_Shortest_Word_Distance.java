package EASY;

/*
Given an array of strings wordsDict and two different strings that already exist in the array word1 and word2, return the shortest distance between these two words in the list.


Example 1:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "coding", word2 = "practice"
Output: 3
Example 2:

Input: wordsDict = ["practice", "makes", "perfect", "coding", "makes"], word1 = "makes", word2 = "coding"
Output: 1


Constraints:

1 <= wordsDict.length <= 3 * 104
1 <= wordsDict[i].length <= 10
wordsDict[i] consists of lowercase English letters.
word1 and word2 are in wordsDict.
word1 != word2
 */

//follow up: 244, 245
//label_array
public class $243_Shortest_Word_Distance {
    //https://www.youtube.com/watch?v=HmBjC413Vug
    public static int shortestWordDistance(String[] words, String word1, String word2){
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                p1 = i;

            if (words[i].equals(word2))
                p2 = i;

            if (p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1 - p2));
        }

        return min;
    }

    public static void main(String[] args){
        String[] words = {"practice", "makes", "practice", "coding", "makes", "makes", "coding"};
        String[] words2 = {"practice", "makes", "hello"};
        shortestWordDistance(words2, "hello", "practice");
    }
}
