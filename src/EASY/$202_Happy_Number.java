package EASY;
import java.util.HashSet;
import java.util.Set;
/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.


Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1
 */

//label_hashset
//label_math
public class $202_Happy_Number {

    public static boolean isHappy(int n) {
        Set<Integer> mySet = new HashSet<>();

        while(mySet.add(n)) {
            int sum = 0;
            while(n > 0){
                int single = n % 10;
                sum = single * single + sum;
                n /= 10;
            }
            if(sum == 1){
                return true;
            }else{
                n = sum;
            }
        }

        return false;
    }

    public static void main(String [] args){

        System.out.println(isHappy(19));
    }
}
