import java.util.HashMap;
/*

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3.
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

//https://www.youtube.com/watch?v=hw0zHamgaks&t=5s
//label_hashmap
//label_string
//label_twopointers
//similar: 159, 340, 904, 1695
public class $3_Longest_Substring_Without_Repeating_Characters {
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation/2121
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        int j = 0;
        for (int i=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){//if encounters same character
                j = Math.max(j,map.get(s.charAt(i))+1);//j cannot decrease
            }
            map.put(s.charAt(i),i);//update the index of the character
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String [] args){

        String first = "abcabcbb";
        String second = "abcaa";
        String third = "tmsmfdut";

        System.out.println(lengthOfLongestSubstring(second));
    }
}
