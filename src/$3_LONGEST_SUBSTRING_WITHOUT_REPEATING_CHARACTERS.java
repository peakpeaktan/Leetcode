/*

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
//https://www.youtube.com/watch?v=hw0zHamgaks&t=5s
import java.util.HashMap;

public class $3_LONGEST_SUBSTRING_WITHOUT_REPEATING_CHARACTERS {

    public static int lengthOfLongestSubstring(String s) {

        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){//if encounters same character
                j = Math.max(j,map.get(s.charAt(i))+1);//update j to the position after the encountered character
            }
            map.put(s.charAt(i),i);//update the index of the character
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String [] args){

        String first = "abcabcbb";
        String second = "abcaa";

        System.out.println(lengthOfLongestSubstring(second));
    }
}
