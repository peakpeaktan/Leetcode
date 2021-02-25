package EASY;

/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

Example
Example 1:

Input：["practice", "makes", "perfect", "coding", "makes"],"coding","practice"
Output：3
Explanation：index("coding") - index("practice") = 3
Example 2:

Input：["practice", "makes", "perfect", "coding", "makes"],"makes","coding"
Output：1
Explanation：index("makes") - index("coding") = 1
 */

//follow up: 244, 245
public class $243_Shortest_Word_Distance {
    //https://www.youtube.com/watch?v=HmBjC413Vug
    public static int shortestWordDistance(String[] words, String word1, String word2){
        int distance = Integer.MAX_VALUE;
        int word1Index = 0;
        int word2Index = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[i].equals(word1)){
                word1Index = i;
            }else if (words[i].equals(word2)) {
                word2Index = i;
            }
            if(Math.abs(word1Index - word2Index) != 0 && Math.abs(word1Index - word2Index) < distance){
                distance = Math.abs(word1Index - word2Index);
            }
        }
        return distance;
    }

    public static void main(String[] args){
        String[] words = {"practice", "makes", "practice", "coding", "makes", "makes", "coding"};
        String[] words2 = {"practice", "makes", "hello"};
        shortestWordDistance(words2, "hello", "practice");
    }
}
