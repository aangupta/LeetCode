class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length <= 1)
            return intervals;
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        List<int[] > mergedList = new ArrayList<>();
        
        int start = intervals[0][0];
        int end = intervals[0][1];
         int[] res = new int[2];
        for(int i = 1; i < intervals.length; i++){
           
            // overlapping intervals, adjust the 'end'
            if(intervals[i][0] <= end){
                end = Math.max(end, intervals[i][1]);    
            }
            else {
                // non-overlapping interval, add the previous interval and reset
                mergedList.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
       
        // add the last interval
        mergedList.add(new int[]{start, end});
        return mergedList.toArray(new int[mergedList.size()][2]);
        
    }
}

//TC (nlogn) 

/*
Sort the intervals on the start time to ensure a.start <= b.start
If ‘a’ overlaps ‘b’ (i.e. b.start <= a.end), we need to merge them into a new interval ‘c’ such that:
c.start = a.start
c.end = max(a.end, b.end)
*/