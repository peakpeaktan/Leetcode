package EASY;
import java.util.*;
/*
Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si< ei), determine if a person could attend all meetings.

Example 1:
Input:
[[0,30],[5,10],[15,20]]
Output:
 false
Example 2:
Input:
 [[7,10],[2,4]]

Output:
 true
 */

//label_array
public class $252_Meeting_Rooms {
    //https://aaronice.gitbook.io/lintcode/sweep-line/meeting-rooms
    //https://www.youtube.com/watch?v=0roQnDBC27o
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (int i = 0; i < intervals.length - 1; i++) {//loop until 倒数第二个
            if (intervals[i].end > intervals[i + 1].start) return false;
        }
        return true;
    }
}

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
