class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //mincost(i) = cost[i]+min(mincost(i-1), mincost(i-2))
        
        int n = cost.length;
        int[] dp = new int[n];
        
        dp[0] = cost[0];
        dp[1] = cost[1];
        
        for(int i = 2; i < n; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        
        return Math.min(dp[n-1], dp[n-2]);
       
    }
    
    private int minCostClimbingStairsHelper(int index, int[] cost, int[] dp){
        
        if(index < 0) return 0;
        
        if(index == 0 || index == 1) return cost[index];
        
        if(dp[index] != -1) return dp[index];
        
        return dp[index] = cost[index] + Math.min(minCostClimbingStairsHelper(index-1, cost, dp), minCostClimbingStairsHelper(index-2, cost, dp));
    }
}