class Solution {
    private int calculateMinimumHPUtils(int row , int col, int[][] dungeon,  int[][] dp) {
        
        // Base case : we have crossed the matrix, ie. out of bound
        if(row >= dungeon.length || col >= dungeon[0].length)  return Integer.MAX_VALUE;
        
        //we have reached our destination 
        //if cell value is +ve, which means knight will not require any additional health to rescue the princess so return 1
        //if cell value is -ve, which means knight will require atleast abs(dungeon[row][col]) + 1 to rescue the princess
        if(row == dungeon.length-1 && col == dungeon[0].length - 1)
            return (dungeon[row][col] <= 0) ? -dungeon[row][col] + 1 : 1;
        
        if(dp[row][col] !=  Integer.MAX_VALUE)
            return dp[row][col];
        
        //try all possible paths i.e right and down
        int down = calculateMinimumHPUtils(row + 1, col, dungeon, dp);
        int right = calculateMinimumHPUtils(row, col + 1 , dungeon, dp);
        
        //suppose we want to enter in [row][col] cell , 
        //we need two information before making any decision i.e entering [row][col] is better from [row][col+1] or from [row+1][col] ?
        //which ever is having min min_health requirement will be preferred 
        int minHealthRequired = Math.min(down, right);
        
        //now knight need to fight in cell  [row][col] so he will either loose or gain health acc.to cell  [row][col] val is +ve or -ve.
        minHealthRequired = minHealthRequired - dungeon[row][col];
        
        //if any point the health value of the knight is <= 0, he will die so return 1 in that case otherwise return the computed minHealthRequired
        return dp[row][col] = (minHealthRequired <= 0 ? 1 : minHealthRequired);
        
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int rows = dungeon.length;
        int cols = dungeon[0].length;
        
        int[][] dp = new int[rows][cols];
        
        for(int[] temp : dp)
            Arrays.fill(temp,Integer.MAX_VALUE);
        
        return calculateMinimumHPUtils(0, 0, dungeon, dp);
    }
}