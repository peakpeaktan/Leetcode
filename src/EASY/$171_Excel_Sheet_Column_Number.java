package EASY;
/*
Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...
Example 1:

Input: "A"
Output: 1
Example 2:

Input: "AB"
Output: 28
Example 3:

Input: "ZY"
Output: 701
 */

//similar: 168. Excel Sheet Column Title
//label_math
public class $171_Excel_Sheet_Column_Number {
    //https://www.youtube.com/watch?v=6QLxVYg5cQQ&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A
    public int titleToNumber(String s) {

        int result = 0;
        for (int i = 0; i < s.length(); i++){
             result = result * 26 + (s.charAt(i) - 'A' + 1);
        }
        return result;
    }
}
