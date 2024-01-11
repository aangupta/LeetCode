class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int num : nums){
                if(((num >> i) & 1 ) == 1)
                    sum++;
            }
            
            if(sum % 3 == 1)
                res |= 1 << i;
        }
        
        return res;
        
    }
}