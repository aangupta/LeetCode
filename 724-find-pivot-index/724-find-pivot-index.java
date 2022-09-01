class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for(int i =0; i < nums.length; i++){
            sum += nums[i];
        }
        
        int leftSum = 0;
        
        for(int i = 0; i < nums.length; i++){
            if(sum - nums[i] == leftSum)
                return i;
            
            leftSum += nums[i];
            sum -= nums[i];
        }
        
        return -1;
        
    }
}