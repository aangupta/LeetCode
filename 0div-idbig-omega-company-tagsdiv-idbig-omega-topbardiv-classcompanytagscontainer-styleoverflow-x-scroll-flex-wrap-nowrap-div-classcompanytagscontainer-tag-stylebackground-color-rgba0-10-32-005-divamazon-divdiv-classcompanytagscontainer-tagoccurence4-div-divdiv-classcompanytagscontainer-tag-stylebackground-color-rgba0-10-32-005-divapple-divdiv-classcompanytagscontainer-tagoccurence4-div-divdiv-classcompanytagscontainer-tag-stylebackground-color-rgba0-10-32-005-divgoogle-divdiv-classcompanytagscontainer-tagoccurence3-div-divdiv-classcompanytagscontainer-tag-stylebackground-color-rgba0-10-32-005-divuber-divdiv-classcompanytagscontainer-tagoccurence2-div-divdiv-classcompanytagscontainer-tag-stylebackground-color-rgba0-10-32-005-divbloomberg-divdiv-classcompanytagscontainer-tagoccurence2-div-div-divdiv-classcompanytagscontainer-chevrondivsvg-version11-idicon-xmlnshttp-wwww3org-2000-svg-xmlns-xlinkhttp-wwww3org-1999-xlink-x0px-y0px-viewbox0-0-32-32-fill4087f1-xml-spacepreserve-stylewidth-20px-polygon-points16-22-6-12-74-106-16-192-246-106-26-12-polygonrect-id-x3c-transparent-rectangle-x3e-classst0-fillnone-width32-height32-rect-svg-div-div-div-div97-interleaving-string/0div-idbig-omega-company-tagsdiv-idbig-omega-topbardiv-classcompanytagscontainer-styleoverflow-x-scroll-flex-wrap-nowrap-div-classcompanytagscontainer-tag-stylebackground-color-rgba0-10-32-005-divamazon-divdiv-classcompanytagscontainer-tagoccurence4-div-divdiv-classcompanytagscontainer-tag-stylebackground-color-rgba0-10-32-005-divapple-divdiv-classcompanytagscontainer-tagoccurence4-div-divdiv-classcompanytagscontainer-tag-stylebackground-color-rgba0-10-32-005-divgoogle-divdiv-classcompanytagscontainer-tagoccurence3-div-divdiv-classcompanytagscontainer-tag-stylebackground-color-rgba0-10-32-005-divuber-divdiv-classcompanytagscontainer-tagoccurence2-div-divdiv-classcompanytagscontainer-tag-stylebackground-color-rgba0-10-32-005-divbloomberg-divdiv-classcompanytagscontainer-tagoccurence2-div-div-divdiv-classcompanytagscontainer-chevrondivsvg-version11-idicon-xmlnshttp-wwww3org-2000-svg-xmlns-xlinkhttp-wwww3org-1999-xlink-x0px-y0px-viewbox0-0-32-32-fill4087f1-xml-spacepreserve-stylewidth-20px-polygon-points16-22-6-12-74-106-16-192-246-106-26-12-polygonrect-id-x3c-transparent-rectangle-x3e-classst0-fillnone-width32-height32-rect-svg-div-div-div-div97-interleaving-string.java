class Solution {
    //Recursive Approach + Memoization
    private boolean isInterleaveUtils(String s1, int idx1, String s2, int idx2, String s3, int idx3, Boolean[][] dp) {
        if(idx1 == s1.length()-1 && idx2 == s2.length()-1 && idx3 == s3.length()-1)
            return true;
        
        //s1 reached the limit, check if remaning characters of s2 matches with the remaning characters of s3 
        if(idx1 >= s1.length()) return s2.substring(idx2).equals(s3.substring(idx3));
        
        //s2 reached the limit, check if remaning characters of s1 matches with the remaning characters of s3 
        if(idx2 >= s2.length()) return s1.substring(idx1).equals(s3.substring(idx3));
        
        if(dp[idx1][idx2] != null){
            return dp[idx1][idx2];
        }
        
        boolean ans = false;
        
        if(s1.charAt(idx1) == s3.charAt(idx3)) 
           ans = isInterleaveUtils(s1, idx1+1, s2, idx2, s3, idx3+1, dp);
        
          
        if(s2.charAt(idx2) == s3.charAt(idx3)) 
            ans = ans || isInterleaveUtils(s1, idx1, s2, idx2+1, s3, idx3+1, dp);
        
        return dp[idx1][idx2] = ans;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length();
        int m = s2.length();
        int k = s3.length();
        
        if(n== 0 && m == 0 && k == 0) return true;
        
        //if length of s1 + s2 is not equal to length of s3
        if(n+m != k) return false;
        
        //defalut value is null
        Boolean[][] dp = new Boolean[s1.length()][s2.length()];
        
        
        return isInterleaveUtils(s1,0,s2,0,s3,0, dp);
        
    }
}