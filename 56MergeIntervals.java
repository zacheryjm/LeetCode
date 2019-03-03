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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() <= 1) {return intervals;}
        
        intervalComparator comparator = new intervalComparator();
        
        intervals.sort(comparator);
        int i = 1;
        
        while(i < intervals.size()) {
            
            if(intervals.get(i).start <= intervals.get(i-1).end) {
                intervals.get(i-1).end = Math.max(intervals.get(i-1).end,
                                                  intervals.get(i).end);
                intervals.remove(i);
            }
            else {
                i++;
            }
            
        }
        
        return intervals;
        
    }
    
    public class intervalComparator implements Comparator<Interval>{
        
        @Override
        public int compare(Interval i1, Interval i2) {
            if (i1.start < i2.start) {
                return -1;
            }
            else if(i1.start == i2.start) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
}

