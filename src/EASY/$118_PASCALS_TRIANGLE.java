package EASY;
/*
Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
https://leetcode.com/problems/pascals-triangle/description/
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class $118_PASCALS_TRIANGLE {

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            temp.add(0,1);//append a 1 at the beginning for each new row

            for (int j = 1; j < temp.size() - 1; j++) {

                temp.set(j, temp.get(j) + temp.get(j+1));//update the number according to the previous row
            }

            result.add(new ArrayList<>(temp));//IMPORTANT: new ArrayList<>(temp)
        }
        return result;
    }

    public static void main(String [] args){

        System.out.println(generate(5));
    }
}
