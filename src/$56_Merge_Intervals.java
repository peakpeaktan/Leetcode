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

    /*
    public List<Interval> merge2(List<Interval> intervals) {

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
    */

    //https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution
    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String [] args){

        int[][] array = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] array2 = {{3,1}, {6,2}, {8,10}, {15,18}};//this will not pass
        System.out.println(Arrays.toString(merge(array)));
    }
}

/*
 class Interval {

      int start;
      int end;

      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}
*/