/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */

//good explanation of zigzag pattern
//https://leetcode.com/problems/zigzag-conversion/discuss/3435/If-you-are-confused-with-zigzag-patterncome-and-see!

public class $6_ZigZag_Conversion {

    public String convert(String s, int numRows) {

        if(numRows <= 1) return s;
        StringBuilder[] sbArray = new StringBuilder[numRows];
        for (int i = 0; i < sbArray.length; i++) {
            sbArray[i] = new StringBuilder("");
        }

        for (int i = 0; i < s.length(); i++) {
            int index = i % (2 * numRows - 2);
            index  = index < numRows ? index : 2 * numRows - 2 - index;
            sbArray[index].append(s.charAt(i));
        }

        for (int i = 1; i < sbArray.length; i++) {
            sbArray[0].append(sbArray[i]);
        }

        return sbArray[0].toString();
    }
}
