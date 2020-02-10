package EASY;

/*
Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.

Follow up:
What if the inputs contain unicode characters? How would you adapt your solution to such case?

 */
public class $242_VALID_ANAGRAM {

    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int[] array = new int[26];

        for (int i = 0; i < s.length() ; i++) {
            array[s.charAt(i) - 'a']++;
            array[t.charAt(i) - 'a']--;
        }

        for (int num : array){
            if(num != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String [] args){

        String first = "anagram";
        String second = "nagaram";

        System.out.println(isAnagram(first, second));
    }
}
