class Solution {
    private int minimumTotalUtils(int level, int index, List<List<Integer>> triangle,  int[][] dp) {
        if(level == triangle.size())
            return 0;
        if(level == triangle.size()-1)
            return triangle.get(level).get(index);
        
        if(dp[level][index] != -1)
            return dp[level][index];
        
        int down = minimumTotalUtils(level + 1, index, triangle, dp);
        int diagonal = minimumTotalUtils(level + 1, index + 1, triangle, dp);
        
        return dp[level][index] = triangle.get(level).get(index) + Math.min(down, diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for(int i = 0; i < n; i++)
            dp[n-1][i] = triangle.get(n-1).get(i);
        
        for(int level = n-2; level >= 0; level--) {
            for(int index = 0; index <= level; index++) {
                int up = triangle.get(level).get(index) + dp[level + 1][index];
                int diagonal = triangle.get(level).get(index) + dp[level + 1][index + 1];
                
                dp[level][index] = Math.min(up, diagonal);
            }
        }
        
        return dp[0][0];
    }
}