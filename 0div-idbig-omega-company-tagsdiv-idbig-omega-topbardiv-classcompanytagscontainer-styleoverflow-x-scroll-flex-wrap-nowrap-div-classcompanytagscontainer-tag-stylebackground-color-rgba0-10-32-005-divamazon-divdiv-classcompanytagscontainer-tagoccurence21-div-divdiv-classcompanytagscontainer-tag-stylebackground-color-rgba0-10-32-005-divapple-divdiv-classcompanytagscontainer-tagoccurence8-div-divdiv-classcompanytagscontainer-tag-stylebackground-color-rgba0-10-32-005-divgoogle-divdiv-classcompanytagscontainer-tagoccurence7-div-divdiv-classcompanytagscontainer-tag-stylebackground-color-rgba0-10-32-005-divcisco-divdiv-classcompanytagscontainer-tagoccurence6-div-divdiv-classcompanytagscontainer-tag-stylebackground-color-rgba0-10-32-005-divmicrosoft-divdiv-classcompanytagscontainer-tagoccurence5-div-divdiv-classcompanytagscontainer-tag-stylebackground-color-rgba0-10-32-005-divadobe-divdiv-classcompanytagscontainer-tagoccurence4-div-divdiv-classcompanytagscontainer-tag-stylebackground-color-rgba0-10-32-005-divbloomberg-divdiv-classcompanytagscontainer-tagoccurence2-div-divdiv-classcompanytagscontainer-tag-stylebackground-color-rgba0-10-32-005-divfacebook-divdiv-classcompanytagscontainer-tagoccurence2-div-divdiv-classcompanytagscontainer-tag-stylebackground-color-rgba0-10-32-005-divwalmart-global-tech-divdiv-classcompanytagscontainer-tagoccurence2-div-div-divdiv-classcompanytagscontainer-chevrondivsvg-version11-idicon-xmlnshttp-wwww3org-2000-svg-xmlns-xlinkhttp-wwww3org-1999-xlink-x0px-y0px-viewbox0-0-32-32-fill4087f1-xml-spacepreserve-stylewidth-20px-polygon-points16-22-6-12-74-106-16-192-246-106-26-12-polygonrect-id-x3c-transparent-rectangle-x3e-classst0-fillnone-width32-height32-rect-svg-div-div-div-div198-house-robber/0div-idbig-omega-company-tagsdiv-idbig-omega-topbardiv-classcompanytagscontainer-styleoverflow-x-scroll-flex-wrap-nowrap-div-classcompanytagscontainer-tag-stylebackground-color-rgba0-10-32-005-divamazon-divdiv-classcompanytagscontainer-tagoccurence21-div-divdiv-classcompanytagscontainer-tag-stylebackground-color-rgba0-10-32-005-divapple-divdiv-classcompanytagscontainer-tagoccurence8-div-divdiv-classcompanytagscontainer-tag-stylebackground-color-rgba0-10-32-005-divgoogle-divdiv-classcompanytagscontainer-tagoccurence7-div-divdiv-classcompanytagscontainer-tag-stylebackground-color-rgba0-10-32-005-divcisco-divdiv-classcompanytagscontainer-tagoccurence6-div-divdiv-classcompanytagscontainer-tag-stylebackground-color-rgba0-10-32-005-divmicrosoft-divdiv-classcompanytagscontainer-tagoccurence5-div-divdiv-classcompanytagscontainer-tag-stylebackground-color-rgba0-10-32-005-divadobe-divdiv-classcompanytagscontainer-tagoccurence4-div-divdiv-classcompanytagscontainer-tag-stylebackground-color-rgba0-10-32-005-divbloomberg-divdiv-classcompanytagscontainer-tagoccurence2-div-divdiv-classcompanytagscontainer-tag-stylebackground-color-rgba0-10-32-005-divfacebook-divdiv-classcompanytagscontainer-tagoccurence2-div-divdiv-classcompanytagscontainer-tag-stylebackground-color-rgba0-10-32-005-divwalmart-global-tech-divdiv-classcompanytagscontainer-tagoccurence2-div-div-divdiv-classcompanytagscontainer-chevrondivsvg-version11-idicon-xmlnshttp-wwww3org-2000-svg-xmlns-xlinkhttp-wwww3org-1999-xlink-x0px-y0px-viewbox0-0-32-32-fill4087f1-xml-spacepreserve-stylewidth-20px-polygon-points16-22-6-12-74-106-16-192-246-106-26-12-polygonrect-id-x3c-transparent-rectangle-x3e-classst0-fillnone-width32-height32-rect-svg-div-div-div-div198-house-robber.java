class Solution {
    /* 
     * Recursion (Memoization)- Include/Exclude Method
     * TC = O(2^n)
     * SC = O(n)
    */
    private int helper(int ind, int[] nums, int[] dp) {
        
        //base case
        if(ind == 0) return nums[0];
        
        if(ind < 0) return 0;
        
        if(dp[ind] != -1) 
            return dp[ind];
        
        //robbing the current house
        int rob = nums[ind] + helper(ind -2 , nums, dp);
        
        //not robbing the current house
        int notRob = helper(ind - 1, nums, dp);
        
        return dp[ind] = Math.max(rob, notRob);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(n-1, nums, dp);
        
    }
}