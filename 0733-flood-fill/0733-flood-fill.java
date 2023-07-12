class Pair {
    int row,col;
    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
class Solution {
    
    int[] rowDir = new int[]{0, -1, 0, 1};
    int[] colDir = new int[]{-1, 0, 1, 0};
    
    private void bfs(int[][] image, int sr, int sc, int oldColor, int newColor){
        
        int nRows = image.length;
        int nCols = image[0].length;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        image[sr][sc] = newColor;
        
        while(queue.size() > 0) {
            Pair pair = queue.peek();
            queue.remove();
            
            int currRow = pair.row;
            int currCol = pair.col;
            
            for(int i = 0; i < 4; i++){
                
                int newRow = currRow + rowDir[i];
                int newCol = currCol + colDir[i];
                
                if(newRow >= 0 && newRow < nRows && newCol >=0 && newCol < nCols && image[newRow][newCol] == oldColor){
                    image[newRow][newCol] = newColor;
                    queue.add(new Pair(newRow, newCol));
                }
            }
            
        }
        return;
        
    }
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        if(image[sr][sc] == color) return image;
        
        int oldColor = image[sr][sc];
        
        bfs(image, sr, sc, oldColor, color);
        
        return image;
        
    }
}