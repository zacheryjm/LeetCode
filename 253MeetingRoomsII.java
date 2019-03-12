/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0) return 0;
        
        CompareInterval compare = new CompareInterval();
        
        List<Interval> list = Arrays.asList(intervals);
        list.sort(compare);
        
        PriorityQueue<Integer> meetings = new PriorityQueue<Integer>();
        meetings.add(intervals[0].end);
                        
        for(int i = 1; i < list.size(); ++i) {
            if(list.get(i).start >= meetings.peek()) {
                meetings.poll();
            }
            meetings.add(list.get(i).end);
        }
        
        return meetings.size();
    }
    
    public class CompareInterval implements Comparator<Interval> {
        
        public int compare(Interval I1, Interval I2) {
            if(I1.start < I2.start) return -1;
            else if(I1.start == I2.start) return 0;
            else return 1;
        }
    
    }
}


