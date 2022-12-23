class Solution {

    //Memoization
    private int cherryPickupUtil(int i, int j1, int j2, int nRows, int nCols, int[][]grid , int[][][] dp) {

        //base case
        if((j1 < 0 || j1 >= nCols) || (j2 <0 || j2 >= nCols))
            return (int)Math.pow(-10,9);
        
        if(i == nRows-1){
            if(j1 == j2)
                return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1)
            return dp[i][j1][j2];

        //generate all paths and find max
        
        int maxi = Integer.MIN_VALUE;
        for(int di = -1; di <= 1; di++) {
            for(int dj = -1; dj <=1; dj++) {
                int ans;
                if(j1 == j2)
                    ans = grid[i][j1] + cherryPickupUtil(i+1, j1+di, j2+dj , nRows, nCols, grid, dp);
                else 
                    ans = grid[i][j1] + grid[i][j2] + cherryPickupUtil(i+1, j1+di, j2+dj , nRows, nCols, grid, dp);
                
                maxi = Math.max(maxi, ans);
            }
        }

        return dp[i][j1][j2] = maxi;

    }
    public int cherryPickup(int[][] grid) {
        int nRows = grid.length;
        int nCols = grid[0].length;

        int[][][] dp = new int[nRows][nCols][nCols];

        for(int row1[][] : dp){
            for(int row2[] : row1){
                Arrays.fill(row2, -1);
            }
        }

        //Tabulation

        //base case
        for(int j1 =0; j1 < nCols ; j1++){
            for(int j2 = 0; j2 <nCols ;j2++){
                if(j1 == j2)
                    dp[nRows-1][j1][j2] = grid[nRows-1][j1];
                else 
                    dp[nRows-1][j1][j2] = grid[nRows-1][j1] + grid[nRows-1][j2];
            }
        }

        for(int i = nRows-2; i >=0; i--){
            for(int j1 =0; j1 < nCols; j1++){
                for(int j2 = 0; j2 < nCols; j2++){
                    int max = Integer.MIN_VALUE;

                    for(int di = -1; di <=1; di++){
                        for(int dj = -1; dj<= 1; dj++){
                            int ans;

                            if(j1 == j2)
                                ans = grid[i][j1];
                            else 
                                ans = grid[i][j1] + grid[i][j2];

                            if((j1 + di < 0 || j1 + di >= nCols) || (j2 + dj < 0 || j2 + dj >= nCols))
                                ans += (int)Math.pow(-10, 9);
                            else ans += dp[i+1][j1+di][j2+dj];

                            max = Math.max(ans, max);
                        }
                    }

                    dp[i][j1][j2] = max;

                }

            }

        }

        return dp[0][0][nCols-1];
        
    }
}