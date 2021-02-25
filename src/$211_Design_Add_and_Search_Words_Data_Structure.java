/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.


Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


Constraints:

1 <= word.length <= 500
word in addWord consists lower-case English letters.
word in search consist of  '.' or lower-case English letters.
At most 50000 calls will be made to addWord and search.
 */

//similar: 208. Implement Trie (Prefix Tree)
public class $211_Design_Add_and_Search_Words_Data_Structure {
    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("cat");
        dic.search(".at");
    }
}

class WordDictionary {

    private class TrieNode {
        char character;
        boolean isWord = false;
        TrieNode[] children = new TrieNode[26];
        public TrieNode(char character) {
            this.character = character;
        }
    }

    TrieNode root = null;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if(word == null || word.length() == 0) return;
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            if(cur.children[character - 'a'] == null){
                cur.children[character - 'a'] = new TrieNode(character);
            }
            cur = cur.children[character - 'a'];
        }
        cur.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        return find(root, word, 0);
    }

    private boolean find(TrieNode node, String word, int length){
        if(node == null) return false;
        if(length == word.length()) return node.isWord;

        char character = word.charAt(length);
        if(character == '.'){
            for (TrieNode each : node.children){
                if(find(each, word, length+1)){
                    return true;
                }
            }
        }else{
            if(node.children[character - 'a'] == null){
                return false;
            }
            TrieNode next = node.children[character - 'a'];
            return find(next, word, length+1);
        }
        return false;
    }
}
