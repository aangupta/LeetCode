class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0, j = 0;
        int maxLength = Integer.MIN_VALUE;
        int count = 0;
        int n = nums.length;
        
        while(j < n) {
            
            if(nums[j] == 0) count++;
            
            if(count < 1) j++;
            
            else if(count == 1) {
                maxLength = Math.max(maxLength, j - i + 1);
                j++;
            }
            
            else if(count > 1) {
                while(count > 1) {
                    if(nums[i] == 0){
                        count--;
                    }
                    i++;
                }
                j++;
            }
        }
        
        return (maxLength == Integer.MIN_VALUE ? n-1 : maxLength - 1);
    }
}