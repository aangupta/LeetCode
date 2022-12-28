class Solution {
    //Memoization TC O(n) SC O(n) + O(n) ~ DP array + recurivestack space
    private int maximumSum(int index, int n, int[] nums, int[] dp){
        
        if(index == 0) return nums[0];
        
        if(index < 0) return 0;
        
        if(dp[index] != -1) return dp[index];
        
        //robbing the current house
        int robTheCurrentHouse = nums[index] + maximumSum(index-2, n, nums, dp);
        //not robbing the current house
        int notRobTheCurrentHouse = maximumSum(index-1, n, nums, dp);
        
        return dp[index] = Math.max(robTheCurrentHouse, notRobTheCurrentHouse);
        
    }
    public int rob(int[] nums) {
        //Tabulation
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        
        dp[0] = nums[0];
        
        for(int i = 1; i < n; i++){
            //robbing the current house
            int robTheCurrentHouse = nums[i];
            if(i > 1)
                robTheCurrentHouse+= dp[i-2];
            //not robbing the current house
            int notRobTheCurrentHouse = dp[i-1];
            
            dp[i] = Math.max(robTheCurrentHouse, notRobTheCurrentHouse);
            
        }
        
        return dp[n-1];
        
    }
}

//Memoization TC O(n) SC O(n) + O(n) ~ DP array + recurivestack space
//Tabulation TC O(n) SC O(n) ~ DP array

