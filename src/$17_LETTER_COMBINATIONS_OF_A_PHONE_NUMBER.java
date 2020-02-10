/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
import java.util.*;
public class $17_LETTER_COMBINATIONS_OF_A_PHONE_NUMBER {

    //BFS
    public static List<String> letterCombinationsBFS(String digits) {

        //LinkedList as Queue implementation
        LinkedList<String> ans = new LinkedList<String>();

        if(digits.isEmpty()) return ans;
        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");//initialize by adding an empty string
        while(ans.peek().length()!=digits.length()){
            String remove = ans.remove();//LinkedList remove() removes element at head position
            String map = mapping[digits.charAt(remove.length())-'0'];
            for(char c: map.toCharArray()){
                ans.addLast(remove+c);
            }
            System.out.println("removed is " + remove);
            System.out.println(ans);
        }
        return ans;

        /*Example with input 23
        Queue: a, b, c
        Queue: b, c, ad, ae, af
        Queue c, ad, ae, af, bd, be, bf
        Queue: ad, ae, af, bd, be, bf, cd, ce, cf
        */
    }

//    //DFS
//    public static List<String> letterCombinationsDFS(String digits) {
//
//
//    }

    public static void main(String [] args){

        letterCombinationsBFS("23");
    }
}
