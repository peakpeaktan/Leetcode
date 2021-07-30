import java.util.ArrayList;
import java.util.List;

public class $57_Insert_Interval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> result = new ArrayList<>();
        while (i < intervals.length && intervals[i][1] < newInterval[0]){
            result.add(intervals[i++]);
        }
        while (i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval = new int[]{Math.min(newInterval[0], intervals[i][0]), Math.max(newInterval[1], intervals[i][1])};
            i++;
        }
        result.add(newInterval);
        while (i < intervals.length){
            result.add(intervals[i++]);
        }
        return result.toArray(new int[result.size()][]);
    }
}
