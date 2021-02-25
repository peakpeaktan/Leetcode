/*
Implement a trie with insert, search, and startsWith methods.

Example:

Trie trie = new Trie();

trie.insert("apple");
trie.search("apple");   // returns true
trie.search("app");     // returns false
trie.startsWith("app"); // returns true
trie.insert("app");
trie.search("app");     // returns true
Note:

You may assume that all inputs are consist of lowercase letters a-z.
All inputs are guaranteed to be non-empty strings.
 */

//similar: 211. Design Add and Search Words Data Structure

class Trie {

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
    public Trie() {
        root = new TrieNode(' ');
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word != null && word.length() > 0){
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                if(cur.children[word.charAt(i) - 'a'] == null){
                    cur.children[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || word.length() == 0) return false;
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            if(cur.children[word.charAt(i) - 'a'] == null){
                return false;
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        return cur.isWord == true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0) return false;
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            if(cur.children[prefix.charAt(i) - 'a'] == null){
                return false;
            }
            cur = cur.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }

}

public class $208_Implement_Trie_Prefix_Tree {

    public static void main(String[] args) {
        Trie tri = new Trie();
        tri.insert("car");
    }
}