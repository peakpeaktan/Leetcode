package EASY;
import java.util.*;
/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */

//label_array
public class $118_Pascals_Triangle {
    //https://leetcode.com/problems/pascals-triangle/discuss/38141/My-concise-solution-in-Java
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            temp.add(0,1);//append a 1 at the beginning for each new row
            for (int j = 1; j < temp.size() - 1; j++) {//only update numbers between first and last element
                temp.set(j, temp.get(j) + temp.get(j+1));
            }
            result.add(new ArrayList<>(temp));//IMPORTANT: new ArrayList<>(temp)
        }
        return result;
    }

    public static void main(String [] args){
        System.out.println(generate(5));
    }
}
