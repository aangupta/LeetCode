class Pair {
    int row, col, dist;
    Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        int[][] visited = new int[rows][cols];
        int[][] distance = new int[rows][cols];
        
        Queue<Pair> queue = new LinkedList<>();
        
        //adding all the cells having 0 to the queue
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(mat[i][j] == 0){
                    queue.add(new Pair(i,j,0));
                    visited[i][j] = 1;
                }
            }   
        }
        
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{-1, 0, 1, 0};
        
        while(queue.size() > 0){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int dist = queue.peek().dist;
            
            queue.remove();
            
            distance[row][col] = dist;
            
            //adding all the neighbours into the queue if they are not visited
            for(int i =0; i < 4; i++){
                int nr = row + dx[i];
                int nc = col + dy[i];
                
                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && visited[nr][nc] == 0){
                    queue.add(new Pair(nr, nc, dist + 1));
                    visited[nr][nc] = 1;
                }
            }
        }
        
        return distance;
        
        
    }
}