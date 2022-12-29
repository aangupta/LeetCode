class Solution {
    public boolean check(int[] nums) {
        
        int k = 0;
        int n = nums.length;
        
        for(int i =1; i < n; i++){
            
            if(nums[i-1] > nums[i])
                k++;
            
            if(k > 1) return false;
        }
        
       return ((k == 1 && nums[0] >= nums[n-1] || k == 0) ? true : false);
    }
}