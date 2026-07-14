/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // short by start
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
        // store the last interval's end
        int maxEnd = 0;
        for (Interval i : intervals) {
            // if current meeting starts before previous end return false 
            if (i.start < maxEnd) return false;

            // update maxEnd to max of current end and maxEnd
            maxEnd = Math.max(maxEnd, i.end);
        }

        // if no interval is overlapping return true
        return true;
    }
}
