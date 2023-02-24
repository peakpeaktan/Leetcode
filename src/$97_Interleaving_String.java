/*
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:

s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1
The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
Example 3:

Input: s1 = "", s2 = "", s3 = ""
Output: true


Constraints:

0 <= s1.length, s2.length <= 100
0 <= s3.length <= 200
s1, s2, and s3 consist of lowercase English letters.


Follow up: Could you solve it using only O(s2.length) additional memory space?

 */

//label_dp
//label_string
public class $97_Interleaving_String {
    //https://www.youtube.com/watch?v=ih2OZ9-M3OM&ab_channel=TusharRoy-CodingMadeSimple

    public static boolean is_Interleave(String s1, int i, String s2, int j, String res, String s3)
    {
        if(res.equals(s3) && i == s1.length() && j == s2.length())
            return true;
        boolean ans = false;
        if(i < s1.length())
            ans |= is_Interleave(s1, i + 1, s2, j, res + s1.charAt(i), s3);
        if(j < s2.length())
            ans |= is_Interleave(s1, i, s2, j + 1, res + s2.charAt(j), s3);
        return ans;

    }
    public static boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        return is_Interleave(s1, 0, s2, 0, "", s3);
    }

    public static void main(String[] args){
        isInterleave("aabcc", "dbbca", "aadbbcbcac");
    }
}
