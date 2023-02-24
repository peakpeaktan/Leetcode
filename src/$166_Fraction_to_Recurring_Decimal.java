import java.util.*;
/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.


Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"
Example 2:

Input: numerator = 2, denominator = 1
Output: "2"
Example 3:

Input: numerator = 2, denominator = 3
Output: "0.(6)"
Example 4:

Input: numerator = 4, denominator = 333
Output: "0.(012)"
Example 5:

Input: numerator = 1, denominator = 5
Output: "0.2"


Constraints:

-231 <= numerator, denominator <= 231 - 1
denominator != 0

 */

//label_math
//label_hashmap
public class $166_Fraction_to_Recurring_Decimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        boolean isPositive = false;
        if((numerator >= 0 && denominator >= 0) || (numerator <= 0 && denominator <= 0)){
            isPositive = true;
        }
        long numeratorLong = Math.abs((long)numerator);
        long denominatorLong = Math.abs((long)denominator);
        StringBuilder sb = new StringBuilder();
        if(!isPositive){
            sb.append('-');
        }
        if(numeratorLong % denominatorLong == 0){
            sb.append(numeratorLong / denominatorLong);
            return sb.toString();
        }
        sb.append(numeratorLong / denominatorLong);
        numeratorLong %= denominatorLong;
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while(numeratorLong != 0){
            numeratorLong *= 10;
            sb.append(numeratorLong / denominatorLong);
            numeratorLong %= denominatorLong;
            if(map.containsKey(numeratorLong)){
                sb.insert(map.get(numeratorLong), "(");
                sb.append(')');
                break;
            }else{
                map.put(numeratorLong, sb.length());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        fractionToDecimal(4, 333);
    }
}
