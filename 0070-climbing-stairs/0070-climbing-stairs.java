class Solution {
    public int climbStairs(int n) {
    
        int prev2 = 1;
        int prev1 = 1;
        int curr_i = 0;
        
        for(int i = 2; i <= n; i++){
            curr_i = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr_i;
        }
        
        return prev1;
        
    }
}