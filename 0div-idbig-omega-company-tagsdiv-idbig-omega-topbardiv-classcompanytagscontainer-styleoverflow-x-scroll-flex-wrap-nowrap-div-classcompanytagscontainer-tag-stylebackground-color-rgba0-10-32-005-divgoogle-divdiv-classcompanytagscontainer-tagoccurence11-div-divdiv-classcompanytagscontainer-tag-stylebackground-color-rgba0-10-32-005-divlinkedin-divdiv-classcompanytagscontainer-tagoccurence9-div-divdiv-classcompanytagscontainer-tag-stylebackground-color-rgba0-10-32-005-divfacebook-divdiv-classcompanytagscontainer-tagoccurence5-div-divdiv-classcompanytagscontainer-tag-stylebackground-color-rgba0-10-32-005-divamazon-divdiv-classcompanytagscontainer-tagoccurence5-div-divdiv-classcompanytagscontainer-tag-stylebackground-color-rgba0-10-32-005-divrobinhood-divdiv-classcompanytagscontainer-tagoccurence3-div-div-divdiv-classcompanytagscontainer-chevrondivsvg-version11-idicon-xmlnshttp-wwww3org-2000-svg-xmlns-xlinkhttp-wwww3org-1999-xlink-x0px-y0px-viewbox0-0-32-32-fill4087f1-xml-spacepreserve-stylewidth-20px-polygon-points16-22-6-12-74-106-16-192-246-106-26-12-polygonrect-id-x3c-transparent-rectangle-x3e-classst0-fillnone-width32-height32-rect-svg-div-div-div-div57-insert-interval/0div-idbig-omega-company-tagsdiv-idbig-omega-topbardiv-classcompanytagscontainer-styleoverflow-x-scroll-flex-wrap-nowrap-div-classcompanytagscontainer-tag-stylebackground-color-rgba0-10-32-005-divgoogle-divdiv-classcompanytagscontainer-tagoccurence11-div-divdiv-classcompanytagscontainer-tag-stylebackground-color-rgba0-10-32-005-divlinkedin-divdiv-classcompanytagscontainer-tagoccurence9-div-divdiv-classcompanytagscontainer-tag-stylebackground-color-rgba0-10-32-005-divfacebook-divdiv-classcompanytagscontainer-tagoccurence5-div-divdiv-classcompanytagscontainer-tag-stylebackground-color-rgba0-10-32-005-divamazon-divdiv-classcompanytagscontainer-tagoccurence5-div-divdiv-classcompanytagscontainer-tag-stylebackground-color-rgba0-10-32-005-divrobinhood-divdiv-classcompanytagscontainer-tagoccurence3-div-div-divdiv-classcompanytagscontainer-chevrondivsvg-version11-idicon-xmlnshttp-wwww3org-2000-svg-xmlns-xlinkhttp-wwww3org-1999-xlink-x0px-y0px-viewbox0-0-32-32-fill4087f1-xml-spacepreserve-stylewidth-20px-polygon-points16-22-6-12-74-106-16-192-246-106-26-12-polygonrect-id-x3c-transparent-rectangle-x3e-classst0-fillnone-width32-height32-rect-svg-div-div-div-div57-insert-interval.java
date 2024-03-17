class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[] > mergedIntervals = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        
        int i = 0;
        int n = intervals.length;
        
        // skip (and add to output) all intervals that come before the 'newInterval'
        while(i < n && intervals[i][1] < start){
            mergedIntervals.add(new int[] { intervals[i][0], intervals[i][1]});
            i++;
        }
        
        // merge all intervals that overlap with 'newInterval'
        while (i < n && intervals[i][0] <= end){
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        
        // insert the newInterval
        mergedIntervals.add(new int[] {start, end});
        
        // add all the remaining intervals to the output
        while(i < n){
           mergedIntervals.add(new int[] { intervals[i][0], intervals[i][1]});
            i++;
        }
        
        return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);     
    }
}
/*
TC O(n)
*/