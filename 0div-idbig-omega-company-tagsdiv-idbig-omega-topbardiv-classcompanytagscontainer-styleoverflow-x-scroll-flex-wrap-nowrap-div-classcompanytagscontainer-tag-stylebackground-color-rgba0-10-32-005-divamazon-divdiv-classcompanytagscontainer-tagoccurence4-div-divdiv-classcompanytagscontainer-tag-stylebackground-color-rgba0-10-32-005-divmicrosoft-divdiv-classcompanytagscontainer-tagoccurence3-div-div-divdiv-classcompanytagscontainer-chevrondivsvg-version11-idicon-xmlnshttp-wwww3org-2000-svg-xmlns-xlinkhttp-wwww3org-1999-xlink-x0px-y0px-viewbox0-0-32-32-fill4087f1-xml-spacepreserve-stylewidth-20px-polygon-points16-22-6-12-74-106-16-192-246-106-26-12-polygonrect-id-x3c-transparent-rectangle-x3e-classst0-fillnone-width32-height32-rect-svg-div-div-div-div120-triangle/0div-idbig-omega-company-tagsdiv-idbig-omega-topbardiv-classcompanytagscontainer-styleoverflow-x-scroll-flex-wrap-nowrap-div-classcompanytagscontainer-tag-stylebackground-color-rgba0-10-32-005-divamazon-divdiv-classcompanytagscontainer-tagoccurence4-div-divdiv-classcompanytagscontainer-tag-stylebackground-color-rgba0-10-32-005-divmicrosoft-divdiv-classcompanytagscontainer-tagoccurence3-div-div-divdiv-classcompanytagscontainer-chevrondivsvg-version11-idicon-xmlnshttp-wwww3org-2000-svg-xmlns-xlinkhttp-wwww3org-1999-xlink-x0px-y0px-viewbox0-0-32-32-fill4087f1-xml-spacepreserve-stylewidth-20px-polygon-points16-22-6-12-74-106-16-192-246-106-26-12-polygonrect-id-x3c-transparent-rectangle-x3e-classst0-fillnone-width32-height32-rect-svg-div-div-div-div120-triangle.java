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
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return minimumTotalUtils(0,0,triangle, dp);
    }
}