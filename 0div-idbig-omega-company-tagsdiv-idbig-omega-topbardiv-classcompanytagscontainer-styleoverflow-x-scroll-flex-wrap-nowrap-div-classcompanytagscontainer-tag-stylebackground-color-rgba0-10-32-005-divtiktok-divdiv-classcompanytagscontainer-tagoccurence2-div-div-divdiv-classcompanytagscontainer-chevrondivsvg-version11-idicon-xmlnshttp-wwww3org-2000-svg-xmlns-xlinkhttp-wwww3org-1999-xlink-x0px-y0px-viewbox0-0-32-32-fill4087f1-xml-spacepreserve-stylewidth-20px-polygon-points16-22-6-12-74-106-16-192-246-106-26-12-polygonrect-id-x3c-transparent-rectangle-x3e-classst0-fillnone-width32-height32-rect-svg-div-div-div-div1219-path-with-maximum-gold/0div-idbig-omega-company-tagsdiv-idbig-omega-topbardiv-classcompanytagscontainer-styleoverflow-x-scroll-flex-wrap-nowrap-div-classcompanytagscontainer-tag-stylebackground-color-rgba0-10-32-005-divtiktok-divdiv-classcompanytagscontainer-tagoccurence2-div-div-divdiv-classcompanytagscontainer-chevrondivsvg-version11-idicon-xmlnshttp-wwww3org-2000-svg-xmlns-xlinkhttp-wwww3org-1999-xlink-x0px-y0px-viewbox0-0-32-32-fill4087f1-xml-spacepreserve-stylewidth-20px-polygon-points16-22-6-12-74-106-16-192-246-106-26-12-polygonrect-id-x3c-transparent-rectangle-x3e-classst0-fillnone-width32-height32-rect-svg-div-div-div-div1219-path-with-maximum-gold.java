//Approach - Using DFS
//T.C : O(m*n * 4^(cells with gold))
//S.C : O(cells with gold) - the length of a path through gold will contribute to the recursive call stack
class Solution {
   
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    private int DFS(int[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        if(i >= rows || i < 0 || j < 0 || j >= cols || grid[i][j] == 0)
            return 0; //zero gold
        
        int originalGoldValue = grid[i][j];
        grid[i][j] = 0;
        
        int maxGold = 0;
        for(int[] direction : directions) {
            
            int new_i = i + direction[0];
            int new_j = j + direction[1];
            
            maxGold = Math.max(maxGold, DFS(grid, new_i, new_j));
        }
        
        
        grid[i][j] = originalGoldValue;
        return maxGold + originalGoldValue;
        
    }
    public int getMaximumGold(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        
        int maxGold = 0;
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] != 0){
                    maxGold = Math.max(maxGold, DFS(grid, i, j));
                }
            }
        }
        
        return maxGold;
        
    }
}