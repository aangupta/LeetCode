class Solution {
    public int nthUglyNumber(int n) {
        int[] uglyNumber = new int[n+1];
        
        int i2 = 1, i3 = 1, i5 = 1;
        
        uglyNumber[1] = 1;
        
        for(int i = 2; i <= n; i++) {
            
            int i2_ugly = uglyNumber[i2] * 2;
            
            int i3_ugly = uglyNumber[i3] * 3;
            
            int i5_ugly = uglyNumber[i5] * 5;
            
            int minUglyNumber = Math.min(i2_ugly, Math.min(i3_ugly, i5_ugly));
            
            uglyNumber[i] = minUglyNumber;
            
            if(uglyNumber[i] == i2_ugly)
                i2++;
            
            if(uglyNumber[i] == i3_ugly)
                i3++;
            
            if(uglyNumber[i] == i5_ugly)
                i5++;
            
        }
        
        return uglyNumber[n];
    }
}