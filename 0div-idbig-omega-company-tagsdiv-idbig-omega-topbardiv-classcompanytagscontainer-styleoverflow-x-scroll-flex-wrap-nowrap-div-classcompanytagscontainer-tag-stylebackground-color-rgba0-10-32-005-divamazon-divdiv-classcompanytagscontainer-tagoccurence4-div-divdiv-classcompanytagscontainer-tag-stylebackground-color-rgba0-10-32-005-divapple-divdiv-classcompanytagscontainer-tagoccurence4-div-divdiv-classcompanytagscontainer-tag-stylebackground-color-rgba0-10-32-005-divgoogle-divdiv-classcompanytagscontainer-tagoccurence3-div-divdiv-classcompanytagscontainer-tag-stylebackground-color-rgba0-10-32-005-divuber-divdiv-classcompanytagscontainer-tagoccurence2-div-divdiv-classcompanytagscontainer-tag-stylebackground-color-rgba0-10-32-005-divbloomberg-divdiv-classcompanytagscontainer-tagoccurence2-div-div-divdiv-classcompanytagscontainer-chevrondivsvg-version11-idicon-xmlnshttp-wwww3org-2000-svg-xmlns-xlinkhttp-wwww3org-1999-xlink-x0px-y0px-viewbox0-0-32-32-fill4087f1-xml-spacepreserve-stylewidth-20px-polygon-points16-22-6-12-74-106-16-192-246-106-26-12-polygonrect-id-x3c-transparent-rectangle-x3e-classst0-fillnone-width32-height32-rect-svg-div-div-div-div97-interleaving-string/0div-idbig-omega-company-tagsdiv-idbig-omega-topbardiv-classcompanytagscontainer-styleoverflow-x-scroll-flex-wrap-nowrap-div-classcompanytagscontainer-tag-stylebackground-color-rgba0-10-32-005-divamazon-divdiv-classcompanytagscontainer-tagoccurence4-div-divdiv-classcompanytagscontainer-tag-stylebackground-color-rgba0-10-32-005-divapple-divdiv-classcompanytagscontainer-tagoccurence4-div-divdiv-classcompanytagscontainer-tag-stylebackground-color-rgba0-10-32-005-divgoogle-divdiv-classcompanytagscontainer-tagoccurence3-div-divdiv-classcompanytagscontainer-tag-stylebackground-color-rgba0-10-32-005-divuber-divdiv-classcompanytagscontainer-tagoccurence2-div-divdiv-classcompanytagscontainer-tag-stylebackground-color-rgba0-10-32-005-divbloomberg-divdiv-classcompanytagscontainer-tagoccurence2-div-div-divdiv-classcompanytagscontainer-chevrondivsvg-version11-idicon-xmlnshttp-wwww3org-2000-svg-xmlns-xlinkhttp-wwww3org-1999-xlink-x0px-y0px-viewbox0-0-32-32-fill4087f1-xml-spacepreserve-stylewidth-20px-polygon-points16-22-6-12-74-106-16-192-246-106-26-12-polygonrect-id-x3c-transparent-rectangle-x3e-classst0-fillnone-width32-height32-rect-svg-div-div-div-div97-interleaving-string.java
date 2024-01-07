class Solution {
 
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int l = s3.length();
        
        if(n== 0 && m == 0 && l == 0) return true;
        
        //if length of s1 + s2 is not equal to length of s3
        if(n+m != l) return false;
        
        //dp[i][j] = true; //means, s1[0..i] and s2[0...j] interleaves with s3 till (i+j)
        boolean[][] dp = new boolean[n+1][m+1];
        
        for(int i = 0; i < n+1; i++) {
            for(int j = 0; j < m+1; j++)
                dp[i][j] = false;
        }
        
        //length of s1 = 0, s2 = 0 and s3 = 0 + 0, i.e. 0 . so this will always be true
        dp[0][0] = true;
        
        //When s1 is of 0 length, we can interleave only when s2 forms s3
        for(int i = 1; i < m+1; i++) {
            dp[0][i] = (s2.charAt(i-1) == s3.charAt(i-1) ? dp[0][i-1] : false);
        }
        
         //When s2 is of 0 length, we can interleave only when s1 forms s3
        for(int i = 1; i < n+1; i++) {
            dp[i][0] = (s1.charAt(i-1) == s3.charAt(i-1) ? dp[i-1][0] : false);
        }
        
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m + 1; j++) {
                int k = i + j - 1;  //length s1 = 1, s2 = j, s3 = i + j ..
                
                if(s1.charAt(i-1) == s3.charAt(k)) 
                    dp[i][j] = dp[i-1][j];
                
                if(s2.charAt(j-1) == s3.charAt(k))
                     dp[i][j] = dp[i][j] || dp[i][j-1];
            }
        }
        
        return dp[n][m];
    }
}