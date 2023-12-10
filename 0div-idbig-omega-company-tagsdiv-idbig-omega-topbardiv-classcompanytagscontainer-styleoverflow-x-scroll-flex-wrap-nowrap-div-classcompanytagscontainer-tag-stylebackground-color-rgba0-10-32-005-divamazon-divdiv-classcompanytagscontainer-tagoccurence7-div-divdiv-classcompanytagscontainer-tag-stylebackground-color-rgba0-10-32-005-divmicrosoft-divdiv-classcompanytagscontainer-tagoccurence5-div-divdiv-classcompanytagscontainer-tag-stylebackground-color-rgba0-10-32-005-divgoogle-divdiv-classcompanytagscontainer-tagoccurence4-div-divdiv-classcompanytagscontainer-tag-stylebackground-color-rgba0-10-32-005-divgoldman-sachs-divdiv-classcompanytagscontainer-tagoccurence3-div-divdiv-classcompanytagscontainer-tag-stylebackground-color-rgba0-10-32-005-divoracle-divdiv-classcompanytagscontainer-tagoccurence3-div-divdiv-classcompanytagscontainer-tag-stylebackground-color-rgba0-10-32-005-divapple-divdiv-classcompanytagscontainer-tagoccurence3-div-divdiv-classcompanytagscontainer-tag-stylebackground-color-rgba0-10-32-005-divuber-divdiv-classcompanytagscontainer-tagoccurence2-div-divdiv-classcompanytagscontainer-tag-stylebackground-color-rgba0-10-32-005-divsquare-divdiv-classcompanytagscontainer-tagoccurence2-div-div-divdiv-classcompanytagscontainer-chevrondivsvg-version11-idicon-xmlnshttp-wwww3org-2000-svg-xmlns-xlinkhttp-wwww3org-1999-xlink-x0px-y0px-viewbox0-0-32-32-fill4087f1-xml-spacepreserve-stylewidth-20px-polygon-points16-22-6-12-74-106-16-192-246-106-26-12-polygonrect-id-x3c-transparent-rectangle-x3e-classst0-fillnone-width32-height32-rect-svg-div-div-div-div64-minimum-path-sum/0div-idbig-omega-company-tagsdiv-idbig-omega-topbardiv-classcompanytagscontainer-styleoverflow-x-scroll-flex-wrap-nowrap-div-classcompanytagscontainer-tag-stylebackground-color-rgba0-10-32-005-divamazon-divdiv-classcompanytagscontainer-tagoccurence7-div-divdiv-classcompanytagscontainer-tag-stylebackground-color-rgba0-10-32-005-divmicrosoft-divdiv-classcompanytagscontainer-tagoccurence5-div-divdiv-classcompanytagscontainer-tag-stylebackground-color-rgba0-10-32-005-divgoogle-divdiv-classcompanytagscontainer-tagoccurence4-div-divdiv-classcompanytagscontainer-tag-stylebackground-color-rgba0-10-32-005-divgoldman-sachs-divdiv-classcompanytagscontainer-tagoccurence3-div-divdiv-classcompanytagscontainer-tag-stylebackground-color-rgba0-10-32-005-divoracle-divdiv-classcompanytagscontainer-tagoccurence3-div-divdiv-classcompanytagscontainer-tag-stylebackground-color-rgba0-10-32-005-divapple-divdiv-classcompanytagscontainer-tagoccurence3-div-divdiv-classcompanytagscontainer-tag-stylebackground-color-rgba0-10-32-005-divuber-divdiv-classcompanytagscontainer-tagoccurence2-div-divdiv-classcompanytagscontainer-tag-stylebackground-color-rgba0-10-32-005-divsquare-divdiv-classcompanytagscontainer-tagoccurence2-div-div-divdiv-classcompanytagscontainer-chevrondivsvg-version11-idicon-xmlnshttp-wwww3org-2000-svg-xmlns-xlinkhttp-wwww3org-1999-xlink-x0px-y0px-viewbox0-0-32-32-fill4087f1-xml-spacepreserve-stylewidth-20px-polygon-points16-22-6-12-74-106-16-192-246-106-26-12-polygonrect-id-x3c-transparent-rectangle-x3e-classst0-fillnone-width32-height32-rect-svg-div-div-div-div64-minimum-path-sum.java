class Solution {
    /*Memoization*/
    private int helper(int row, int col, int[][] grid, int[][] path) {
        //base case
        if(row < 0 || col < 0) return Integer.MAX_VALUE;
        
        if(row == 0 && col == 0) return grid[0][0];
        
        if(path[row][col] != -1)
            return path[row][col];
            
        
        int up = Integer.MAX_VALUE;
        if(row - 1 >= 0)
            up = Math.min(up, helper(row - 1, col, grid, path));
        
        int left = Integer.MAX_VALUE;
        if(col - 1 >= 0)
            left = Math.min(left, helper(row, col-1, grid,path));
        
        return path[row][col] = grid[row][col] + Math.min(up, left);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] path = new int[m][n];
        for(int[] row : path){
            Arrays.fill(row, -1);
        }
        
        return helper(m-1, n-1, grid, path);
    }
}