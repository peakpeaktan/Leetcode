import java.util.*;
/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

Example:

Input:  n = 2
Output: ["11","69","88","96"]
 */

//label_string
public class $247_Strobogrammatic_Number_II {
    int target;
    public List<String> findStrobogrammatic(int n) {
        target = n;
        return find(n);
    }

    List<String> find(int n){
        List<String> res = new ArrayList<>();
        if(n == 0){
            res.add("");
            return res;
        }
        if(n == 1){
            res.add("1");
            res.add("0");
            res.add("8");
            return res;
        }

        List<String> prev = find(n-2);

        for(String s : prev){
            if(n != target) res.add("0" + s + "0");
            res.add("1" + s + "1");
            res.add("8" + s + "8");
            res.add("6" + s + "9");
            res.add("9" + s + "6");
        }

        return res;
    }
}
