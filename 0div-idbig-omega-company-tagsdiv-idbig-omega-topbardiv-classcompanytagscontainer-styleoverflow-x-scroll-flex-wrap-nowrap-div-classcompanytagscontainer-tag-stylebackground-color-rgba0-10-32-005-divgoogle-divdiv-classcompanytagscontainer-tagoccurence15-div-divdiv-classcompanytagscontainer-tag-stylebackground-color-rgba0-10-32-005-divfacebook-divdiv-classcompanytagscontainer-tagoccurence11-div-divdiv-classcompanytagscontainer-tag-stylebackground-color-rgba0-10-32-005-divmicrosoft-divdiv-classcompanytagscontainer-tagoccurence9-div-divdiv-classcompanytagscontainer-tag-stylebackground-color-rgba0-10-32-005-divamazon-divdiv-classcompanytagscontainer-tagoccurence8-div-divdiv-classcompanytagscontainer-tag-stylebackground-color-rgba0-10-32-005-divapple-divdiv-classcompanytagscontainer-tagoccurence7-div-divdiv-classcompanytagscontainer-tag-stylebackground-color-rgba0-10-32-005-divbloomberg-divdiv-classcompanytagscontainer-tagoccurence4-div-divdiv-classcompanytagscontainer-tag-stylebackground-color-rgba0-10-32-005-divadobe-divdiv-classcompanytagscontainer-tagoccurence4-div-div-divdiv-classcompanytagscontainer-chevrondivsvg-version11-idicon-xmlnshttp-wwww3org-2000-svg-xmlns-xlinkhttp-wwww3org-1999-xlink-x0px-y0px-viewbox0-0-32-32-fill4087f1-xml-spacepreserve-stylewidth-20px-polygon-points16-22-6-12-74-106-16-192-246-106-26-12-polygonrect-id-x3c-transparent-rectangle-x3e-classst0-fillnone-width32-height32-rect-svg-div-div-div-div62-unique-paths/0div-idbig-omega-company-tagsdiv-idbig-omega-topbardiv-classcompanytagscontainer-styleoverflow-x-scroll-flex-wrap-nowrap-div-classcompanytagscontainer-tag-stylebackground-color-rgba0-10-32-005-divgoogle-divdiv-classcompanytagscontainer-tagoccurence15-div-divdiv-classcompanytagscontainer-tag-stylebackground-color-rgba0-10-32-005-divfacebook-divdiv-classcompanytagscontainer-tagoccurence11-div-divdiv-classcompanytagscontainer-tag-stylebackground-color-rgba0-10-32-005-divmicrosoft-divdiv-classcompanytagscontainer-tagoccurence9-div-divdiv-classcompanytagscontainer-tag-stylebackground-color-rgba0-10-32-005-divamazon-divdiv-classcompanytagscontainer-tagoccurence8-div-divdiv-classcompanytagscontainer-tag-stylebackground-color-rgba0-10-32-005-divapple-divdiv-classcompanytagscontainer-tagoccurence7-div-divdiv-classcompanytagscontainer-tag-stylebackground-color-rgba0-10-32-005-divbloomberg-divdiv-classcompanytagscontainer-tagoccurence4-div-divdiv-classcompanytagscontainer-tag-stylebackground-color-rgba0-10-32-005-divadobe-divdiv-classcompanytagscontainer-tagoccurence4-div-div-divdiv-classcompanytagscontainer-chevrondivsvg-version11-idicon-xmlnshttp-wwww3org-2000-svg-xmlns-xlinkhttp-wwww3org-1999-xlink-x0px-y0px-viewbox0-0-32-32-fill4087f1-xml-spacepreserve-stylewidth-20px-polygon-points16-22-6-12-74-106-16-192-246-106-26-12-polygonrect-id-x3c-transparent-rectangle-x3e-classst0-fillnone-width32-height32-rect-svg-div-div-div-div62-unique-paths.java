class Solution {
    
    /*Recursive Approach +  Memoization */
    private int helper(int row, int col, int[][] dp) {
        
        //base case
        if(row < 0 || col < 0) 
            return 0;
        
        if(row == 0 && col == 0)
            return 1;
        
        if(dp[row][col] != -1)
            return dp[row][col];
        
        int up = helper(row-1, col, dp);
        int left = helper(row, col-1, dp);
        
        return dp[row][col] = up + left;
        
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        
        for (int[] row : dp)
            Arrays.fill(row, -1);
        
        return helper(m-1, n-1, dp);
    }
}