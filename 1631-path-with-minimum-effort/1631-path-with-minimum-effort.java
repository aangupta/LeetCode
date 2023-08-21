class Node {
    int row;
    int col; 
    int diff;
    
    Node(int row, int col, int diff) {
        this.row = row;
        this.col = col;
        this.diff = diff;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int rows = heights.length;
        int cols = heights[0].length;
        
        int[][] distance = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                distance[i][j] = (int)1e9;
            }
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.diff - b.diff);
        pq.add(new Node(0,0,0));
        distance[0][0] = 0;
        
        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1};
        
        while(pq.size() > 0) {
            Node node = pq.peek();
            pq.remove();
            
            int diff = node.diff;
            int row = node.row;
            int col = node.col;
            
            if(row == rows-1 && col == cols-1) return distance[row][col];
            
            for(int i = 0; i < 4; i++) {
                int nr = dr[i] + row;
                int nc = dc[i] + col;
                
                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols) {
                    
                    // Effort can be calculated as the max value of differences 
                    // between the heights of the node and its adjacent nodes.
                    int newEffort = Math.max(Math.abs(heights[nr][nc] - heights[row][col]) , diff);
                    
                    // If the calculated effort is less than the prev value
                    // we update as we need the min effort.
                    if(newEffort < distance[nr][nc]) {
                        distance[nr][nc] = newEffort;
                        pq.add(new Node(nr, nc, newEffort ));
                    }
                }
            }
        }
        
        return 0;
        
    }
}