class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //mincost(i) = cost[i]+min(mincost(i-1), mincost(i-2))
        
        int n = cost.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(minCostClimbingStairsHelper(n-1, cost, dp), minCostClimbingStairsHelper(n-2, cost, dp));
    }
    
    private int minCostClimbingStairsHelper(int index, int[] cost, int[] dp){
        
        if(index < 0) return 0;
        
        if(index == 0 || index == 1) return cost[index];
        
        if(dp[index] != -1) return dp[index];
        
        return dp[index] = cost[index] + Math.min(minCostClimbingStairsHelper(index-1, cost, dp), minCostClimbingStairsHelper(index-2, cost, dp));
    }
}