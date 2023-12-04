class Solution {
    /* 
     * Recursion (Bottom Up)- Include/Exclude Method
     * TC = O(n)
     * SC = O(n)
    */
 
    public int rob(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        dp[0] = nums[0];
        
        
        for(int i = 1; i < n; i++) {
            
            //robbing the current house
            int rob = (i >= 2 ? dp[i-2] : 0) + nums[i];
            
            //not robbing the current house
            int notRob = dp[i-1];
            
            dp[i] = Math.max(rob, notRob);
        }
        
        return dp[n-1];
        
    }
}