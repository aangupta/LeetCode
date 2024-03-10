class Solution {
    public int maxFrequencyElements(int[] nums) {
        
        int[] freq = new int[101];
        
        int maxfreq = 0;
        for(int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
            if(freq[nums[i]] > maxfreq)
                maxfreq = freq[nums[i]];
        }
        
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(freq[nums[i]] == maxfreq) count++;
        }
        
        return count;
        
    }
}