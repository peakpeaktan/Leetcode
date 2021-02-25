package HARD;
import java.util.*;
/*
Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.

For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:

[1, 1]
[1, 1], [3, 3]
[1, 1], [3, 3], [7, 7]
[1, 3], [7, 7]
[1, 3], [6, 7]


Follow up:

What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 */

//similar: 163. Missing Ranges, 228. Summary Ranges
public class $352_Data_Stream_as_Disjoint_Intervals {
    //https://leetcode.com/problems/data-stream-as-disjoint-intervals/discuss/82553/Java-solution-using-TreeMap-real-O(logN)-per-adding.
    //treemap: https://www.youtube.com/watch?v=WNh6RzHlS9Q
    TreeMap<Integer, Interval> tree;

    public $352_Data_Stream_as_Disjoint_Intervals() {
        tree = new TreeMap<>();
    }

    public void addNum(int val) {
        if(tree.containsKey(val)) return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if(l != null && h != null && tree.get(l).end + 1 == val && h == val + 1) {
            tree.get(l).end = tree.get(h).end;
            tree.remove(h);
        } else if(l != null && tree.get(l).end + 1 >= val) {
            tree.get(l).end = Math.max(tree.get(l).end, val);
        } else if(h != null && h == val + 1) {
            tree.put(val, new Interval(val, tree.get(h).end));
            tree.remove(h);
        } else {
            tree.put(val, new Interval(val, val));
        }
    }

    public int[][] getIntervals() {
        int[][] result = {};
        int i = 0;
        for(Map.Entry m : tree.entrySet())
        {
            result[i][0] = tree.get(m.getKey()).start;
            result[i][1] = tree.get(m.getKey()).end;
            i++;
        }
        return result;
    }

    public static void main(String [] args){
        $352_Data_Stream_as_Disjoint_Intervals clazz = new $352_Data_Stream_as_Disjoint_Intervals();
        clazz.addNum(6);
        clazz.addNum(6);
        clazz.addNum(0);
        clazz.addNum(4);
        clazz.addNum(8);
        clazz.addNum(7);
        clazz.addNum(6);
        clazz.addNum(4);
        clazz.addNum(7);
        clazz.addNum(5);
        clazz.getIntervals();
    }
}

class Interval {
    int start;
    int end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
