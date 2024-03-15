class Solution {
    public int[] productExceptSelf(int[] nums) {
        int totalProduct = 1;
        
        int countOfZero = 0;
        int index = -1;
        for(int i = 0; i < nums.length; i++) {
            
            if(nums[i] == 0) {
                countOfZero++;
                index = i;
                continue;
            }
            
            totalProduct *= nums[i];
        }
        
        int[] result = new int[nums.length];
        
        if(countOfZero > 1) return result;
        
        if(countOfZero == 1) {
            result[index] = totalProduct;
            return result;
        }
        
        for(int i = 0; i < nums.length; i++) {
            result[i] = totalProduct / nums[i];
        }
        
        return result;
        
    }
    
    
}