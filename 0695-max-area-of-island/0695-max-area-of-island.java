class Pair {
    int row, col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    
    private int dfs(int row, int col, int[][] grid, int[][] visited){
        int rows = grid.length;
        int cols = grid[0].length;
        
        int currArea = 1;
        visited[row][col] = 1;
        
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{-1, 0, 1, 0};
        
        for(int i = 0; i < 4; i++){
            
            int nr = row + dx[i];
            int nc = col + dy[i];
            
            if(nr >=0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1 && visited[nr][nc] == 0) {
                currArea += dfs(nr, nc, grid, visited);
            }
            
        }
        
        return currArea;
    }
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] visited = new int[rows][cols];
        
        int maxArea = 0;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1){
                    int currArea = dfs(i, j, grid, visited);
                    maxArea = Math.max(currArea, maxArea);
                }
            }
        }
        
        return maxArea;
        
    }
}