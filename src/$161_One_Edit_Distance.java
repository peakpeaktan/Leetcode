/*
Given two strings s and t, determine if they are both one edit distance apart.

Note:
There are 3 possibilities to satisfy one edit distance apart:

Insert a character into s to get t
Delete a character from s to get t
Replace a character of s to get t

Example 1:
Input: s = "ab", t = "acb"
Output: true
Explanation: We can insert 'c' into s to get t.

Example 2:
Input: s = "cab", t = "ad"
Output: false
Explanation: We cannot get t from s by only one step.

Example 3:
Input: s = "1203", t = "1213"
Output: true
Explanation: We can replace '0' with '1' to get t.
 */

//label_string
public class $161_One_Edit_Distance {
    //https://www.cnblogs.com/grandyang/p/5184698.html
    public boolean isOneEditDistance(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        if(sLength > tLength){//here we enforce s is smaller in size
            return isOneEditDistance(t, s);
        }
        if(tLength - sLength > 1) return false;//if difference is greater than 1 return false
        if(sLength == tLength){
            for (int i = 0; i < sLength; i++) {
                if(s.charAt(i) != t.charAt(i)){
                    return s.substring(i+1).equals(t.substring(i+1));
                }
            }
        }else if(tLength - sLength == 1){
            for (int i = 0; i < sLength; i++) {
                if(s.charAt(i) != t.charAt(i)){
                    return s.substring(i).equals(t.substring(i+1));
                }
            }
            return true;//if after iteration all the characters are equal in two strings, return true, for example, "ab" "abc"
        }
        return false;
    }
}
