import java.util.*;
/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */

//label_dp
//label_matrix
public class $120_Triangle {

    //solution 1: bottom up, much easier than top down, not modifying input, use an array to record values
    //https://leetcode.com/problems/triangle/discuss/38724/7-lines-neat-Java-Solution
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    //in place, modifying input
    //https://leetcode.com/problems/triangle/discuss/38724/7-lines-neat-Java-Solution/112560
    //https://www.youtube.com/watch?v=RPuhCa2NCvw
    public static int minimumTotalOptimized(List<List<Integer>> triangle) {
        int len = triangle.size();
        for(int i=len-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String [] args){
        //   [2]
        //  [3,4]
        // [6,5,2]
        //[4,1,8,1]
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(2);
        List<Integer> secondList = new ArrayList<>();
        secondList.add(3);
        secondList.add(4);
        List<Integer> thirdList = new ArrayList<>();
        thirdList.add(6);
        thirdList.add(5);
        thirdList.add(2);
        List<Integer> fourthList = new ArrayList<>();
        fourthList.add(4);
        fourthList.add(1);
        fourthList.add(8);
        fourthList.add(1);
        triangle.add(firstList);
        triangle.add(secondList);
        triangle.add(thirdList);
        triangle.add(fourthList);
        minimumTotalOptimized(triangle);
    }
}
