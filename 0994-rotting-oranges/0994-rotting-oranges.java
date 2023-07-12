class Pair {
    int row, col,time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        
        if(grid == null || grid.length == 0) return 0;
        
        int countOfFreshOranges = 0;
        int nRows = grid.length;
        int nCols = grid[0].length;
        
        int[][] visited = new int[nRows][nCols];
        Queue<Pair> queue = new LinkedList<>();
        
        for(int i = 0; i < nRows; i++){
            for(int j = 0; j < nCols; j++){
                if(grid[i][j] == 2){
                    queue.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } 
                else {
                   visited[i][j] = 0; 
                }
                
                if(grid[i][j] == 1){
                    countOfFreshOranges++;
                }
            }
        }
        
        int maxTime = 0;
        int count = 0; //no of oranges rotten by us
        
        int[] dx = new int[]{0,-1,0,1};
        int[] dy = new int[]{-1,0,1,0};
        
        while(queue.size() > 0){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int time = queue.peek().time;
            
            queue.remove();
            
            maxTime = Math.max(time, maxTime);
            
            for(int i = 0; i < 4; i++){
                int nRow = row + dx[i];
                int nCol = col + dy[i];
                
                if(nRow >=0 && nRow < nRows && nCol >= 0 && nCol < nCols && visited[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                    visited[nRow][nCol] = 2;
                    queue.add(new Pair(nRow, nCol, time+1));
                    count++;
                }
            }
        }
        
        return (count != countOfFreshOranges ? -1 : maxTime);
        
        
    }
}