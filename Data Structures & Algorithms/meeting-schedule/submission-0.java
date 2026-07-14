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
        Collections.sort(intervals, (i1, i2) -> Integer.compare(i1.start, i2.start));
        int maxEnd = 0;
        for (Interval i : intervals) {
            if (i.start < maxEnd) return false;
            maxEnd = Math.max(maxEnd, i.end);
        }

        return true;
    }
}
