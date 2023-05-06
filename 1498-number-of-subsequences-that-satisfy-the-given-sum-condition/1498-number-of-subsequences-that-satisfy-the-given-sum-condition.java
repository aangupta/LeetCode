class Solution {
    private int mod = (int)1e9+7;
    private long power(int x, int y){
        if(y == 0) return 1;
        if(y == 1) return x;
        
        long ans = 1;
        if(y%2 == 0){
            ans = power(x, y/2);
            ans *= ans;
        } else {
            ans = power(x, y- 1);
            ans *= x;
        }
        return ans%mod;
    }
    public int numSubseq(int[] nums, int target) {
        
        Arrays.sort(nums);
        
        int start = 0; 
        int end = nums.length - 1;
        int count = 0;
        
        while(start <= end){
            
            if(nums[start] + nums[end] <= target){
                count += (int)power(2, end - start);
                count %= mod;
                start++;
            } else {
                end--;
            }
        }
        
        return count;
        
    }
}