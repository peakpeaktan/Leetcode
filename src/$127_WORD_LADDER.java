import java.util.*;
public class $127_WORD_LADDER {

    public static int ladderLength(String beginWord, String endWord, Set<String> wordList) {

        wordList.add(endWord);
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.remove();
                if(cur.equals(endWord)){ return level + 1;}
                for(int j = 0; j < cur.length(); j++){
                    char[] word = cur.toCharArray();
                    for(char ch = 'a'; ch < 'z'; ch++){
                        word[j] = ch;
                        String check = new String(word);
                        if(!check.equals(cur) && wordList.contains(check)){
                            queue.add(check);
//                            System.out.println(queue);
                            wordList.remove(check);
                        }
                    }
                }
            }
            level++;
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
        ladderLength("hit","cog", wordList);
    }
}
