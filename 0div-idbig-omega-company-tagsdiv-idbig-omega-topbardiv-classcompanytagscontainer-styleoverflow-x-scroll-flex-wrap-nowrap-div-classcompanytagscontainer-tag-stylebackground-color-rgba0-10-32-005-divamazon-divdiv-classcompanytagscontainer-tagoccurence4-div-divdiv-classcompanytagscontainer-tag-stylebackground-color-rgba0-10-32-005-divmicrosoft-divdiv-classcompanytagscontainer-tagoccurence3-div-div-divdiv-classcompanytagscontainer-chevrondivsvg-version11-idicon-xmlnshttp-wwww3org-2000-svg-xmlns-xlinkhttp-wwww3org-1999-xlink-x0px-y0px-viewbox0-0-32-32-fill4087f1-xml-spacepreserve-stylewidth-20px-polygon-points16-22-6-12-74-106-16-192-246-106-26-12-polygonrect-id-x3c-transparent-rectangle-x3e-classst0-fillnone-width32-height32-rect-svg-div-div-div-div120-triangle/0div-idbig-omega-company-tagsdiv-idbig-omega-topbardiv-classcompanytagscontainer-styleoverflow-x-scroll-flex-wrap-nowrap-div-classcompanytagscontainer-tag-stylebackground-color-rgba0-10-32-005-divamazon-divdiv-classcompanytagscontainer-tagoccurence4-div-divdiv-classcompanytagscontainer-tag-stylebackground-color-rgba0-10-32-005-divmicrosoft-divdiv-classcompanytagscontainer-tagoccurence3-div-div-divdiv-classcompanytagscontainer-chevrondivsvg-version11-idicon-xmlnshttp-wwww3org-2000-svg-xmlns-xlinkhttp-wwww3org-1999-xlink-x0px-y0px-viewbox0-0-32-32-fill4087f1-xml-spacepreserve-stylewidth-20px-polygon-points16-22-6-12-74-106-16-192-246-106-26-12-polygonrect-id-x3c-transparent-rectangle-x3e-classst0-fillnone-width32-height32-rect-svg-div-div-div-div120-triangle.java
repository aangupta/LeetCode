class Solution {
    private int helper(int level, int index, List<List<Integer>> triangle, int[][] dp) {
        //base case
        if(level == triangle.size() - 1)
            return triangle.get(level).get(index);
        
        if(dp[level][index] != -1)
            return dp[level][index];
        
        int down = helper(level + 1, index, triangle, dp);
        int diagonal = helper(level + 1, index +1, triangle, dp);
        
        return dp[level][index] = triangle.get(level).get(index) + Math.min(down, diagonal);
        
        
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return helper(0,0, triangle, dp);
    }
}