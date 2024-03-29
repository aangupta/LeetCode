class Solution {
    
    private int helper(int n, int[] dp) {
        
        if(n <= 2) {
            dp[n] = n;
            return n;
        }
        
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = helper(n-1, dp) + helper(n-2, dp);
        
    }
    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];
        for(int i = 0; i <= n; i++)
            dp[i] = -1;
        
        return helper(n, dp);
        
    }
}