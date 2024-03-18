class Solution {
    public int findMinArrowShots(int[][] points) {
        int arrows = 1;
        
        //sorting the points in increasing order of xstart
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        int start = points[0][0];
        int end = points[0][1];
        
        for(int i = 1; i < points.length; i++) {
            
            //overlap
            if(points[i][0] <= end){
                end = Math.min(end, points[i][1]);
            }
                
            else {
                arrows++;
                end = points[i][1];
            }
        }
        return arrows;
    }
}