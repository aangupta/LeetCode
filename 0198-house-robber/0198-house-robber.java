class Solution {
    private int maximumSum(int index, int n, int[] nums, int[] dp){
        
        if(index == 0) return nums[0];
        
        if(index < 0) return 0;
        
        if(dp[index] != -1) return dp[index];
        
        int robTheCurrentHouse = nums[index] + maximumSum(index-2, n, nums, dp);
        int notRobTheCurrentHouse = maximumSum(index-1, n, nums, dp);
        
        return dp[index] = Math.max(robTheCurrentHouse, notRobTheCurrentHouse);
        
    }
    public int rob(int[] nums) {
        int n = nums.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        return maximumSum(n-1, n, nums, dp);
        
    }
}