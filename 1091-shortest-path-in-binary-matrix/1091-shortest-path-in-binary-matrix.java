class Node {
    int row;
    int col; 
    int distance;
    
    Node (int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][] dirs = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}, {1,1}, {-1,1}, {1,-1}, {-1,-1}};
        
        //edge case 1
        if(grid.length == 0) return -1;
        
        int n = grid.length;
        
        //edge case 2
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;
        
        //edge case 3
        if(n == 1 && grid[0][0] == 0) return 1;
        
       
        
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++)
                dist[i][j] = (int)1e9;
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,1));
        dist[0][0] = 1;
        
        while(queue.size() > 0) {
            Node node = queue.peek();
            queue.remove();
            
            //traversing all adjacent node
            for(int i = 0; i < dirs.length; i++){
                int nr = node.row + dirs[i][0];
                int nc = node.col + dirs[i][1];
                
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid.length && grid[nr][nc] == 0 && node.distance + 1 < dist[nr][nc]) {
                    dist[nr][nc] = node.distance + 1;
                    
                    if(nr == grid.length-1 && nc == grid.length-1) return dist[nr][nc];
                    
                    queue.add(new Node(nr, nc, dist[nr][nc]));
                }
            }
            
        }
        
        return -1;
    }
}