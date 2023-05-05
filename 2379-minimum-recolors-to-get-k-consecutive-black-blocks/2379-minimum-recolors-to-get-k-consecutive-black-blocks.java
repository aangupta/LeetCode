class Solution {
    public int minimumRecolors(String blocks, int k) {
        int currBCount = 0;
        int maxBCount = 0;
        
        // Compute count of black bloack in first window of size k
        for(int i =0; i < k; i++){
            if(blocks.charAt(i) == 'B')
                currBCount++;
        }
        
        // Compute count of black bloack in remaining windows by
        // removing first element of previous
        // window and adding last element of
        // current window.

        
        maxBCount = currBCount;
        
        for(int i = k; i < blocks.length(); i++){
            if(blocks.charAt(i - k) == 'B')
                currBCount--;
            
            if(blocks.charAt(i) == 'B')
                currBCount++;
            
            maxBCount = Math.max(currBCount, maxBCount);
        }
        
        //minimum number of operations needed to make k consecutive black blocks
        return Math.abs(maxBCount - k);
        
    }
}

/* TC O(N) SC O(1) */