import java.util.*;
/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

//label_bfs
//label_queue
//label_important
public class $127_Word_Ladder {
    //solution 1: BFS, using queue.size to calculate level, no dedicated hashset for making visited works
    //https://www.youtube.com/watch?v=hB_nYXFtwP0
    //https://www.youtube.com/watch?v=ZVJ3asMoZ18&ab_channel=TECHDOSE
    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int q=0; q < size; q++) {
                String tmp = queue.poll();
                for (int i=0; i < tmp.length(); i++) {
                    char[] chars = tmp.toCharArray();

                    for(char c='a'; c<='z'; c++) {
                        chars[i] = c;
                        String tmp2 = new String(chars);

                        if (dict.contains(tmp2)) {
                            if (tmp2.equals(endWord)) {
                                return level+1;
                            }
                            queue.add(tmp2);
                            dict.remove(tmp2);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }

    //solution 2: bidirectional BFS
    //https://leetcode.com/problems/word-ladder/discuss/40711/Two-end-BFS-in-Java-31ms.
    //https://www.youtube.com/watch?v=vWPCm69MSfs&t=1004s
    public static int ladderLength3(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }

    public static void main(String [] args){
        Set<String> wordList = new HashSet<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        //ladderLength("hit","cog", wordList);
        //ladderLength2("hit", "cog", new LinkedList<String>(wordList));
        ladderLength3("hit", "cog", wordList);
    }
}
