class Solution {
    int mod = (int)1e9 + 7;
    
    private long countHousePlacementsUtils(int n, long[] dp) {
        //not placing any house
        if (n == 0) return 1;
        
        if (n == 1) return 2;
        
        if(dp[n] != -1) return dp[n];
        
        long placingTheHouseAtCurrentIndex = countHousePlacementsUtils(n-2, dp) %mod;
        
        long notPlacingTheHouseAtCurrentIndex = countHousePlacementsUtils(n-1, dp) % mod;
        
        return dp[n] = (placingTheHouseAtCurrentIndex + notPlacingTheHouseAtCurrentIndex) %mod;
        
        
    }
    public int countHousePlacements(int n) {
        
       long[] dp = new long[n+1];
       dp[0]=1; dp[1]=2;
        
       for(int i=2; i<n+1; ++i) {
            dp[i] = (dp[i-1] + dp[i-2])%mod;
        }
        return (int) (dp[n]*dp[n]%mod);
    }
}


/*f(i): number of ways of choosing houses from i plots such that no two houses are adjacent
if we choose the last plot(ith) for house, then we cannot choose the plot beside last plot(i.e. (i-1)th) so we are left to choose from first i-2 plots, therefore such number of ways would be f(i-2)
if we don't choose the last plot(ith) for house, then we can choose from first (i-1) choices, therefore such number of ways would be f(i-1)
Therefore

f(i) = f(i-2) // we choose ith plot for house
      + f(i-1) // we don't choose ith plot for house */