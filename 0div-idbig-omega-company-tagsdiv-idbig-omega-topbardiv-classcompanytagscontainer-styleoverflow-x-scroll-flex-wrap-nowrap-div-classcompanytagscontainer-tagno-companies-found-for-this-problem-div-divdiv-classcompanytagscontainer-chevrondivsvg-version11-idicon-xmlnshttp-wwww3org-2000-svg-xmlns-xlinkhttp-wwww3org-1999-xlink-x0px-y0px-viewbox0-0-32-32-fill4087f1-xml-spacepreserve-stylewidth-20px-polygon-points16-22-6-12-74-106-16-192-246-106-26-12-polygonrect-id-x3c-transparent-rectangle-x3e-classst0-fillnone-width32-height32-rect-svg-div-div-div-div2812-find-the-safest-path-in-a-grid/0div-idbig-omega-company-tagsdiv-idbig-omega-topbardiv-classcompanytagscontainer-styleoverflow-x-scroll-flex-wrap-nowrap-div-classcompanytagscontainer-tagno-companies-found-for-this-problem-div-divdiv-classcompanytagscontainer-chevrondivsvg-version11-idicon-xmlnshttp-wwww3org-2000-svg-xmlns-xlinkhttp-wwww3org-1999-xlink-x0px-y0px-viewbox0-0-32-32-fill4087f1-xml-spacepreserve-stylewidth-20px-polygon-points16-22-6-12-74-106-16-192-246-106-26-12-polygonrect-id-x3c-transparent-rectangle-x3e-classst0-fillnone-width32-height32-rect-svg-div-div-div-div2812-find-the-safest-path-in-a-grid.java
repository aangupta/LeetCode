class Pair {
    int row;
    int col;
    int dist;
    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    
    //The farther from the theif we are, the safer we will be
    //Need to find the shortest and safest path from grid[sx][sy] to grid[tx][ty] by travelling farthest from lion cells.
   //and also keeping the track of the min safestest factor/ minimum ever distance between any cell and a theif in that path.
    private int findSafenessFactor(int[][] distance, int n) {
        int[][] visited = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = 0;
            }
        }
        
        int[] dx = new int[] {0,0,1,-1};
        int[] dy = new int[] {1,-1,0,0};
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.dist - a.dist);
        int ans = n+1;
        
        pq.add(new Pair(0,0,distance[0][0]));
        visited[0][0] = 1;
        
        while(pq.size() > 0) {
            Pair p = pq.peek();
            pq.remove(); 
            int cRow = p.row, cCol = p.col, cDist = p.dist;
            ans = Math.min(ans, p.dist);
            
            if(cRow == n-1 && cCol == n-1)
                break;
            
            for(int i = 0; i < 4; i++) {
                int nr = cRow + dx[i];
                int nc = cCol + dy[i];
                
                if(nr >=0 && nr < n && nc >= 0 && nc < n && visited[nr][nc] == 0) {
                    visited[nr][nc] = 1;
                    pq.add(new Pair(nr, nc, distance[nr][nc]));
                }
            
            }
            
            
        }
        return ans;
        
    }
    
    private void buildDistanceMatrix( int[][] distance, int[][] visited,  Queue<Pair> queue, int n) {
        
        int[] dx = new int[] {0,0,1,-1};
        int[] dy = new int[] {1,-1,0,0};
        
        while(queue.size() > 0) {
            Pair p = queue.peek();
            queue.remove();
            
            int cRow = p.row, cCol = p.col, cDist = p.dist;
            
            for(int i = 0; i < 4; i++) {
                int nr = cRow + dx[i];
                int nc = cCol + dy[i];
                
                if(nr >=0 && nr < n && nc >= 0 && nc < n && visited[nr][nc] == 0) {
                    distance[nr][nc] = cDist + 1;
                    visited[nr][nc] = 1;
                    queue.add(new Pair(nr, nc, cDist + 1));
                }
            }
        }
        
    }
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        //base case
        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1)
            return 0;
        
        
        int[][] visited = new int[n][n];
        int[][] distance = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                visited[i][j] = 0;
                distance[i][j] = n+1;
            }
        }
        
        Queue<Pair> queue = new LinkedList<>();
        
        //adding all the theif cells to the queue
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == 1) {
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 1;
                    distance[i][j] = 0;
                }
            }
        }
        
        //building a distance array where each cell respresents distance of that cell with the nearest theif
        buildDistanceMatrix(distance, visited, queue, n);
        
        /* for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(distance[i][j] + " " );
            }
            System.out.println();
        } */
       
        
       return findSafenessFactor(distance, n);
    }
}