class Solution {
    public boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();
        
        int j = 0;
        
        for(int i =0; i < n && j < m ; i++){
            if(t.charAt(i) == s.charAt(j))
                j++;
        }
        
        return (j == m);
    }
}