package EASY;
/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"
 */

//similar: 171. Excel Sheet Column Number
public class $168_Excel_Sheet_Column_Title {

    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.append( (char)('A' + n % 26));
            n /= 26;
        }

        return result.reverse().toString();
    }

    public static void main(String [] args){
        convertToTitle(28);
    }
}
