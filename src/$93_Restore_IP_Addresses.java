import java.util.*;
/*
A valid IP address consists of exactly four integers separated by single dots. Each integer is between 0 and 255 (inclusive) and cannot have leading zeros.

For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses, but "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
Given a string s containing only digits, return all possible valid IP addresses that can be formed by inserting dots into s. You are not allowed to reorder or remove any digits in s. You may return the valid IP addresses in any order.


Example 1:

Input: s = "25525511135"
Output: ["255.255.11.135","255.255.111.35"]
Example 2:

Input: s = "0000"
Output: ["0.0.0.0"]
Example 3:

Input: s = "101023"
Output: ["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]


Constraints:

1 <= s.length <= 20
s consists of digits only.
 */

//label_backtracking
public class $93_Restore_IP_Addresses {
    //https://www.youtube.com/watch?v=61tN4YEdiTM&ab_channel=NeetCode
    //https://www.youtube.com/watch?v=b8_w2ljAzeU&ab_channel=%E8%B4%BE%E8%80%83%E5%8D%9A
    public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList();
        if(s.length() > 12) return list;

        helper(s, list, 0, "", 0);
        return list;
    }

    void helper(String s, List<String> list, int pos, String res, int sec){
        if(sec == 4 && pos == s.length()) {
            list.add(res);
            return;
        }

        for(int i = 1; i <= 3; i++){
            if(pos + i > s.length()) break;
            String section = s.substring(pos, pos + i);
            if(section.length() > 1 && section.startsWith("0") || Integer.parseInt(section) >= 256)  break;
            helper(s, list, pos + i, sec == 0 ? section : res + "." + section, sec + 1);
        }
    }
}
