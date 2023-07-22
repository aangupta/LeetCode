class Pair {
    int row, col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    
    private void bfs(int row, int col, int[][] grid, int[][] visited) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = 1;
        //grid[row][col] = 1;
        
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{-1, 0, 1, 0};
        
        while(queue.size() > 0){
            
            int currRow = queue.peek().row;
            int currCol = queue.peek().col;
            
            queue.remove();
            
            for(int i = 0; i < 4; i++){
                
                int nr = currRow + dx[i];
                int nc = currCol + dy[i];
                
                
                if(nr >=0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 0 && visited[nr][nc] == 0){
                    queue.add(new Pair(nr, nc));
                    visited[nr][nc] = 1;
                    //grid[nr][nc] = 1;
                }
            }
        }
        
        
    }
    public int closedIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] visited = new int[rows][cols];
        
        int count = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                
                if(i == 0 || i == rows-1 || j == 0 || j == cols-1 ){
                    if(grid[i][j] == 0 && visited[i][j] == 0){
                        bfs(i,j,grid, visited);
                    }
                }
            }
        }
        
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 0 && visited[i][j] == 0){
                    bfs(i,j,grid,visited);
                    count++;
                }
            }
        }
        
        
        
        
        return count;
        
    }
}
