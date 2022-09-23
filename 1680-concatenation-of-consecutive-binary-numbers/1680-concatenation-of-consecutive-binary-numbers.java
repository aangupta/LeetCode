class Solution {
    public int concatenatedBinary(int n) {
        
        int mod = (int)(1e9 + 7);
        
        int bitCount = 0;
        
        long result = 0;
        
        for(int i = 1; i <= n; i++) {
            
            bitCount = 1 + (int)(Math.log(i)/Math.log(2));
            result = (((result << bitCount) % mod) + i) % mod;
        }
        
        return (int)result;    
    }
    
    //TC O(n) Sc O(1)
}