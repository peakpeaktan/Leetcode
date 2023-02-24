import java.util.*;
/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]


Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
 */

//label_backtracking
//label_dfs
//label_bfs
public class $17_Letter_Combinations_of_a_Phone_Number {
    //BFS solution using a queue, TC: O(4^N), where N is the length of the input digits, 4 digits in total if the digit is 7 or 9
    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue
    public List<String> letterCombinationsBFS(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits.isEmpty()) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");//initialize by adding an empty string
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();//LinkedList remove() removes head element
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        return ans;
        /*Example with input 23
        Queue: a, b, c
        Queue: b, c, ad, ae, af
        Queue c, ad, ae, af, bd, be, bf
        Queue: ad, ae, af, bd, be, bf, cd, ce, cf
        */
    }

    //another BFS solution, which is more intuitive to me
    //https://leetcode.com/problems/letter-combinations-of-a-phone-number/discuss/8064/My-java-solution-with-FIFO-queue/205699
    public List<String> letterCombinationsBFS2(String digits) {
        List<String> ans = new LinkedList<String>();
        if (digits.isEmpty())
            return ans;
        String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        ans.add(0, "");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            int size = ans.size();     // number of nodes/strings already in the queue
            for (int k = 1; k <= size; k++) {
                String t = ans.remove(0);
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    //DFS
    public static List<String> letterCombinationsDFS(String digits) {
        List<String> ret = new LinkedList<>();
        if(digits == null || digits.length() == 0) return ret;
        combination("", digits, 0, ret);
        return ret;
    }

    private static void combination(String prefix, String digits, int offset, List<String> ret) {
        String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        if (offset == digits.length()) {
            ret.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, ret);
        }
    }

    //DFS backtracking solution using StringBuilder to avoid creating too many string copies
    public List<String> letterCombinationsDFS2(String digits) {
        List<String> list = new LinkedList<>();
        if(digits == null || digits.length() == 0) return list;
        char[][] map = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        backtrack(digits,list,map,new StringBuilder(),0);
        return list;
    }
    private void backtrack(String digits, List<String> list, char[][] map, StringBuilder sb, int start){
        if(start == digits.length()) {
            list.add(new String(sb));
            return;
        }
        int num = digits.charAt(start) - '0';
        for(int i = 0;i< map[num].length;i++){
            sb.append(map[num][i]);
            backtrack(digits, list, map, sb,start+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String [] args){
        //letterCombinationsBFS("234");
        letterCombinationsDFS("234");
    }
}
