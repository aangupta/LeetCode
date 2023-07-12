class Pair {
    int row;
    int col;
    
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    
    int[] rowDir = new int[]{-1, 0, 1, 0};
    int[] colDir = new int[]{0, -1, 0, 1};
    
    private void bfs(char[][] grid, int row, int col){
        int nRows = grid.length;
        int nCols = grid[0].length;
        
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(row, col));
        grid[row][col] = '0';
        
        while(queue.size() > 0){
            Pair pair = queue.peek();
            queue.remove();
            
            int currRow = pair.row;
            int currCol = pair.col;
            
            for(int i = 0; i < 4; i++){
                
                int newRow = currRow + rowDir[i];
                int newCol = currCol + colDir[i];
                
                 if(newRow >= 0 && newRow < nRows && newCol >= 0 && newCol < nCols && grid[newRow][newCol] == '1'){
                     grid[newRow][newCol] = '0';
                     queue.add(new Pair(newRow, newCol));
                 }
            }
            
            
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
                    bfs(grid, i, j);
                }
            }
        }
        
        return count;
        
    }
}