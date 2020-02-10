/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considerred overlapping.
 */
//https://www.youtube.com/watch?v=0aaCHSYzSVs&t=367s
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class $56_Merge_Intervals {

    public List<Interval> merge(List<Interval> intervals) {

        int[] startPositinArray = new int[intervals.size()];
        int[] endPositinArray = new int[intervals.size()];

        for (int i = 0; i < intervals.size(); i++){

            startPositinArray[i] = intervals.get(i).start;
            endPositinArray[i] = intervals.get(i).end;
        }

        Arrays.sort(startPositinArray);//sort
        Arrays.sort(endPositinArray);//sort

        List<Interval> result = new ArrayList<>();

        for (int i = 0, j = 0; i < startPositinArray.length; i++) {

            if(i == startPositinArray.length - 1 && startPositinArray[i+1] > endPositinArray[i]){

                result.add(new Interval(startPositinArray[j], endPositinArray[i]));

                j = i + 1;
            }
        }

        return result;
    }

    public static void main(String [] args){

        //[[1,3],[2,6],[8,10],[15,18]]
        // 1,  2,  8,  15
        // 3,  6,  10, 18

//        System.out.println(Arrays.toString(solution.shuffle()));
    }
}

 class Interval {

      int start;
      int end;

      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}
