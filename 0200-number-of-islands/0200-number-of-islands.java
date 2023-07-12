class Solution {
    
    int[] rowDir = new int[]{-1, 0, 1, 0};
    int[] colDir = new int[]{0, -1, 0, 1};
    
    private void dfs(char[][] grid, int currRow, int currCol){
        int nRows = grid.length;
        int nCols = grid[0].length;
        
        if(currRow < 0 || currRow >= nRows || currCol < 0 || currCol >= nCols || grid[currRow][currCol] == '0'){
            return;
        }
        
        grid[currRow][currCol] = '0';
        
        for(int i = 0; i < 4; i++){
            int newRow = currRow + rowDir[i];
            int newCol = currCol + colDir[i];
            dfs(grid, newRow, newCol);
        }
        return;
        
    }
    
    public int numIslands(char[][] grid) {
        int count = 0;
        int nRows = grid.length;
        int nCols = grid[0].length;
        
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        
        return count;
        
    }
}