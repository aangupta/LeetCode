class Solution {
    public int removeDuplicates(int[] nums) {
        
        int n = nums.length;
        int index = 0;
        int start = 0;
        
        while(start < n){
            int end = start + 1;
            while(end < n && nums[start] == nums[end])
                end++;
            
            nums[index] = nums[start];
            index++;
            start = end;
        }
        
        return index;     
        
    }
}

/*TC O(n) SC O(1)*/