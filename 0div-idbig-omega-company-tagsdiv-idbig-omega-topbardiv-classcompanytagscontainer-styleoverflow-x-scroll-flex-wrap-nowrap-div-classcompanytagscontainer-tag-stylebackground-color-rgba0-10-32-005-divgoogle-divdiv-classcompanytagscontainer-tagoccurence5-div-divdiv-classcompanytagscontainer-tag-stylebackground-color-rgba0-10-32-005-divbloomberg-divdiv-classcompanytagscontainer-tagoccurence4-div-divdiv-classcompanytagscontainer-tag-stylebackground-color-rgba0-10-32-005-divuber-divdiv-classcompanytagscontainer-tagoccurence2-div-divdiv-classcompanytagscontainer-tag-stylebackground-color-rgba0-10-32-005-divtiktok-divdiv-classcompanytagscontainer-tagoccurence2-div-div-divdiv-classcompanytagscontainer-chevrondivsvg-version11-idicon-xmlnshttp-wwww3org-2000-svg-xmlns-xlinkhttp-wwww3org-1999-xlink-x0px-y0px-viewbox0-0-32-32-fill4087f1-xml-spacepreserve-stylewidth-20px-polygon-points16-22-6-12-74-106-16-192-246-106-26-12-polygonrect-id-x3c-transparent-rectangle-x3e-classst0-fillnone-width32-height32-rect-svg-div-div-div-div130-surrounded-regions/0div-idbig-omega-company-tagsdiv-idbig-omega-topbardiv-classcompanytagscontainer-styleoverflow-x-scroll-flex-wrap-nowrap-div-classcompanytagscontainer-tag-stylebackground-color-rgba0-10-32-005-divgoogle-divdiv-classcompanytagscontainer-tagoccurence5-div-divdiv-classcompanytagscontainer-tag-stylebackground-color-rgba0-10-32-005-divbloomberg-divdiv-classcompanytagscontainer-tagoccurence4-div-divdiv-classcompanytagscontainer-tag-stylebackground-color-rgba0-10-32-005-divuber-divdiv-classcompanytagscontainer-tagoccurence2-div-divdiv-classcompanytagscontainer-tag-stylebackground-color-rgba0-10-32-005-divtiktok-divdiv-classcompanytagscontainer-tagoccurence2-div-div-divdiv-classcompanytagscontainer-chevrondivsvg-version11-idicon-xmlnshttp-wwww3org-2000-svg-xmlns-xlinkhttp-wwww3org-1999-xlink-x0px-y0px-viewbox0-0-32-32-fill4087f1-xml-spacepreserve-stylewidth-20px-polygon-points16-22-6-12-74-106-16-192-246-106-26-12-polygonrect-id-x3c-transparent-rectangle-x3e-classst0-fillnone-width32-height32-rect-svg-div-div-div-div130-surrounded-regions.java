class Solution {
    //The catch here is that if any 0 is connected to a boundary 0. i.e i =0 || j=0 || i=length-1 || j=length-1 that island will not be considered 
    //since that would mean that this 0 is not completely surrounded by X 
    int[] dx = new int[]{0, -1, 0, 1};
    int[] dy = new int[]{-1, 0, 1, 0};
    
    private void bfs(int row, int col, char[][] board, int[][] visited) {
        int rows = board.length;
        int cols = board[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        visited[row][col] = 1;
        
        while(queue.size() > 0) {
            int[] cell = queue.peek();
            queue.remove();
            
            for(int i = 0; i < 4; i++) {
                int nr = cell[0] + dx[i];
                int nc = cell[1] + dy[i];

                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols  && board[nr][nc] == 'O' && visited[nr][nc] == 0) {
                    visited[nr][nc] = 1;
                    queue.add(new int[]{nr, nc});
                }
                   
            }
        }
        
    }
    
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        int[][] visited = new int[rows][cols];
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++){
                if(i == 0 || i == rows -1 || j == 0 || j == cols -1){
                    if(board[i][j] == 'O' && visited[i][j] == 0)
                        bfs(i,j,board, visited);
                }
            }
        }
        
        //traverse to the board again and flip all the 0's which is not visited
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }  
        
    }
}