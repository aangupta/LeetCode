class Node {
    int row;
    int col;
    
    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    
    private boolean isBoundaryNode(int row, int col, int[][] grid){
        
        if(row == 0 || row == grid.length-1 || col == 0 || col == grid[0].length-1)
            return true;
        else 
            return false;
    }
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] visited = new int[rows][cols];
        
        Queue<Node> queue = new LinkedList<>();
        
        //adding all the boundary nodes having 1 value
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(isBoundaryNode(i,j,grid) == true && grid[i][j] == 1){
                    queue.add(new Node(i,j));
                    visited[i][j] = 1;
                }
            }
        }
        
       // System.out.println(queue.size());
        
        int[] dx = new int[]{0,-1,0,1};
        int[] dy = new int[]{-1,0,1,0};
        
        
        //BFS traversal (marking all the adjacent to the boundary elements)
        
        while(queue.size() > 0){
            int row = queue.peek().row;
            int col = queue.peek().col;
            
            queue.remove();
            
            for(int i = 0; i < 4; i++){
                int nr = row + dx[i];
                int nc = col + dy[i];
                
                if(nr >= 0 && nr < rows && nc >=0 && nc < cols && grid[nr][nc] == 1 && visited[nr][nc] == 0){
                    queue.add(new Node(nr,nc));
                    visited[nr][nc] = 1;
                }
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    count++;
                }
            }
        }
        
        return count;
    }
}