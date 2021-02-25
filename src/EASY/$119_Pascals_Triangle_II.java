package EASY;
import java.util.*;
/*
Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.

Note that the row index starts from 0.


In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 3
Output: [1,3,3,1]
Follow up:

Could you optimize your algorithm to use only O(k) extra space?
 */

public class $119_Pascals_Triangle_II {

    //https://leetcode.com/problems/pascals-triangle-ii/discuss/38478/My-accepted-java-solution-any-better-code
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < rowIndex+1; i++) {//rowIndex + 1
            temp.add(0,1);//append a 1 at the beginning for each new row
            for (int j = 1; j < temp.size() - 1; j++) {
                temp.set(j, temp.get(j) + temp.get(j+1));
            }
        }
        return temp;
    }

    public static void main(String [] args){
        System.out.println(getRow(5));
    }
}
