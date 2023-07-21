class Pair {
    int row, col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        int[][] visited = new int[rows][cols];
        
        Queue<Pair> queue = new LinkedList<>();
        
        //adding all the 0's at boundary as starting point of the BFS traversal
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(i == 0 || i == rows-1 || j == 0 || j == cols-1){
                    if(board[i][j] == 'O'){
                        queue.add(new Pair(i,j));
                        visited[i][j] = 1;
                    }
                }
            }
        }
        
        
        int[] dx = new int[]{0, -1, 0, 1};
        int[] dy = new int[]{-1, 0, 1, 0};
        
        //do a BFS traversal and mark all the nodes adjacent to boundary 0's as visited
        while(queue.size() > 0){
            int row = queue.peek().row;
            int col = queue.peek().col;
            
            queue.remove();
            
            for(int i = 0; i < 4; i++) { 
                int nr = row + dx[i];
                int nc = col + dy[i];
                
                
                if(nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == 'O' && visited[nr][nc] == 0){
                    queue.add(new Pair(nr, nc));
                    visited[nr][nc] = 1;
                }
            }
        }
        
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O' && visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
        
        
        
        
        
    }
}