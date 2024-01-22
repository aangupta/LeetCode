class Solution {
    //TC O(n^2) SC O(1)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); //O(nlogn)
        
        int closetSum = nums[0] + nums[1] + nums[2];
        
        //O(n^2)
        for(int i = 0; i < nums.length-2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum == target)
                    return target;
                
                // Update closest sum if the current sum is closer to the target
                if(Math.abs(target - sum) < Math.abs(target - closetSum))
                    closetSum = sum;
                
                if(sum < target)
                    j++; // Increment j to increase the sum
                else 
                    k--; // Decrement k to decrease the sum
            }
        }
        
        return closetSum;
    }
}