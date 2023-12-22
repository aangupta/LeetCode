class Solution {
    //The catch here is that if the island of 0's is connected to a boundary 0. i.e i =0 || j=0 || i=length-1 || j=length-1 that island will not be considered 
    //since that would mean that this island is not completely surrounded by water i.e 1's on all sides.
    
    
    int[] dx = new int[]{0, -1, 0, 1};
    int[] dy = new int[]{-1, 0, 1, 0};
    
    private void dfs(int row, int col, int[][] grid, int[][] visited) {
        
        int nRows = grid.length;
        int nCols = grid[0].length;
        
        visited[row][col] = 1;
        
        for(int i = 0; i < 4; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];
            
            if(newRow >= 0 && newRow < nRows && newCol >= 0 && newCol < nCols && grid[newRow][newCol] == 0 && visited[newRow][newCol] == 0)
                dfs(newRow, newCol, grid, visited);
        }
        
    }
    public int closedIsland(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;
        
        int[][] visited = new int[nRows][nCols];
        
        //marking all boundary land and its connected cell as visited, because it will not contribute to the closed island
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++) {
                if(i == 0 || i == nRows-1 || j == 0 || j == nCols-1) { //boundary lands
                    if(grid[i][j] == 0 && visited[i][j] == 0){
                        dfs(i,j,grid,visited);
                    }
                }
            }
        }
        
        
        int count = 0;
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++) {
                if(grid[i][j] == 0 && visited[i][j] == 0){
                    count++; //new closed island
                    dfs(i,j,grid,visited);
                }
            }
        }
        
        return count;
        
    }
}