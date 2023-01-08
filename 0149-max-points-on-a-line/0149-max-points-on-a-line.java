class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        
        if(n <=2 ) return n; // 2 or less points can always form a line.
        
        int ans = 2;
        
        for(int[] a : points) {
            //Map<Double, Integer> for storing (slope, no of times 2 points generate this slope.)
            Map<Double, Integer> map = new HashMap<>();
            for(int[] b : points) { // dont measure slope for same points in plane.   
                // if a is (x1, y1) and b is(x2, y2) then slope is (y2 - y1)/(x2 -x1)
                // a (a0, a1) & b is (b0, b1)
               
                if(a == b) continue;
                double slope = 0;
                if(b[0] - a[0] == 0) slope = Double.POSITIVE_INFINITY;
                else slope = (b[1] -a[1]) / (double)(b[0] - a[0]);
                
                //map.getOrDefault(slope, 0)+1 is adding 1 more point count for that slope if we already had that slope. 
                // by default , 1 will be count of a new slope.
                map.put(slope, map.getOrDefault(slope, 1)+1);
                ans = Math.max(ans, map.get(slope));
            }
            
        }
        return ans;
        
    }
}